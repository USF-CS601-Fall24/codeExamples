package sockets;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
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
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			String input = null;
			while (!socket.isClosed()) {
				input = sc.nextLine(); // read keyboard input
				writer.println(input); // send the message to the server via the socket

				if (input.equals(SimpleServer.EOT)) {
					System.out.println("Client: Ending client.");
					 socket.close();
				} else if (input.equals(SimpleServer.SHUTDOWN)) {
					System.out.println("Client: Shutting down server.");
					socket.close();
				}
			}
			writer.close();
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