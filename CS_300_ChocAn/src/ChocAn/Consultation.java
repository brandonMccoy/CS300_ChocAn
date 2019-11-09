package ChocAn;

public class Consultation implements Model {
	
	// Set automatically when Consultation record is saved
    // YY:MM:DD HH:MM:SS
    //public DateTime CurrentDateTime;

    // YY:MM:DD
    //public DateTime ServiceDate;

    public String memberNumber;
    public String serviceCode;
    public String fee;
    public String memberName;
    public String providerNumber;
    public String comment;

    @Override
    public void Print()
    {
    	System.out.println();
		System.out.println("== Consultation ===============");
		System.out.println();
		System.out.println("Member Number: " + memberNumber);
		System.out.println("Service Code: " + serviceCode);
		System.out.println("Fee: $" + fee);
		System.out.println("Member Name: " + memberName);
		System.out.println("Provider Number: " + providerNumber);
		if(!comment.isBlank())
			System.out.println("Comment: " + comment);
    }
}
