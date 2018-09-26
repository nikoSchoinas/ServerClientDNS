
public class ServerProtocol {
	private DNSList dnsList;

	public ServerProtocol(DNSList list) {
		dnsList = list;
	}
	public Reply processRequest(Request theInput) {
		Reply rep = dnsList.executeRequest(theInput);
		return rep;
	}
}
