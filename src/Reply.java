import java.io.Serializable;

public class Reply implements Serializable {
	private String somethingToReturn;
	
	public Reply() {
		somethingToReturn = null;
	}

	public String getSomethingToReturn() {
		return somethingToReturn;
	}

	public void setSomethingToReturn(String somethingToReturn) {
		this.somethingToReturn = somethingToReturn;
	}
	
	
}
