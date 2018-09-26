import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket pipe;
	private ObjectInputStream serverInputStream;
	private ObjectOutputStream serverOutputStream;
	private DNSList dnsList;
	
	public ServerThread(Socket socket, DNSList list) {
		pipe = socket;
		
		try {
			serverInputStream = new ObjectInputStream(pipe.getInputStream());
			serverOutputStream = new ObjectOutputStream(pipe.getOutputStream());
			dnsList = list;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void run() {
		Reply rep = new Reply();
		Request req;
		
		try {
			req = (Request) serverInputStream.readObject();
			ServerProtocol serverProt = new ServerProtocol(dnsList);
			rep = serverProt.processRequest(req);
			while(true) {
				
				serverOutputStream.writeObject(rep);
				serverOutputStream.reset();
				req = (Request) serverInputStream.readObject();
				rep = serverProt.processRequest(req);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
