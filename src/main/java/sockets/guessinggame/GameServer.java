package sockets.guessinggame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GameServer {
    public static final String END_GAME = "END";
    public static final String SHUTDOWN = "SHUTDOWN";
    public static final int PORT = 8000;
    private ExecutorService poolManager;

    private static volatile boolean isShutdown;
    private static ServerSocket welcomingSocket = null;


    public GameServer() {
        poolManager = Executors.newFixedThreadPool(4);
        isShutdown = false;
    }

    public void runServer() {
        try {
            welcomingSocket = new ServerSocket(PORT);
            System.out.println("Waiting for a client to join the game ...");
            while (!isShutdown) {
                Socket connectionSocket = welcomingSocket.accept();
                poolManager.submit(new GameWorker(connectionSocket));
            }
        }
        catch (IOException e) {
            System.out.println(e); // exception here when the worker closes the welcoming socket
        }
        finally {
            if (isShutdown) {
                try {
                    welcomingSocket.close();
                    System.out.println("Welcoming socket closed? " + welcomingSocket.isClosed());
                    System.out.println("Shutting down the pool.");
                    poolManager.shutdown();
                    poolManager.awaitTermination(2, TimeUnit.SECONDS)
;                } catch (IOException | InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    /** A server "helper" - plays the game with one client */
    static class GameWorker implements Runnable {
        private Socket socket;
        private int numberToGuess = 0;
        public GameWorker(Socket socket) {
            this.socket = socket;
            numberToGuess = (int)(10 * Math.random());
            System.out.println("Do not tell anyone: the number I guessed is " + numberToGuess);
        }


        @Override
        public void run() {
            System.out.println("A client connected.");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                String input;
                writer.println("Server: I guessed a number from 0 to 10, guess it: ");
                while (!socket.isClosed()) {
                    input = reader.readLine();
                    System.out.println("Server received: " + input);
                    if (input.equals(END_GAME)) {
                        System.out.println("Server: Client requested to stop the game. Closing socket.");
                        socket.close();
                    } else if (input.equals(SHUTDOWN)) {
                        isShutdown = true;
                        System.out.println("Server helper: Shutting down.");
                        welcomingSocket.close();
                        socket.close();
                    }
                    else {
                        int num = Integer.parseInt(input);
                        if (num == numberToGuess) {
                            System.out.println("Client guessed correctly.");
                            writer.println("Server: Correct guess! Game over.");
                            socket.shutdownInput();
                            socket.shutdownOutput();
                            socket.close();
                        } else if (num < numberToGuess) {
                            System.out.println(num);
                            writer.println("Server: Your guess is too low");
                        }
                        else {
                            System.out.println(num);
                            writer.println("Server: Your guess is too high");
                        }

                    }
                }
            }
            catch (IOException e) {
                System.out.println(e);
            }
            finally {
                try {
                    if (socket != null)
                        socket.close();
                }
                catch (IOException e) {
                    System.out.println("Can't close the socket : " + e);
                }

            }

        }
    }

    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.runServer();

    }
}
