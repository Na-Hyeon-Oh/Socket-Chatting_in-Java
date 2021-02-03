import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket ss;
		Scanner scn=new Scanner(System.in);
		System.out.println("server start");
		try {
			ss=new ServerSocket(5000);
			Socket soc=ss.accept();
			OutputStream out=soc.getOutputStream();
			DataOutputStream dos= new DataOutputStream(out);
			while(true) {
				dos.writeUTF(scn.nextLine());
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		scn.close();
	}

}
