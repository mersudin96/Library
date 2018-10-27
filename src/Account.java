
public class Account {
	int accoundID;
	String membersName;
	int numberBorrovedBooks;
	private static int numberOfAccounts;
	
	public Account() {
		numberOfAccounts++;
	}
	
	public Account(int accountID, String membersName, int numberBorrovedBooks) {
		this.accoundID=accountID;
		this.membersName=membersName;
		this.numberBorrovedBooks=numberBorrovedBooks;
		numberOfAccounts++;
	}
	
	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public void podigniKnjigu() {
		numberBorrovedBooks++;
	}
	public void vratiKnjigu() {
		numberBorrovedBooks--;
	}
	
	
	@Override
	public String toString() {
		return "\nKorisnicki ID: " + accoundID + ", \nKorisnicko ime: " + membersName + ", \nBroj podignutih knjiga: "
				+ numberBorrovedBooks + "\n";
	}
	
}
