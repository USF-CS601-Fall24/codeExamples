package multithreading.synchronization.barriers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/** Multithreaded file word counter, uses Phaser */
public class MultiThreadedFileWordCounterWithPhaser {
    private int count;
    private ExecutorService poolManager = Executors.newCachedThreadPool();
    private Phaser phaser = new Phaser();

    public MultiThreadedFileWordCounterWithPhaser(){
        count = 0;
    }

    class CounterWorker implements Runnable {
        private Path file;

        public CounterWorker(Path file) {
            this.file = file;
        }

        @Override
        public void run() {
            int localWordCount = 0;
            // System.out.println(file);
            try (BufferedReader br = Files.newBufferedReader(file)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = line.split("[,;!\\. ]");
                    // System.out.println(Arrays.toString(words));
                    localWordCount += words.length;
                }
                updateCount(localWordCount);

            } catch (IOException e) {
                System.out.println(e);
            } finally {
                phaser.arriveAndDeregister();
            }
        }
    }

    public synchronized int updateCount(int localWordCount) {
        count += localWordCount;
        return count;
    }

    public synchronized int getCount() {
        return count;
    }

    public void countWordsInFiles(Path directory) {
            try (DirectoryStream<Path> filesAndFolders = Files.newDirectoryStream(directory)) {
                for (Path path: filesAndFolders) {
                    if (Files.isDirectory(path))
                        countWordsInFiles(path);
                    else {
                        // System.out.println(path);
                        if (path.toString().endsWith(".txt")) {
                            poolManager.submit(new CounterWorker(path));
                            phaser.register();
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }


        public void waitToFinish() {
            phaser.awaitAdvance(0); // wait for all registered tasks to arrive/deregister
            poolManager.shutdownNow(); // shutdown the pool immediately
        }

        public static void main(String[] args) {
            MultiThreadedFileWordCounterWithPhaser fileCounter = new MultiThreadedFileWordCounterWithPhaser();
            fileCounter.countWordsInFiles(Paths.get("dir"));
            fileCounter.waitToFinish();
            System.out.println(fileCounter.getCount());

        }
    }
