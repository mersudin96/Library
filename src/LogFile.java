
public class LogFile extends RentBook{
	
	String status;

	public LogFile(String status) {
		super();
		this.status = status;
		
	}
	
	public LogFile() {
		super();
	}

	@Override
	public String toString() {
		return "\nBookID: " +bookID +"\nAccount ID: " +accountID +"\nStatus: " +status +"\nDatum: " +datum;
	}
	
}
