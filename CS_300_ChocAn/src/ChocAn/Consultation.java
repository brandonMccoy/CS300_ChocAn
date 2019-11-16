package ChocAn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Consultation implements Model {
	
	public int id;
	
	/**Set automatically when Consultation record is saved
	 * yyyy-MM-dd-HH-mm-ss.zzz
	 */
	public LocalDateTime currentDateTime;

    /**YYYY-MM-DD*/
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

    /**Add, Delete, or Update this Consultation in the database. Or check to see if 
	 * this Consultation is already in the database.
	 * @param action tells the method whether to add, delete, update, or check 
	 * if the Consultation is in the database.
	 * @return Depending on the argument, returns true if Consultation is 
	 * successfully added, deleted, updated, or found in the Consultation database.
	 */
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
	
	/**Searches the Consultation database for an object with a matching id.
	 * @param id of Consultation to find in the database
	 * @return A copy of the Consultation in the database that matches the id arg. 
	 * If a match is not found, an empty Consultation is returned with id = -1.
	 */
	@Override
	public Consultation Get(int id) {
		return db.GetConsultation(id);
	}

	/**
	 * @return An unmodifiable list of all consultations in the consultationDB database
	 */
	public List<Consultation> GetAll(){
		return db.AllConsultations();
	}

	/**Prints all Consultation variables to the console, 
	 * formatting specific to a Consultation type.
	 */
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

