import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class TCPClient {
	public static void main(String[] args) {
		String serverIP="localhost";
		Socket soc;
		String ack="received !";
		
		try{
			soc=new Socket(serverIP, 5000);
			InputStream in=soc.getInputStream();
			DataInputStream dis=new DataInputStream(in);
			while(true) {
				System.out.println(dis.readUTF());
				
				//for ack
				OutputStream out=soc.getOutputStream();
				DataOutputStream dos= new DataOutputStream(out);
				dos.writeUTF(ack);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
