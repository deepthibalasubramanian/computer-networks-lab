import java.util.*;
import java.net.*;
import java.io.*;

public class Server{
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(1000);
			Socket s=ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str1 = "";
			String str2="";
			while(!str1.equals("Stop")){
				str1=dis.readUTF();
				System.out.println("Msg: "+str1);
				str2 = br.readLine();
				dos.writeUTF(str2);
				dos.flush();
			}
			dis.close();
			s.close();
			ss.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
