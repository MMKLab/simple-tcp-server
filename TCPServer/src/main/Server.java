package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws Exception {
		
		int portNumber = 12000;
		
		BufferedReader clientInputStream;
		PrintStream clientOutputStream;
		
		ServerSocket serverSocket = new ServerSocket(portNumber);
		
		while(true) {
			System.out.println("Waiting for a connection...");
			
			Socket communicationSocket = serverSocket.accept();
			System.out.println("A connection has been made!");
			
			clientInputStream = new BufferedReader(new InputStreamReader(communicationSocket.getInputStream()));
			clientOutputStream = new PrintStream(communicationSocket.getOutputStream());
			
			String input = clientInputStream.readLine();
			
			String result = "";
			
			for (int i = input.length()-1; i>=0; i--) {
				result += input.charAt(i);
			}
			
			clientOutputStream.println(result);				
		}		
	}	
}
