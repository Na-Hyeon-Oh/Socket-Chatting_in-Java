import java.net.*;
import java.io.*;

public class Client {
	
	public static void main(String[] args) {
		//String serverName=args[0];
		//int port=Integer.parseInt(args[1]);
		
		String serverName="localhost";
		int port=5000;
		
		try {
			//connection
			System.out.println("Connecting to "+serverName+" on port "+port);
			Socket client=new Socket(serverName, port);
			
			System.out.println("Completion : Just connected to "+client.getRemoteSocketAddress());
			
			//out-stream
			OutputStream outToServer=client.getOutputStream();
			DataOutputStream out=new DataOutputStream(outToServer);
			out.writeUTF("Connected to client : "+client.getLocalSocketAddress());
			
			//in-stream
			InputStream inFromServer=client.getInputStream();
			DataInputStream in=new DataInputStream(inFromServer);
			while(in!=null) {
				System.out.println("From Server : \""+in.readUTF()+"\"");
				
				//acknowledge
				out.writeUTF("Ack : Received");
			}
			client.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}