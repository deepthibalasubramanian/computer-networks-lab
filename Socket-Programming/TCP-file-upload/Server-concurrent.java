import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.*;

class Child implements Runnable{
	Socket s;
	int count;

	Child(Socket c, int i){
		s = c;
		count = i;
	}

	public void run(){
		String str;
		File f=new File("client"+count+".txt");
		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new FileWriter(f));
			DataInputStream dis = new DataInputStream(s.getInputStream());
			while((str=dis.readUTF())!=null)
				pw.println(str);
		}
		catch(Exception e){
			System.out.println("File recd from Client"+count);
			pw.close();
		}
	}
}

public class Server{
	public static void main(String[] args){
		try{
			int count = 0;
			ServerSocket ss = new ServerSocket(1000);
			Socket s;
			Child c;
			while(true){
				s = ss.accept();
				++count;
				c=new Child(s,count);
				Thread t = new Thread(c);
				t.start();
				System.out.println("Client "+count+" connected");
			}
		}		
		catch(Exception e){
			System.out.println(e);
		}
	}
}
