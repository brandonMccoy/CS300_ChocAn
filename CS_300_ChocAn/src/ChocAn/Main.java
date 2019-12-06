package ChocAn;

import java.time.LocalDate;
import java.time.LocalDateTime;

import ChocAn.Model.Action;

public class Main {

	public static void main(String[] args) {
		
		//View.TerminalChoice();
		
		Member member = new Member();
		Provider provider = new Provider();
		Consultation consul = new Consultation();
		Service service = new Service();
		//database filled upon creation of new object
		Database database = new Database();
		
		//need to call WriteAllToDisk() after user wants to quit but before program exits
		database.WriteAllToDisk();
	}

}
