package ChocAn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Consultation implements Model {
	
	public int id;
	// Set automatically when Consultation record is saved
    // yyyy-MM-dd-HH-mm-ss.zzz
	public LocalDateTime currentDateTime;

    // yyyy-MM-dd
	public LocalDate serviceDate;
    public int memberNumber;
    public int serviceCode;
    public String fee;
    public String memberName;
    public int providerNumber;
    public String comment;
    
    Consultation(){
    	id = -1;
    	currentDateTime = LocalDateTime.now();
    	serviceDate = LocalDate.now();
        memberNumber = -1;
        serviceCode = -1;
        fee = "";
        memberName = "";
        providerNumber = -1;
        comment = "";
    }

	@Override
	public Boolean Database(Action action) {
		Boolean response = false;
		if(action == Action.ADD) {
			response = db.AddConsultation(this);
		}else if(action == Action.DELETE) {
			response = db.DeleteConsultation(this.id);
		}else if(action == Action.UPDATE) {
			response = db.UpdateConsultation(this);
		}else if(action == Action.EXISTS) {
			response = db.ConsultationExists(this.id);
		}
		return response;
	}
	
	// Returns a copy of the consultation with a matching id from the database
	@Override
	public Consultation Get(int id) {
		return db.GetConsultation(id);
	}
	
	/// Returns an unmodifiable list of all consultations in the consultationDB database
	public List<Consultation> GetAll(){
		return db.AllConsultations();
	}
	
	@Override
	public void Print()
	{
	    System.out.println();
		System.out.println("== Consultation ===============");
		System.out.println();
		System.out.println("Consultation ID: " + id);
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
