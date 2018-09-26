import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	//final variables for HOST and PORT of connection
	private static final String HOST = "localhost";
	private static final int PORT = 1234;
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		//make the connection
		Socket socketConn = new Socket(HOST, PORT);

		//Streams that read or write object. In this case object can be Reply or Request.
		ObjectOutputStream clientOutputStream = new ObjectOutputStream(socketConn.getOutputStream());
		ObjectInputStream clientInputStream = new ObjectInputStream(socketConn.getInputStream());

		ClientProtocol app = new ClientProtocol();
		Request req;
		Reply rep = new Reply();
		req = app.prepareRequest();
		// repeats for ever. Asks user for choice (N,A,I,D,U), send request to server and receive reply. 
		while(true) {
			
			clientOutputStream.writeObject(req);
			rep = (Reply)clientInputStream.readObject();
			app.processReply(rep);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req = app.prepareRequest();
			
		}

		
		//clientOutputStream.close();
        //clientInputStream.close();
        
        //socketConn.close();
		
	}

}
