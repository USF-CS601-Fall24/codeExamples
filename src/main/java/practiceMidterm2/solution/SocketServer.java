package practiceMidterm2.solution;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {
    public static final int PORT = 8080;
    public static void main(String[] args) throws IOException {
        ExecutorService poolManager  = Executors.newCachedThreadPool();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT + "...");

            while (true) {
                try {
                    Socket socket = serverSocket.accept(); // Do not use try-with-resources here
                    poolManager.submit(() -> {
                        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                             String clientRequest = reader.readLine();
                             writer.println(new StringBuilder(clientRequest).reverse());
                        } catch (IOException e) {
                            System.out.println("Error in worker thread: " + e);
                        } finally {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                System.out.println("Failed to close socket: " + e);
                            }
                        }
                    });
                } catch (IOException e) {
                    System.out.println("Error accepting connection: " + e);
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e);
        } finally {
            poolManager.shutdown();
        }
    }
}
