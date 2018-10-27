
public class Book {
	int bookID;
	String bookName;
	boolean rented;
	private static int numberOfBooks;
	
	public Book() {
		numberOfBooks++;
	}
	
	public Book(int bookId, String bookName, boolean rented) {
		this.bookID=bookId;
		this.bookName=bookName;
		this.rented=rented;
		numberOfBooks++;
	}
	
	public void setRented() {
		rented=true;
	}
	
	public static int getNumberOfBooks() {
		return numberOfBooks;
	}

	@Override
	public String toString() {
		return "Book: \nbookID=" + bookID + ", \nbookName=" + bookName + ", \nrented=" + rented + "\n";
	}
	
	
	
}
