package ChocAn;

import ChocAn.Model.Action;
import java.util.List;
import ChocAn.Member;

public class Controller {
	
	/// Member Methods ////////////////////////////////////////////////////////
	
	// Add member to database
	public static Boolean CreateMember(Member member) {
		return member.Database(Action.ADD);
	}
	
	// Remove member from database
	public static Boolean DeleteMember(int id) {
		Member member = new Member();
		member.id = id;
		return member.Database(Action.DELETE);
	}
	
	// Update (delete then add) member to database
	public static Boolean UpdateMember(Member member) {
		return member.Database(Action.UPDATE);
	}
	
	// function must find member in database, and if found return its suspended
	// status
	public static Member.Status ValidateMember(int id) {
		Member member = new Member();
		return member.Get(id).status;
	}
	
	// Returns a copy of the member with matching id from the memberDB database
	public static Member GetMember(int id) {
		Member member = new Member();
		return member.Get(id);
	}
	
	/// Return an unmodifiable list of all members in the database
	public static List<Member> GetAllMembers(){
		Member member = new Member();
		return member.GetAll();
	}
	
	/// Provider Methods //////////////////////////////////////////////////////
	
	// Add provider to database
	public static void CreateProvider(Provider provider) {
		provider.Database(Action.ADD);
	}
	
	// Remove provider from database
	public static void DeleteProvider(int id) {
		Provider provider = new Provider();
		provider.id = id;
		provider.Database(Action.DELETE);
	}
	
	// Update (delete then add) provider to database
	public static Boolean UpdateProvider(Provider provider) {
		return provider.Database(Action.UPDATE);
	}
	
	// Returns a copy of the provider with matching id from the providerDB 
	// database
	public static Provider GetProvider(int id) {
		Provider provider = new Provider();
		return provider.Get(id);
	}
	
	/// Return an unmodifiable list of all providers in the database
	public static List<Provider> GetAllProviders(){
		Provider provider = new Provider();
		return provider.GetAll();
	}
	
	/// Consultation Methods //////////////////////////////////////////////////
	
	// Add Consultation to database
	public static void CreateConsultation(Consultation consultation) {
		consultation.Database(Action.ADD);
	}
		
	// Remove Consultation from database
	public static void DeleteConsultation(int id) {
		Consultation consultation = new Consultation();
		consultation.id = id;
		consultation.Database(Action.DELETE);
	}
		
	// Update (delete then add) Consultation to database
	public static Boolean UpdateConsultation(Consultation consultation) {
		return consultation.Database(Action.UPDATE);
	}
	
	/// Return an unmodifiable list of all consultations in the database
	public static List<Consultation> GetAllConsultations(){
		Consultation consultation = new Consultation();
		return consultation.GetAll();
	}
	
	/// Service Methods ///////////////////////////////////////////////////////
	
	// Add Consultation to database
	public static void CreateService(Service service) {
		service.Database(Action.ADD);
	}
			
	// Remove Consultation from database
	public static void DeleteService(int code) {
		Service service = new Service();
		service.code = code;
		service.Database(Action.DELETE);
	}
		
	// Update (delete then add) Consultation to database
	public static Boolean UpdateService(Service service) {
		return service.Database(Action.UPDATE);
	}
	
	/// Return an unmodifiable list of all consultations in the database
	public static List<Service> GetAllServices(){
		Service service = new Service();
		return service.GetAll();
	}
}
