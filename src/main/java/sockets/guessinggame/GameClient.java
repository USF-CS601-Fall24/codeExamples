package sockets.guessinggame;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GameClient implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Client: Started...");
            Socket socket = new Socket("localhost", GameServer.PORT);

            Scanner sc  = new Scanner(System.in);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
                String input = null;
                System.out.println(reader.readLine());

                while (!socket.isClosed()) {
                    input = sc.nextLine(); // read keyboard input

                    if (input.equals(GameServer.END_GAME)) {
                        writer.println(input);
                        System.out.println("Client: Ending game.");
                        socket.close();
                    } else if (input.equals(GameServer.SHUTDOWN)) {
                        System.out.println("Client: Shutting down server.");
                        writer.println(input);
                        socket.close();
                    }
                    else {
                        int num = Integer.parseInt(input);
                        writer.println(num);
                        String line = reader.readLine();
                        System.out.println(line);
                        if (line.equals("Server: Correct guess! Game over.")) {
                            socket.shutdownInput();
                            socket.shutdownOutput();
                            socket.close();
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        GameClient client = new GameClient();
        Thread t1 = new Thread(client);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("The thread got interrupted " + e);
        }
    }
}
