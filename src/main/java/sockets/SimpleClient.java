package sockets;

import java.io.*;
import java.net.Socket;
import java.util.BitSet;
import java.util.Scanner;

/**
 * SimpleClient: Reads input from the keyboard and sends it to the server via
 * the socket. File is modified from the code of Prof. Engle
 *
 */
public class SimpleClient extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("Client: Started...");
			// Sends a connection request to the server that is running on
			// a given host, "listening" on the given port
			Socket socket = new Socket("localhost", SimpleServer.PORT); // running on the local machine

			// For reading user keyboard input from the console
			// (has nothing to do with sockets!)
			Scanner sc  = new Scanner(System.in);

			// For writing to the socket (so that the server could get client messages)
			try(PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
				String input = null;
				while (!socket.isClosed()) {
					input = sc.nextLine(); // read keyboard input
					writer.println(input); // send the message to the server via the socket

					String messageFromServer = br.readLine();
					System.out.println("I (client) received the following from the server: " + messageFromServer);

					if (input.equals(SimpleServer.EOT)) {
						System.out.println("Client: Ending client.");
						socket.close();
					} else if (input.equals(SimpleServer.SHUTDOWN)) {
						System.out.println("Client: Shutting down server.");
						socket.close();
					}
				}
			}
			catch (IOException e) {
				System.out.println(e);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String[] args) {
		SimpleClient client = new SimpleClient();
		client.start();
		try {
			client.join();
		} catch (InterruptedException e) {
			System.out.println("The thread got interrupted " + e);
		}
	}
}