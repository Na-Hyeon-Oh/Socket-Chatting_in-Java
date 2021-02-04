import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server extends Thread{
	private ServerSocket serverSocket;
	
	public Server(int port) throws IOException{
		serverSocket=new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}
	
	//mult-threading
	public void run() {
		while(true) {
			try {
				System.out.println("Waiting for client on port "+serverSocket.getLocalPort()+"...");
				
				//connection to client
				Socket server=serverSocket.accept();
				System.out.println("Just connected to "+server.getRemoteSocketAddress());
				
				//in-stream
				InputStream inFromClient=server.getInputStream();
				DataInputStream in=new DataInputStream(inFromClient);
				System.out.println(in.readUTF());
				
				//out-stream
				OutputStream outToClient=server.getOutputStream();
				DataOutputStream out=new DataOutputStream(outToClient);
				out.writeUTF("Connection Completed to "+server.getLocalSocketAddress());
				
				//out-stream2
				Scanner scn=new Scanner(System.in);
				while(in!=null) {
					System.out.println("From Client : \""+in.readUTF()+"\"");
				
					out.writeUTF(scn.nextLine());
				}
				
				server.close();
				
			} catch(SocketTimeoutException s) {
				System.out.println("Socket time out !");
				break;
			} catch(IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		//int port=Integer.parseInt(args[0]);
		int port=5000;
		
		try {
			Thread t=new Server(port);
			t.start();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}