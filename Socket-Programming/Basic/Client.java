import java.util.*;
import java.net.*;
import java.io.*;

public class Client{
	public static void main(String [] args){
		try{
			Socket s = new Socket("localhost",1000);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("Hello");
			dos.flush();
			dos.close();
			s.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
