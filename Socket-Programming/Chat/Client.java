import java.util.*;
import java.net.*;
import java.io.*;

public class Client{
	public static void main(String [] args){
		try{
			Socket s = new Socket("localhost",1000);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str1 = "";
			String str2="";
			while(!str1.equals("Stop")){
				str1=br.readLine();
				dos.writeUTF(str1);
				dos.flush();
				str2=dis.readUTF();
				System.out.println("Serv msg: "+str2);
			}
			dos.close();
			s.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
