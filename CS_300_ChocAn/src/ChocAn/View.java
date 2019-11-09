package ChocAn;

import java.io.IOException;

public class View {
	
	public static int TerminalChoice() {
		System.out.println("-- ChocAn Menu ------------------------------");
		System.out.println("1. Manager Terminal");
        System.out.println("2. Provider Terminal");
        System.out.println("---------------------------------------------");
        System.out.println("0. Quit");
        System.out.println();
        System.out.print("Your choice: ");

        int input = 0;
		try {
			input = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(input == 49)// 49 = 1
			ManagerChoice();
		else if(input == 50)// 50 = 2
			ProviderChoice();
		
        return input;
	}
	
	public static int ProviderChoice() {

        System.out.println("-- ChocAn Manager Menu -----------------------");

        System.out.println("1. ValidateMember");
        System.out.println("2. Log member visit");
        System.out.println("3. Order the Provider Directory");

        System.out.println("---------------------------------------------");

        System.out.println("0. Quit");
        System.out.println();

        System.out.print("Your choice: ");

        int input = 0;
		try {
			input = System.in.read();
			System.in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(input == 49)
			ValidateMember();
		else if(input == 50)
			LogVisit();
		else if(input == 51)
			OrderDirectory();
			
        return 0;
    }
	
	public static int ValidateMember() {
		// Ask user for member data
		System.out.println("-- ChocAn Validate Member Status ------------");

        System.out.println("Enter member number: ");
        
        int memberNum = 0;
		try {
			memberNum = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Do something with member number (Using the Controller)
        System.out.println("---------------------------------------------");
        System.out.println();
		return 0;
	}
	
	public static int LogVisit() {
		//ask user for log visit data
		// Log data using the Controller
		return 0;
	}
	
	public static int OrderDirectory() {
		System.out.println("-- ChocAn  -----------------------");
        System.out.println("Provider Directory order confirmation");
        System.out.println("---------------------------------------------");
        
        return 0;
	}
	
	public static int ManagerChoice() {

        System.out.println("-- ChocAn Manager Menu -----------------------");

        System.out.println("1. Display all members");
        System.out.println("2. Display all providers");
        System.out.println("3. Add a member");
        System.out.println("4. Delete a member");
        System.out.println("5. Add a provider");
        System.out.println("6. Delete a provider");
        System.out.println("7. Run a report");

        System.out.println("---------------------------------------------");

        System.out.println("0. Quit");
        System.out.println();

        System.out.print("Your choice: ");

        int input = 0;
		try {
			input = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return input;
    }
	
	public static int AddMember() {
		// user inputs member data in the view
		// Load Member with data
		// Add member using Controller by passing Member to Controller.CreateMember(Member)
		return 0;
	}
	
	public static int DeleteMember() {
		// user inputs member number in the view
		// Delete member using Controller
		return 0;
	}
	
	public static int AddProvider() {
		// user inputs provider data in the view
		// Add provider using controller
		return 0;
	}
	
	public static int DeleteProvider() {
		// user inputs provider number in the view
		// Delete provider using Controller
		return 0;
	}
	
	public static int RunReport() {
		System.out.println("-- ChocAn Report Menu -----------------------");

        System.out.println("1. Member report");
        System.out.println("2. Provider report");
        System.out.println("3. Accounts payable summary");
        System.out.println("4. EFT summary");

        System.out.println("---------------------------------------------");

        System.out.println("0. Quit");
        System.out.println();

        System.out.print("Your choice: ");

        int input = 0;
		try {
			input = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return input;
	}
	
}
