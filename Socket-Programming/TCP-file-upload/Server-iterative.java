import java.util.*;
import java.net.*;
import java.io.*;

public class Server{
	public static void main(String[] args){
		try{
			int count = 0;
			ServerSocket ss = new ServerSocket(1000);
			Socket s;
			DataInputStream dis;
			String str = "";
			while(true){
				s = ss.accept();
				++count;
				System.out.println("Client "+count+" connected");
				File f=new File("client"+count+".txt");
				PrintWriter pw = new PrintWriter(new FileWriter(f));
				dis = new DataInputStream(s.getInputStream());
				try{
					while((str=dis.readUTF())!=null)
						pw.println(str);
				}
				catch(Exception e){
					System.out.println("File recd from Client"+count);
					pw.close();
				}
			}
		}		
		catch(Exception e){
			System.out.println(e);
		}
	}
}
