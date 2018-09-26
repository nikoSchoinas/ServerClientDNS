import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private static final int PORT = 1234;
	private static DNSList dnsList = new DNSList();
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ServerSocket socketConn = new ServerSocket(PORT);

		while(true) {
			System.out.println("Server is waiting...");
			Socket pipe = socketConn.accept();
			System.out.println("Received request from" + pipe.getInetAddress());
			ServerThread sthread = new ServerThread(pipe,dnsList);
			sthread.start();
		}

		//serverInputStream.close();
		//serverOutputStream.close();
		//pipe.close();
		//socketConn.close();
	}

}
