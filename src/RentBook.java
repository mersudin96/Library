import java.util.Date;

public class RentBook extends Library {
	int accountID;
	int bookID;
	Date datum;
	boolean postoji;
	
	
	public RentBook() {
		datum=new Date();
	}
	
	public RentBook(int accountId, int bookID) {
		this.accountID=accountId;
		this.bookID=bookID;
		datum=new Date();
	}
	
	public void borrowBook() {
		boolean postojeciRacun=false;
		boolean postojecaKnjiga=false;
		int indexKnjige=0;
		int indexAccounta=0;
		int brojPodignutih=5;
		for(int i=0; i<AccountList.size() ; i++) {
			if(AccountList.get(i).accoundID==accountID) {
				postojeciRacun=true;
				indexAccounta=i;
				brojPodignutih=AccountList.get(i).numberBorrovedBooks;
			}
		}
		for(int j=0; j<BookList.size(); j++) {
			if(BookList.get(j).bookID==bookID) {
				postojecaKnjiga=true;
				indexKnjige=j;
			}
		}
		
		if(postojecaKnjiga && postojeciRacun && brojPodignutih<3) {
			if(BookList.get(indexKnjige).rented)
				System.out.println("Zao nam je. Ta knjiga je vec izdata.");
			else {
				System.out.println("\tUzivajte u citanju :).");
				BookList.get(indexKnjige).rented=true;
				AccountList.get(indexAccounta).podigniKnjigu();
				postoji=true;
			}
		}
		else if(postojecaKnjiga && postojeciRacun && brojPodignutih>=3) {
			System.out.println("Da bi podigli knjigu jednu morate vratiti. Limit podignutih knjiga po clanu je 3.");
		}
		else if(postojecaKnjiga && postojeciRacun==false && brojPodignutih<3)
			System.out.println("Taj racun ne postoji.");
		else if(postojecaKnjiga && postojeciRacun==false && brojPodignutih>3) {
			System.out.println("Ne postojeci racun.");
		}
		else if(postojecaKnjiga==false && postojeciRacun && brojPodignutih<3)
			System.out.println("Tu knjigu nemamo.");
		else if(postojecaKnjiga==false && postojeciRacun && brojPodignutih>3) {
			System.out.println("Tu knjigu nemamo a i da imamo ne bi je dobio. Prvo moras vratit koju knjigu.");
		}
		else
			System.out.println("\nNiti imamo tu knjigu niti taj racun postoji. Dovidjenja.");
	}
	
	public void returnBook() {
		boolean postojeciClan=false;
		boolean postojecaKniga=false;
		int indexClan=0;
		int indexKnjiga=0;
		boolean iznajmljena=false;
		
		for(int i=0; i<AccountList.size(); i++) {
			if(AccountList.get(i).accoundID==accountID) {
				postojeciClan=true;
				indexClan=i;
			}
		}
		for(int j=0; j<BookList.size(); j++) {
			if(BookList.get(j).bookID==bookID) {
				postojecaKniga=true;
				indexKnjiga=j;
				if(BookList.get(j).rented)
					iznajmljena=true;
			}
		}
		
		if(postojecaKniga && postojeciClan && iznajmljena) {
			AccountList.get(indexClan).vratiKnjigu();
			BookList.get(indexKnjiga).rented=false;
			datum=new Date();
			System.out.println("\tKnjiga vracena.");
			postoji=true;
			
		}
		else if(postojecaKniga && postojeciClan && iznajmljena==false)
			System.out.println("Ne mozete vratiti knjigu koju niste iznajmili.");
		else if(postojecaKniga && postojeciClan==false )
			System.out.println("Vi niste registrovani.");
		else if(postojecaKniga==false && postojeciClan)
			System.out.println("Te knjige nema ovdje.");
		else
			System.out.println("Momak! Izlazi napolje!");
	}

	@Override
	public String toString() {
		return "\nID knjige: " + bookID + ", \ndatum izdavanja= " + datum + "\nKorisnik sa ID brojem: " +accountID +"\n";
	}
	
	
	
	
}
