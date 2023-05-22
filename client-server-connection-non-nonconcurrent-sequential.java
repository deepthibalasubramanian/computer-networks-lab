//parent and child run sequentially

//client
import java.io.*;
import java.net.*;
import java.util.*;
public class TCPFileClient
{
	public static void main(String str[]) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the file name to upload");
		File f=new File(sc.next());
		Scanner sc2=new Scanner(f);
		Socket s=new Socket("localhost",10000);
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		while(sc2.hasNext())
		{
			dos.writeUTF(sc2.nextLine());
		}
		s.close();
		dos.close();
	}
}

//server
import java.io.*;
import java.net.*;
import java.util.*;
public class TCPFileServer
{
	public static void main(String str[]) throws Exception
	{
		int count=0;
		ServerSocket ss=new ServerSocket(10000);
		Socket cs;
		String st;
		DataInputStream dis;
		while(true)
		{
			cs=ss.accept();
			++count;
			System.out.println("client"+count+" connected");
			File f=new File("client"+count+".txt");
			PrintWriter pw=new PrintWriter(new FileWriter(f));
			dis=new DataInputStream(cs.getInputStream());
			try
			{
			while((st=dis.readUTF())!=null)
			{
				pw.println(st);
			}
			}
			catch(Exception e)
			{
				System.out.println("File received from client"+count);
				pw.close();
			}
		}
	}
}
