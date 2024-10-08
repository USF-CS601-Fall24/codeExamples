package multithreading.synchronization.lab10_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/** Multithreaded version of FileWordCounter - different files are processed concurrently */
public class MultiThreadedFileWordCounter {
    private int count;
    private final ExecutorService poolManager = Executors.newCachedThreadPool();

    public MultiThreadedFileWordCounter() {
        count = 0;
    }

    /** One Callable task - responsible for parsing one file and counting words in that file */
    class CounterWorker implements Callable<Integer> {
        private final Path file;

        public CounterWorker(Path file) {
            this.file = file;
        }

        @Override
        public Integer call() {
            int localWordCount = 0;
            //System.out.println(file);
            try (BufferedReader br = Files.newBufferedReader(file)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = line.split("[,;!\\. ]+");
                    //System.out.println(Arrays.toString(words));
                    localWordCount += words.length; // since localWordCount is a local variable, we do not need to synchronize access to it
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            return localWordCount; // Return the number of words in this file
        }
    }

    // If only the main thread calls methods above after all Callable tasks are done, then these
    // methods did not have to be synchronized. If we change the solution so that each worker updates the total count at the end of call(),
    // then updateCount() and getCount() would need to be synchronized.
    /**
     * Update the total count given the local count
     * @param localWordCount number of words in one file
     */
    public synchronized void updateCount(int localWordCount) {
        count += localWordCount;
    }

    /** Get the total count
     *
     * @return total number of words
     */
    public synchronized int getCount() {
        return count;
    }

    /**
     * Traverse a given directory, for each .txt file, add a new Callable worker to the pool of threads (executor service,
     * store the result of each task in the Future.
     * @param directory directory with files and subdirectories
     * @param futures list of Future tasks to store the word count in each file
     */
    public void countWordsInFiles(Path directory, List<Future<Integer>> futures) {
        try (DirectoryStream<Path> filesAndFolders = Files.newDirectoryStream(directory)) {
            for (Path path : filesAndFolders) {
                if (Files.isDirectory(path)) {
                    countWordsInFiles(path, futures);
                } else if (path.toString().endsWith(".txt")) {
                    // Submit a task for each file to the pool
                    // Save the result to the Future (the result will be the count of words in a given file).
                    Future<Integer> future = poolManager.submit(new CounterWorker(path));
                    futures.add(future);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    /** The function that will be called from main - will call the recursive
     * method  countWordsInFiles, then will wait for each Future to complete before updating the total.
     * @param dir directory with files and subdirectories
     */
    public void traverse(Path dir) {
        List<Future<Integer>> futures = new ArrayList<>();
        countWordsInFiles(dir, futures);
        for (Future<Integer> future : futures) {
            try {
                int localCount = future.get(); // wait for the result of the task
                updateCount(localCount); // Update the total count of words
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            }
        }
    }


    /** Shutdows the executor service
     *
     */
    public void shutdownPool() {
        poolManager.shutdown();  // tell the pool not to accept new tasks
        try {
            poolManager.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // wait for current tasks to finish - not really needed in this example, since we previously waited for all futures to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        MultiThreadedFileWordCounter fileCounter = new MultiThreadedFileWordCounter();
        fileCounter.traverse(Paths.get("dir"));
        fileCounter.shutdownPool();
        System.out.println(fileCounter.getCount());
    }
}
