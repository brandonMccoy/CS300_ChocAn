package ChocAn;

import java.util.Collections;
import java.util.List;

// Contains all methods that behave like sql calls
public class Database {

	List<Member> memberDB;
	List<Provider> providerDB;
	List<Consultation> consultationDB;
	List<Service> serviceDB;
	
	Database(){
		// Fill memberDB with seed data
		
		// Fill providerDB with seed data
		
		// Fill Service list with names and corresponding codes
		
		// Fill ConsulLog with seed member visit data
	}
	
	/// Member Database ///////////////////////////////////////////////////////
	
	/// Returns false if member already exists in the list,
	/// else adds member to the memberDB list and returns true.
	public Boolean AddMember(Member member) {
		for(int i = 0; i < memberDB.size(); i++) {
			if(memberDB.get(i).id == member.id) {
				return false;
			}
		}
		memberDB.add(member);
		return true;
	}
	
	public Boolean DeleteMember(int id) {
		for(int i = 0; i < memberDB.size(); i++) {
			if(memberDB.get(i).id == id) {
				memberDB.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Boolean UpdateMember(Member member) {
		for(int i = 0; i < memberDB.size(); i++) {
			if(memberDB.get(i).id == member.id) {
				memberDB.remove(i);
				memberDB.add(member);
				return true;
			}
		}
		return false;
	}
	
	public Boolean MemberExists(int id) {
		for(int i = 0; i < memberDB.size(); i++) {
			if(memberDB.get(i).id == id) {
				return true;
			}
		}
		return false;
	}
	
	public Member GetMember(int id) {
		Member member = new Member();
		for(int i = 0; i < memberDB.size(); i++) {
			if(memberDB.get(i).id == id) {
				member = memberDB.get(i);
				break;
			}
		}
		return member;
	}
	
	public List<Member> AllMembers(){
		return Collections.unmodifiableList(memberDB);
	}

	/// Provider Database /////////////////////////////////////////////////////
	
	public Boolean AddProvider(Provider provider) {
		for(int i = 0; i < providerDB.size(); i++) {
			if(providerDB.get(i).id == provider.id) {
				return false;
			}
		}
		providerDB.add(provider);
		return true;
	}

	public Boolean DeleteProvider(int id) {
		for(int i = 0; i < providerDB.size(); i++) {
			if(providerDB.get(i).id == id) {
				providerDB.remove(i);
				return true;
			}
		}
		return false;
	}

	public Boolean UpdateProvider(Provider provider) {
		for(int i = 0; i < providerDB.size(); i++) {
			if(providerDB.get(i).id == provider.id) {
				providerDB.remove(i);
				providerDB.add(provider);
				return true;
			}
		}
		return false;
	}

	public Boolean ProviderExists(int id) {
		for(int i = 0; i < providerDB.size(); i++) {
			if(providerDB.get(i).id == id) {
				return true;
			}
		}
		return false;
	}
	
	public Provider GetProvider(int id) {
		Provider provider = new Provider();
		for(int i = 0; i < providerDB.size(); i++) {
			if(providerDB.get(i).id == id) {
				provider = providerDB.get(i);
				break;
			}
		}
		return provider;
	}
	
	public List<Provider> AllProviders(){
		return Collections.unmodifiableList(providerDB);
	}
	
	/// Consultation Database /////////////////////////////////////////////////
	
	public Boolean AddConsultation(Consultation consultation) {
		for(int i = 0; i < consultationDB.size(); i++) {
			if(consultationDB.get(i).id == consultation.id) {
				return false;
			}
		}
		consultationDB.add(consultation);
		return true;
	}

	public Boolean DeleteConsultation(int id) {
		for(int i = 0; i < consultationDB.size(); i++) {
			if(consultationDB.get(i).id == id) {
				consultationDB.remove(i);
				return true;
			}
		}
		return false;
	}

	public Boolean UpdateConsultation(Consultation consultation) {
		for(int i = 0; i < consultationDB.size(); i++) {
			if(consultationDB.get(i).id == consultation.id) {
				consultationDB.remove(i);
				consultationDB.add(consultation);
				return true;
			}
		}
		return false;
	}

	public Boolean ConsultationExists(int id) {
		for(int i = 0; i < consultationDB.size(); i++) {
			if(consultationDB.get(i).id == id) {
				return true;
			}
		}
		return false;
	}
	
	public Consultation GetConsultation(int id) {
		for(int i = 0; i < consultationDB.size(); i++) {
			if(consultationDB.get(i).id == id) {
				return consultationDB.get(i);
			}
		}
		return null;
	}
	
	public List<Consultation> AllConsultations(){
		return Collections.unmodifiableList(consultationDB);
	}
	
	/// Services Database /////////////////////////////////////////////////////
	
	public Boolean AddService(Service service) {
		for(int i = 0; i < serviceDB.size(); i++) {
			if(serviceDB.get(i).code == service.code) {
				return false;
			}
		}
		serviceDB.add(service);
		return true;
	}
	
	public Boolean DeleteService(int id) {
		for(int i = 0; i < serviceDB.size(); i++) {
			if(serviceDB.get(i).code == id) {
				serviceDB.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Boolean UpdateService(Service service) {
		for(int i = 0; i < serviceDB.size(); i++) {
			if(serviceDB.get(i).code == service.code) {
				serviceDB.remove(i);
				serviceDB.add(service);
				return true;
			}
		}
		return false;
	}
	
	public Boolean ServiceExists(int code) {
		for(int i = 0; i < serviceDB.size(); i++) {
			if(serviceDB.get(i).code == code) {
				return true;
			}
		}
		return false;
	}
	
	public Service GetService(int code) {
		Service service = new Service();
		for(int i = 0; i < serviceDB.size(); i++) {
			if(serviceDB.get(i).code == code) {
				service = serviceDB.get(i);
				break;
			}
		}
		return service;
	}
	
	public String GetServiceName(int serviceCode) {
		for(int i = 0; i < serviceDB.size(); i++) {
			if(serviceDB.get(i).code == serviceCode) {
				return serviceDB.get(i).name;
			}
		}
		return "Invalid Code";
	}
	
	public int GetServiceCode(String serviceName) {
		for(int i = 0; i < serviceDB.size(); i++) {
			if(serviceDB.get(i).name.strip().toLowerCase() == serviceName.toLowerCase()) {
				return serviceDB.get(i).code;
			}
		}
		return -1;
	}
	
	public List<Service> AllServices(){
		return Collections.unmodifiableList(serviceDB);
	}
	
	// Writes all lists to separate files
	public Boolean SaveToDisk() {
		
		return null;
	}
}
