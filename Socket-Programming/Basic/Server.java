import java.util.*;
import java.net.*;
import java.io.*;

public class Server{
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(1000);
			Socket s=ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String)dis.readUTF();
			System.out.println("mesg: "+str);
			ss.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
