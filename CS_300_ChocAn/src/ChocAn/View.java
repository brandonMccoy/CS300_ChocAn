package ChocAn;

/* NOTE:
 * When being returned an object (type IModel), if the id equals -1, then the object does not exist in any database
 */

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import static ChocAn.Controller.Status.*;

public class View {

    public static void testFunc() {

        for (int i = 0; i < 100; ++i) {
            System.out.println("");
        }
       // System.out.println("Success");
        return;
    }
    public static void set()
    {
        for (int i = 0; i < 30; ++i) {
            System.out.println("");
        }
    }

    public static void runReport()
    {
        Scanner input = new Scanner(System.in);
        char response;
        do {
            System.out.println("--------------- ChoCan Report Menu -----------");
            System.out.println("1.) Member report");
            System.out.println("2.) Provider report");
            System.out.println("3.) Accounts payable summary");
            System.out.println("4.) EFT summary");
            System.out.println("-----------------------------------------------");
            System.out.println("0.) Quit");
            set();
            response = input.next().charAt(0);


            if (response == '1') {
                int id;
                System.out.println("-----------------------------------------------");
                System.out.println("Enter member ID:");
                id = input.nextInt();
                try {
                    ReportGenerator.GenerateReport(ReportGenerator.ReportType.MEMBER, id);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (response == '2') {
                int id;
                System.out.println("-----------------------------------------------");
                System.out.println("Enter member ID:");
                id = input.nextInt();
                try {
                    ReportGenerator.GenerateReport(ReportGenerator.ReportType.PROVIDER, id);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (response == '3') {
                int id;
                System.out.println("-----------------------------------------------");
                System.out.println("Enter member ID:");
                id = input.nextInt();
                //try {
                    //ReportGenerator.GenerateReport(ReportGenerator.ReportType.ACCOUNT_PAYABLE, id);
                //} catch (IOException e) {
                  //  e.printStackTrace();
                //}
            } else if (response == '4') {
                int id;
                System.out.println("-----------------------------------------------");
                System.out.println("Enter member ID:");
                id = input.nextInt();
                try {
                    ReportGenerator.GenerateReport(ReportGenerator.ReportType.EFT, id);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } while (response != '0');
        testFunc();
        return;
    }

    public static void validateMember()
    {
        Scanner input = new Scanner(System.in);
        int response;

        System.out.println("--------------- ChoCan Vaidate Member -----------");
        System.out.println("Enter Member Number");
        System.out.println("-------------------------------------------------");
        set();
        response = input.nextInt();
        Controller.Status a = Controller.ValidateMember(response);
        if(a == INVALID)
        {
            System.out.println("Invalid Member");
        }
        if(a == VALID)
        {
            System.out.println("Valid Member");
        }
        if(a == SUSPENDED)
        {
            System.out.println("Suspended Member");
        }

        //testFunc();
        return;
    }



    public static void ManagerChoice() {
        Scanner input = new Scanner(System.in);
        char response;
        do {
            System.out.println("--------------- ChoCan Manager Menu -----------");
            System.out.println("1.) Display all members");
            System.out.println("2.) Display all providers");
            System.out.println("3.) Add a member");
            System.out.println("4.) Delete a member");
            System.out.println("5.) Add a provider");
            System.out.println("6.) Delete a provider");
            System.out.println("7.) Run a report");
            System.out.println("-----------------------------------------------");
            System.out.println("0.) Quit");
            set();
            response = input.next().charAt(0);


            if (response == '1') {
                List<Member> a = Controller.GetAllMembers();
                if(a.size() == 0)
                {
                    System.out.println("No Members To Display");
                }
                else {
                    for (int i = 0; i < a.size(); ++i) {
                        a.get(i).Print();
                    }
                }
            } else if (response == '2') {
                List<Provider> a = Controller.GetAllProviders();
                if(a.size() == 0)
                {
                    System.out.println("No Providers To Display");
                }
                else {
                    for (int i = 0; i < a.size(); ++i) {
                        a.get(i).Print();
                    }
                }

            } else if (response == '3') {
                //enter data
                System.out.println("Enter in the id");
                int id = input.nextInt();
                System.out.println("Enter name");
                String name = input.nextLine();
                name = input.nextLine();
                System.out.println("Enter Street");
                String street = input.nextLine();
                System.out.println("Enter City");
                String city = input.nextLine();
                System.out.println("Enter State");
                String state = input.nextLine();
                System.out.println("Enter Zip");
                String zip = input.nextLine();
                Controller.CreateMember( id,  name,  street,  city,  state,  zip);
            } else if (response == '4') {
                System.out.println("Enter ID Number");
                int id = input.nextInt();
                Controller.DeleteMember(id);
            } else if (response == '5') {
                System.out.println("Enter in the id");
                int id = input.nextInt();
                System.out.println("Enter name");
                String name = input.nextLine();
                name = input.nextLine();
                System.out.println("Enter Street");
                String street = input.nextLine();
                System.out.println("Enter City");
                String city = input.nextLine();
                System.out.println("Enter State");
                String state = input.nextLine();
                System.out.println("Enter Zip");
                String zip = input.nextLine();
                Controller.CreateProvider( id,  name,  street,  city,  state,  zip);
            } else if (response == '6') {
                System.out.println("Enter ID Number");
                int id = input.nextInt();
                Controller.DeleteProvider(id);
            } else if (response == '7') {
                testFunc();
                runReport();
            }
        } while (response != '0');
        testFunc();
        return;
    }

    public static void providerChoice()
    {
        Scanner input = new Scanner(System.in);
        char response;
        do {
            System.out.println("--------------- ChoCan Provider Menu -----------");
            System.out.println("1. Validate Member");
            System.out.println("2. Log member visit");
            System.out.println("-----------------------------------------------");
            System.out.println("0.) Quit");
            set();
            response = input.next().charAt(0);


            if (response == '1') {
                testFunc();
                validateMember();
            } else if (response == '2') {
                System.out.println("Enter in the id");
                int id = input.nextInt();
                System.out.println("Enter in the Provider Number");
                int providerNumber = input.nextInt();
                System.out.println("Enter Member Number");
                int memberNumber = input.nextInt();
                System.out.println("Enter Service Code");
                int serviceCode = input.nextInt();
                System.out.println("Enter Member Name");
                String memberName = input.nextLine();
                memberName = input.nextLine();
                System.out.println("Enter Fee");
                String fee = input.nextLine();
                System.out.println("Any Comments?");
                String comment = input.nextLine();
                LocalDate serviceDate = LocalDate.now();
                Controller.UpdateConsultation(id, serviceDate,
                        memberNumber, memberName, serviceCode,
                        fee, providerNumber, comment);
            }
        }while(response != '0');
        testFunc();
        return;
    }

    public static void Start()
    {
        Scanner input = new Scanner(System.in);
        Controller Controller = new Controller();
        ReportGenerator ReportGenerator = new ReportGenerator();
        char response;
        do {


            System.out.println("--------------- ChocAn Menu -----------");
            System.out.println("1.) Manager Terminal");
            System.out.println("2.) Provider Terminal");
            System.out.println("---------------------------------------");
            System.out.println("0.) Quit");

            set();
            response = input.next().charAt(0);
            if (response == '1') {
                testFunc();
                ManagerChoice();
            } else if (response == '2') {
                providerChoice();
            }
        } while (response != '0');
        testFunc();
        return;
    }
}
