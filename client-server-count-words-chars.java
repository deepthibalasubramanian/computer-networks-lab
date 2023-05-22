//SERVER SIDE PROGRAM:
import java.net.*;
import java.io.*;
public class SimpleTCPServer5601 {
 public static void main(String args[]) {
 int port = 3000;
 try (ServerSocket serverSocket = new ServerSocket(port)) {
 System.out.println("Server started and listening on port " + port);
 while (true) {
 Socket clientSocket = serverSocket.accept();
 System.out.println("Client connected: " +
clientSocket.getInetAddress().getHostAddress());
 //Creating a new thread to handle the client request
 Thread thread = new Thread(() -> {
 try {
 handleClientRequest(clientSocket);
 } catch (IOException e) {
 e.printStackTrace();
 }
 });
 thread.start();
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 private static void handleClientRequest(Socket clientSocket) throws IOException {
 BufferedReader reader = new BufferedReader(new
InputStreamReader(clientSocket.getInputStream()));
 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
 String sentence = reader.readLine();
 System.out.println("Input received from client: " + sentence);
 int charCount = sentence.length();
 int wordCount = countWords(sentence);
 String response = "Number of words: " + wordCount + "\nNumber of characters: " +
charCount;
 writer.println(response);

 System.out.println("Word count sent to client: " + wordCount);
 System.out.println("Character count to client: " + charCount);
 writer.close();
 reader.close();
 clientSocket.close();
 }
 private static int countWords(String input) {
 if (input.isEmpty()) {
 return 0;
 }
 String[] words = input.trim().split("\\s+");
 return words.length;
 }
}

//CLIENT SIDE PROGRAM:
import java.net.*;
import java.io.*;
import java.util.Scanner;
public class SimpleTCPClient5601 {
 public static void main(String args[]) {
 String serverAddress = "127.0.0.1";
 int serverPort = 3000;
 try (Socket socket = new Socket(serverAddress, serverPort);
 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
 BufferedReader reader = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
 Scanner scanner = new Scanner(System.in)) {
 System.out.println("Connected to server: " + serverAddress + ":" + serverPort);
 System.out.println("Enter the input statement: ");
 String input = scanner.nextLine();
 writer.println(input);
 String response;
 while ((response = reader.readLine()) != null) {
 System.out.println(response);
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}
