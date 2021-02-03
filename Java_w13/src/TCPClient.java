import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) {
		String serverIP="localhost";
		Socket soc;
		try{
			soc=new Socket(serverIP,5000);
			InputStream in=soc.getInputStream();
			DataInputStream dis=new DataInputStream(in);
			while(true) {
				System.out.println(dis.readUTF());
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
