import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientProtocol {
	String name; //= null;
	String ip; //= null;
	Request req; //= null;
	BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
	
	public Request prepareRequest() throws IOException {
		System.out.println("\n******Make your choice******");
		System.out.println("Press 'N' for Searching by Name");
		System.out.println("Press 'A' for Searching by Address");
		System.out.println("Press 'I' for Insertion");
		System.out.println("Press 'D' for Deletion");
		System.out.println("Press 'U' for Update");
		
		//char inputChar = (char) System.in.read();
		String inputString = user.readLine();
		char inputChar = inputString.charAt(0);
		
		//char inputChar = 'I';
		switch (inputChar) {
		case 'N':
			System.out.println("Please, type the Domain Name: \n");
			name = user.readLine();
			ip = null;
			break;
		case 'A':
			System.out.println("Please, type the IP address: ");
			ip = user.readLine();
			name = null;
			break;
		case 'I':
			System.out.println("Please, type IP: ");
			ip = user.readLine();
			System.out.println("Please, type domain name: ");
			name = user.readLine();
			break;
		case 'D':
			System.out.println("Please, type IP or domain name for deletion");
			String inputForDelete = user.readLine();
			ip = inputForDelete;
			name = inputForDelete;
			break;
		case 'U':
			System.out.println("If you want to update the IP address, type the new IP and the old domain");
			System.out.println("If you want to update the domain name, type the new domain name and the old IP address");
			System.out.println("Please, type the IP address");
			ip = user.readLine();
			System.out.println("Please, type the domain name: ");
			name = user.readLine();
			break;
			
		default:
			System.out.println("Something went wrong!");
			ip = null;
			name = null;
			break;
		}
		req = new Request(inputChar,ip,name);
		return req;
		
	}
	
	public void processReply(Reply rep) {
		System.out.println("Reply: " + rep.getSomethingToReturn());
	}
}
