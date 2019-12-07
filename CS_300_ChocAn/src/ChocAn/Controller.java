package ChocAn;

import ChocAn.IModel.Action;

import java.time.LocalDate;
import java.util.List;

public class Controller {
	
	public enum Status {INVALID, VALID, SUSPENDED}
	
	/// Member Methods ////////////////////////////////////////////////////////
	
	/**Add a new member to the database. The member's isSuspended status is automatically set to false.
	 * @param id member's ChocAn ID.
	 * @param name Member's full name [First Last] no comma separation.
	 * @param street member's address.
	 * @param city members city.
	 * @param state member's state.
	 * @param zip member's zip code.
	 * @return true if member was added to the database, false otherwise.
	 */
	public static Boolean CreateMember(int id, String name, String street, String city, String state, String zip) {
		Member member = new Member();
		member.id = id;
		member.name = PrepString(name);
		member.street = PrepString(street);
		member.city = PrepString(city);
		member.state = PrepString(state);
		member.zip = PrepString(zip);
		return member.Database(Action.ADD);
	}
	
	/**Remove member from the database
	 * @param id of member to be removed from database.
	 * @return true if member with matching id is removed from 
	 * the database, false otherwise.
	 */
	public static Boolean DeleteMember(int id) {
		Member member = new Member();
		member.id = id;
		return member.Database(Action.DELETE);
	}
	
	/**Update (delete then add) member to database
	 * @param id member's ChocAn ID.
	 * @param name Member's full name [First Last] no comma separation.
	 * @param street member's address.
	 * @param city members city.
	 * @param state member's state.
	 * @param zip member's zip code.
	 * @return true if member's info was update in the database, false otherwise.
	 */
	public static Boolean UpdateMember(int id, String name, String street, String city, String state, String zip) {
		Member member = new Member();
		member.id = id;
		member.name = PrepString(name);
		member.street = PrepString(street);
		member.city = PrepString(city);
		member.state = PrepString(state);
		member.zip = PrepString(zip);
		return member.Database(Action.UPDATE);
	}
	
	/**Set the member's suspension status.
	 * @param id of member whose suspension status is to be changed.
	 * @param status true will set the isSuspended to true, false otherwise.
	 * @return false if the id couldn't be matched with a member in the database, true otherwise.
	 */
	public static Boolean SetMemberSuspension(int id, Boolean status) {
		if(GetMember(id).id == -1)
			return false;
		Member member = new Member();
		member.id = id;
		member.SetSuspension(status);
		return true;
	}
	
	/**ValidateMember must find member with matching id in the database, and if
	 *  found return its suspended status
	 * @param id of the member to validate
	 * @return Status is returned because the member id could be invalid, 
	 * valid, or valid but member is suspended
	 */
	public static Status ValidateMember(int id) {
		Member member = new Member();
		if(member.Get(id).id == -1)
			return Status.INVALID;
		else if(member.Get(id).isSuspended)
			return Status.SUSPENDED;
		return Status.VALID;
	}
	
	/**Returns a copy of the member with matching id from the member database
	 * @param id of the member in the database to return a copy of
	 * @return A copy of the member with a matching id from the database
	 */
	public static Member GetMember(int id) {
		Member member = new Member();
		return member.Get(id);
	}
	
	/** @return An unmodifiable list of all members in the database
	 */
	public static List<Member> GetAllMembers(){
		Member member = new Member();
		return member.GetAll();
	}
	
	/// Provider Methods //////////////////////////////////////////////////////
	
	/**Add a new provider to the database.
	 * @param id provider's ID.
	 * @param name provider's name. There should be no special characters used, especially commas.
	 * @param street provider's address.
	 * @param city provider's city.
	 * @param state provider's state.
	 * @param zip provider's zip code.
	 * @return true if provider was added to the database, false otherwise.
	 */
	public static Boolean CreateProvider(int id, String name, String street, String city, String state, String zip) {
		Provider provider = new Provider();
		provider.id = id;
		provider.name = PrepString(name);
		provider.street = PrepString(street);
		provider.city = PrepString(city);
		provider.state = PrepString(state);
		provider.zip = PrepString(zip);
		return provider.Database(Action.ADD);
	}
	
	/**Remove Provider from the database
	 * @param id of Provider to be removed from database.
	 * @return true if Provider with matching id is removed from 
	 * the database, false otherwise.
	 */
	public static Boolean DeleteProvider(int id) {
		Provider provider = new Provider();
		provider.id = id;
		return provider.Database(Action.DELETE);
	}
	
	/**Update (delete then add) provider to database
	 * @param id provider's ID.
	 * @param name provider's name. There should be no special characters used, especially commas.
	 * @param street provider's address.
	 * @param city provider's city.
	 * @param state provider's state.
	 * @param zip provider's zip code.
	 * @return true if provider was updated in the database, false otherwise.
	 */
	public static Boolean UpdateProvider(int id, String name, String street, String city, String state, String zip) {
		Provider provider = new Provider();
		provider.id = id;
		provider.name = PrepString(name);
		provider.street = PrepString(street);
		provider.city = PrepString(city);
		provider.state = PrepString(state);
		provider.zip = PrepString(zip);
		return provider.Database(Action.UPDATE);
	}
	
	/**Returns a copy of the Provider with matching id from the Provider database
	* @param id of the Provider in the database to return a copy of
	* @return A copy of the Provider with a matching id from the database
	*/
	public static Provider GetProvider(int id) {
		Provider provider = new Provider();
		return provider.Get(id);
	}
	
	/** 
	 * @return An unmodifiable list of all Providers in the database
	 */
	public static List<Provider> GetAllProviders(){
		Provider provider = new Provider();
		return provider.GetAll();
	}
	
	/// Consultation Methods //////////////////////////////////////////////////
	
	/**Add a new Consultation to the database.
	 * @param id 
	 * @param serviceDate 
	 * @param memberNumber 
	 * @param memberName 
	 * @param serviceCode 
	 * @param fee 
	 * @param providerNumber 
	 * @param comment 
	 * @return 
	 */
	public static Boolean CreateConsultation(int id, LocalDate serviceDate, 
			int memberNumber, String memberName, int serviceCode, 
			String fee, int providerNumber, String comment) {
		Consultation consultation = new Consultation();
		consultation.id = id;
		consultation.serviceDate = serviceDate;
		consultation.memberNumber = memberNumber;
		consultation.memberName = PrepString(memberName);
		consultation.serviceCode = serviceCode;
		consultation.fee = PrepString(fee);
		consultation.providerNumber = providerNumber;
		consultation.comment = PrepString(comment);
		return consultation.Database(Action.ADD);
	}
		
	/**Remove Consultation from the database
	 * @param id of Consultation to be removed from database.
	 * @return true if Consultation with matching id is removed from 
	 * the database, false otherwise.
	 */
	public static Boolean DeleteConsultation(int id) {
		Consultation consultation = new Consultation();
		consultation.id = id;
		return consultation.Database(Action.DELETE);
	}
	
	/**Update (delete then add) Consultation to database
	 * @param id 
	 * @param serviceDate 
	 * @param memberNumber 
	 * @param memberName 
	 * @param serviceCode 
	 * @param fee 
	 * @param providerNumber 
	 * @param comment 
	 * @return 
	 */
	public static Boolean UpdateConsultation(int id, LocalDate serviceDate, 
			int memberNumber, String memberName, int serviceCode, 
			String fee, int providerNumber, String comment) {
		Consultation consultation = new Consultation();
		consultation.id = id;
		consultation.serviceDate = serviceDate;
		consultation.memberNumber = memberNumber;
		consultation.memberName = PrepString(memberName);
		consultation.serviceCode = serviceCode;
		consultation.fee = fee;
		consultation.providerNumber = providerNumber;
		consultation.comment = PrepString(comment);
		return consultation.Database(Action.UPDATE);
	}
	
	/**
	 * @return An unmodifiable list of all consultations in the database
	 */
	public static List<Consultation> GetAllConsultations(){
		Consultation consultation = new Consultation();
		return consultation.GetAll();
	}
	
	/// Service Methods ///////////////////////////////////////////////////////
	
	/**Add Service to database
	 * @param code to link with this service name.
	 * @param name of service to add.
	 * @return true if added to the database, false otherwise
	 */
	public static Boolean CreateService(int code, String name) {
		Service service = new Service();
		service.code = code;
		service.name = PrepString(name);
		return service.Database(Action.ADD);
	}
			
	/**Remove Service from the database
	 * @param id of Service to be removed from database.
	 * @return true if Service with matching id is removed from 
	 * the database, false otherwise.
	 */
	public static Boolean DeleteService(int code) {
		Service service = new Service();
		service.code = code;
		return service.Database(Action.DELETE);
	}

	/**Update (delete then add) a Service to database.
	 * @param code Service code
	 * @param name of service
	 * @return true if service was updated in the database, false otherwise.
	 */
	public static Boolean UpdateService(int code, String name) {
		Service service = new Service();
		service.code = code;
		service.name = PrepString(name);
		return service.Database(Action.UPDATE);
	}
	
	/**
	 * @return An unmodifiable list of all services in the database
	 */
	public static List<Service> GetAllServices(){
		Service service = new Service();
		return service.GetAll();
	}
	
	/**
	 * @param code is the service code linked to the service name to return.
	 * @return The name of the service that matches the code argument.
	 */
	public static String GetServiceName(int code) {
		Service service = new Service();
		return service.GetServiceName(code);
	}
	
	/**
	 * @param name of the service that is linked to the service code to return.
	 * @return service code that matches the service name argument.
	 */
	public static int GetServiceCode(String name) {
		Service service = new Service();
		return service.GetServiceCode(name);
	}
	
	public static void WriteAllToDisk(){
		Service service = new Service();
		service.WriteAllToDisk();
	}
	
	private static String PrepString(String str) {
		String newString = str;
		newString = newString.replaceAll("[^a-zA-Z0-9\\s+]", "");
		return newString;
	}
}
