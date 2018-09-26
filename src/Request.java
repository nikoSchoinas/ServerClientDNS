import java.io.Serializable;

public class Request implements Serializable{
	private char opcode;
	private String ip;
	private String name;
	
	public Request(char opcode, String ip, String name) {
		super();
		this.opcode = opcode;
		this.ip = ip;
		this.name = name;
	}

	public char getOpcode() {
		return opcode;
	}

	public String getIp() {
		return ip;
	}

	public String getName() {
		return name;
	}
	
	
}
