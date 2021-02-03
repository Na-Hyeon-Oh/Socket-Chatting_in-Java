import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

public class CommThread extends Thread{
	private Socket soc;
	private int id;
	public CommThread(Socket soc, int id) {
		this.soc=soc;
		this.id=id;
	}
	
	public void run() {
		try {
			OutputStream os=soc.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			
			dos.writeUTF("message from server ("+id+")");
			System.out.println(Server.getLog("message is sent ("+id+")"));
			
			dos.close();
			this.soc.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
