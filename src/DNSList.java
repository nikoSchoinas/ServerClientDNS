import java.util.ArrayList;

public class DNSList {
	private static volatile ArrayList<DNSEntry> dnsList;
	
	public DNSList() {
		dnsList = new ArrayList<DNSEntry>();
	}
	
	public synchronized Reply executeRequest(Request theInput) {
		char opcode = theInput.getOpcode();
		String ip = theInput.getIp();
		String name = theInput.getName();
		Reply res = new Reply();

		/*case N: Search by Name. Check every DNSEntry item in list and if there is the domain name return the IP address*/
		/*case A: Search by Address (IP). Check every DNSEntry item in list and if there is the IP return the domain name*/
		/*case I: Insert an entry. User types IP and domain name. Program checks if there is a same entry. If not return OK else return ERR*/
		/*case D: Delete an entry. User types IP or domain name for delete. Program searches for that entry. If it exists, delete it and return OK, else return ERR*/
		/*case U: Update an entry. User types new IP address and old domain name (or the opposite). Program finds that entry */
		/*and if exists it replace it with the new one and return OK. Else return ERR*/
		
		switch (opcode) {
		case 'N':
			res.setSomethingToReturn("ERR");
			for (DNSEntry tmp : dnsList) {
				if (tmp.getName().equals(name)) {
					
					//reading demands small amount of time 10ms
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					res.setSomethingToReturn(tmp.getIp());
					break;
					
				}
			}
			break;
		case 'A':
			res.setSomethingToReturn("ERR");
			for (DNSEntry tmp : dnsList) {
				if (tmp.getIp().equals(ip)) {
					
					
					//reading demands small amount of time 10ms
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					res.setSomethingToReturn(tmp.getName());
					break;
				}
			}
			break;
		case 'I':
			res.setSomethingToReturn("ERR");
			boolean canAdd = true;
			for (DNSEntry tmp : dnsList) {
				if (tmp.getIp().equals(ip) || tmp.getName().equals(name)) {
					canAdd = false;
					break;
				}			
			}
			if(canAdd) {
				DNSEntry tempDNSEntry = new DNSEntry(ip,name);
				dnsList.add(tempDNSEntry);
				
				//writing demands big amount of time. 100ms
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				res.setSomethingToReturn("OK");
			}
			break;
		case 'D':
			res.setSomethingToReturn("ERR");
			for (DNSEntry tmp : dnsList) {
				if (tmp.getIp().equals(ip) || tmp.getName().equals(name)) {
					dnsList.remove(tmp);
					//deleting demands big amount of time. 100ms
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					res.setSomethingToReturn("OK");
					break;
				}
			}
			break;
		case 'U':
			res.setSomethingToReturn("ERR");
			for (DNSEntry tmp : dnsList) {
				if (tmp.getIp().equals(ip) || tmp.getName().equals(name)) {
					dnsList.remove(tmp);
					DNSEntry tempDNSEntry = new DNSEntry(ip,name);
					dnsList.add(tempDNSEntry);
					
					//writing demands big amount of time. 100ms
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					res.setSomethingToReturn("OK");
					break;
				}
			}
			break;
		default:
			//System.out.println("In default");
			res.setSomethingToReturn("ERR");

		}
		return res;
	}
}
