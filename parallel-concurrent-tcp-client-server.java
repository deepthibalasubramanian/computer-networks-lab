//concept: multi threading

//server code
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;


class Child implements Runnable{
Socket cs;
int count;

Child(Socket c,int co){
cs=c;
count=co;
}

public void run(){
String st;
File f=new File("client"+count+".txt");
			PrintWriter pw=null;
			
			
			try
			{
			pw=new PrintWriter(new FileWriter(f));
			DataInputStream dis=new DataInputStream(cs.getInputStream());
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

public class TCPFileServerthread
{
	public static void main(String str[]) throws Exception
	{
		int count=0;
		ServerSocket ss=new ServerSocket(10000);
		Socket cs;
		Child c;
		while(true)
		{
			cs=ss.accept();
			++count;
			c=new Child(cs,count);
			Thread t=new Thread(c);
			t.start();
			System.out.println("client"+count+" connected");
			
}}}


//client code
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

