package ChocAn;

public class Main {

	
	
	public static void main(String[] args) {
		
		//View.TerminalChoice();
		
		
		Member member = new Member();
		Provider provider = new Provider();
		Consultation consul = new Consultation();
		
		// Load member object with data
		member.id = 720037;
		member.name = "Joe Stevens";
		member.street = "12345 SE No Way";
		member.city = "Portland";
		member.state = "OR";
		member.zip = 97214;
		member.suspended = true;
		member.Print();
		
		// Load member object with data
		provider.id = 826347;
		provider.name = "Providence";
		provider.street = "12345 SE No Way";
		provider.city = "Portland";
		provider.state = "OR";
		provider.zip = 97214;
		provider.Print();
		
		// Load Consultation object with data
		consul.currentDateTime = LocalDateTime.now();
		consul.serviceDate = LocalDate.now();
		consul.memberNumber = "720037";
		consul.serviceCode = "000009";
		consul.fee = "222.2";
		consul.memberName = "Joe Stevens";
		consul.providerNumber = "826347";
		consul.comment = "The patient was terrible.";
		consul.Print();
	}

}
