package ChocAn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consultation implements Model {
	
	// Set automatically when Consultation record is saved
    // yyyy-MM-dd-HH-mm-ss.zzz
	public LocalDateTime currentDateTime;

    // yyyy-MM-dd
	public LocalDate serviceDate;

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
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = currentDateTime.format(myFormatObj);
		System.out.println("Current Date Time: " + formattedDate);
		System.out.println("Service date: " + serviceDate);
		System.out.println("Member Number: " + memberNumber);
		System.out.println("Service Code: " + serviceCode);
		System.out.println("Fee: $" + fee);
		System.out.println("Member Name: " + memberName);
		System.out.println("Provider Number: " + providerNumber);
		if(!comment.isBlank())
			System.out.println("Comment: " + comment);
    }
}
