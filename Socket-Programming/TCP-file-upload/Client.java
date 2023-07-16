import java.util.*;
import java.net.*;
import java.io.*;

public class Client{
	public static void main(String [] args){
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter file name to upload:");
			File f = new File(sc.next());
			Scanner sc2 = new Scanner(f);

			Socket s = new Socket("localhost",1000);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			while(sc2.hasNext()){
				dos.writeUTF(sc2.nextLine());
			}
			dos.close();
			s.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
