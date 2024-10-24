package sockets;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * VerySimpleClient: sends fixed strings to the server via
 * the socket.
 *
 */
public class VerySimpleClient extends Thread {
	@Override
	public void run() {
		PrintWriter writer = null;
		try {
			System.out.println("Client: Started...");
			// Sends a connection request to the server that is running on
			// a given host, "listening" on the given port
			Socket socket = new Socket("localhost", SimpleServer.PORT); // running on the local machine

			String[] messages = {"Hello, server", "The weather is nice today"};

			// For writing to the socket (so that the server could get client messages)
			writer = new PrintWriter(socket.getOutputStream(), true);

			int i = 0;
			while (i < messages.length &&!socket.isClosed()) {
				writer.println(messages[i]); // send the message to the server via the socket
				//System.out.println(messages[i]);
				i++;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		finally {
			if (writer != null)
				writer.close();
		}
	}

	public static void main(String[] args) {
		VerySimpleClient client = new VerySimpleClient();
		client.start();
		try {
			client.join();
		} catch (InterruptedException e) {
			System.out.println("The thread got interrupted " + e);
		}
	}
}