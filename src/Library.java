import java.util.ArrayList;
import java.util.Scanner;

public class Library {
	
	static ArrayList<LogFile>Log=new ArrayList<>();
	static ArrayList<Account>AccountList=new ArrayList<>();
	static ArrayList<Book>BookList=new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner unos=new Scanner(System.in);
		int izborKor;
		System.out.println("\t * Dobrodosli! *");
		do {
			System.out.println("\n"
					+ "1. - Kreiranje racuna \n"
					+ "2. - Kreiranje knjiga \n"
					+ "3. - Podizanje knjiga na neki period \n"
					+ "4. - Vracanje knjige \n"
					+ "5. - Ispisvanje detalja postojecih racuna \n"
					+ "6. - Log izdavanja knjiga \n"
					+ "0. - Izlaz");
			
			izborKor=unos.nextInt();
			switch(izborKor) {
			case 1:
				Account account=new Account();
				AccountList.add(Account.getNumberOfAccounts()-1, account);
				System.out.print("Unesite vase ime: ");
				String ime=unos.next();
				account.membersName=ime;
				account.accoundID=Account.getNumberOfAccounts();
				System.out.println("Racun uspjesno kreiran. " +ime +" vas ID broj je " +account.accoundID);
				break;
			case 2:	
				Book book=new Book();
				BookList.add(Book.getNumberOfBooks()-1, book);
				System.out.print("Unesite naziv knjige: ");
				String naziv=unos.next();
				book.bookName=naziv;
				book.bookID=Book.getNumberOfBooks()+1000;
				System.out.println("Knjiga uspjesno dodana u biblioteku. ID knjige : " +book.bookID);
				break;
			case 3:
				RentBook rentBook=new RentBook();
				System.out.print("Unesite vas ID broj: ");
				int idKor=unos.nextInt();
				rentBook.accountID=idKor;
				System.out.print("Unesite ID knjige koju zelite iznajmiti: ");
				int idKnjige=unos.nextInt();
				rentBook.bookID=idKnjige;
				rentBook.borrowBook();
				if(rentBook.postoji) {
					LogFile log=new LogFile();
					log.accountID=idKor;
					log.bookID=idKnjige;
					log.status="Izdato";
					Log.add(log);
				}
				break;
			case 4:
				System.out.print("Koju knjigu vracate: ");
				int knjigaID=unos.nextInt();
				System.out.print("Koji je vas ID broj: ");
				int korID=unos.nextInt();
				boolean praviClan=true;
				for(int i=0; i<Log.size(); i++) {
					if(Log.get(i).accountID!=korID && Log.get(i).bookID==knjigaID) {
						System.out.println("Ne mozete vi vracati knjige za nekoga.");
						praviClan=false;
					}
				}
				if(praviClan) {
					RentBook vracanjeKnjige=new RentBook(korID, knjigaID);
					vracanjeKnjige.returnBook();
					if(vracanjeKnjige.postoji) {
						LogFile log2=new LogFile();
						log2.accountID=korID;
						log2.bookID=knjigaID;
						log2.status="Vraceno";
						Log.add(log2);
					}
				}
				
				break;
			case 5:
				System.out.println();
				for(int k=0; k<AccountList.size(); k++)
					System.out.println(AccountList.get(k).toString());
				break;
			case 6:
				System.out.println();
				for(int k=0; k<Log.size(); k++) {
					for(int l=0; l<Log.size(); l++) {
						if(Log.get(k).bookID==Log.get(l).bookID && k!=l && Log.get(k).status.equals("Izdato"))
							System.out.println(Log.get(k).toString() +"\n\n" +Log.get(l).status +"\n" +Log.get(l).datum +"\n");
						else {
							if(Log.get(k).status.equals("Izdato") && l==Log.size()-1 &&k!=0)
								System.out.println(Log.get(k).toString() +"\n\nStatus: - \nDatum vracanja: -\n" );
						}
					}
				}
				break;
			case 0:
				System.out.println("\t\tArivederci.");
				break;
			default: System.out.println("Pogresan unos.");
			}
		}while(izborKor!=0);
		unos.close();
	}
}