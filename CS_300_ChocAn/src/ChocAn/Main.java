package ChocAn;

import java.time.LocalDate;
import java.time.LocalDateTime;

import ChocAn.Model.Action;
import ChocAn.Controller.Status;

public class Main {
	
	public static void main(String[] args) {
		
		//View.TerminalChoice();
		
		Provider provider = new Provider();
		Consultation consul = new Consultation();
		
		// Load member object with data

		Controller.CreateMember(720037, "Joe Stevens", "12345 SE No Way", "Portland", "OR", "97214");
		if(Controller.ValidateMember(720037) == Status.INVALID)
			System.out.println(Controller.GetMember(720037).name + ": INVALID member id");
		else if(Controller.ValidateMember(720037) == Status.VALID)
			System.out.println(Controller.GetMember(720037).name + ": VALIDATED");
		else if(Controller.ValidateMember(720037) == Status.SUSPENDED)
			System.out.println(Controller.GetMember(720037).name + ": SUSPENDED");
		
		// Add members
		Controller.CreateMember(720038, "Jon Jones", "12345 SE No Way", "Portland", "OR", "97214");
		Controller.CreateMember(720039, "Khabib N", "12345 SE No Way", "Portland", "OR", "97214");
		Controller.CreateMember(720040, "Darren Till", "12345 SE No Way", "Portland", "OR", "97214");
		Controller.CreateMember(720041, "Mighty Mouse", "12345 SE No Way", "Portland", "OR", "97214");
		Controller.CreateMember(720042, "Derrick Louis", "12345 SE No Way", "Portland", "OR", "97214");
		
		// update a member
		Controller.UpdateMember(720042, "Stipe Miocic", "12345 SE No Way", "Portland", "OR", "97214");
		
		// print out member list
		for(int i = 0; i < Controller.GetAllMembers().size(); i++)
			Controller.GetAllMembers().get(i).Print();
		
		// Load member object with data
		provider.id = 826347;
		provider.name = "Providence";
		provider.street = "12345 SE No Way";
		provider.city = "Portland";
		provider.state = "OR";
		provider.zip = "97214";
		provider.Print();
		
		// Load Consultation object with data
		consul.currentDateTime = LocalDateTime.now();
		consul.serviceDate = LocalDate.now();
		consul.memberNumber = 720037;
		consul.serviceCode = 100009;
		consul.fee = "222.2";
		consul.memberName = "Joe Stevens";
		consul.providerNumber = 826347;
		consul.comment = "The patient was terrible.";
		consul.Print();
	}

}
