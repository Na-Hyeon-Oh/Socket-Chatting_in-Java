import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

class Test extends Thread{
	public void run() {
		try {
			Socket soc=new Socket("localhost",5000);
			DataInputStream dis=new DataInputStream(soc.getInputStream());
			
			System.out.println(dis.readUTF());
			
			dis.close();
			soc.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

public class Clients {
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			new Test().start();
		}
	}
}
