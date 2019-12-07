package ChocAn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Contains all methods that behave like sql calls
public class Database {

	List<Member> memberDB = new ArrayList();
	List<Provider> providerDB = new ArrayList();
	List<Consultation> consultationDB = new ArrayList();
	List<Service> serviceDB = new ArrayList();
	
	Database(){
		// Fill memberDB with seed data
		  BufferedReader reader = null;
		File file = new File("CS_300_ChocAn\\src\\ChocAn\\memberDB.csv");
		String filename = file.getAbsolutePath();
		String line = "";
		String cvsSplitBy = ",";
		Member new_member = null;
		try 
		{
			reader = new BufferedReader(new FileReader(filename));
			while ((line = reader.readLine()) != null) {
 
				
				// use comma as separator
				String[] field = line.split(cvsSplitBy);
				new_member = new Member();
				new_member.id = Integer.parseInt(field[0]);
				new_member.name = field[1];
				new_member.street = field[2];
				new_member.city = field[3];
				new_member.state = field[4];
				new_member.zip = field[5];
				if(field[6].equals("true"))
					new_member.isSuspended = true;
				else
					new_member.isSuspended = false;
				memberDB.add(new_member);
		}
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					 reader.close();
				} catch (IOException e) {
					 e.printStackTrace();
				}
			}
		}
		// Fill providerDB with seed data
		reader = null;
		
		file = new File("CS_300_ChocAn\\src\\ChocAn\\providerDB.csv");
		filename = file.getAbsolutePath();
		line = "";
		cvsSplitBy = ",";
		Provider new_provider = null;
		try 
		{
			reader = new BufferedReader(new FileReader(filename));
			while ((line = reader.readLine()) != null) {
 
				
				// use comma as separator
				String[] field = line.split(cvsSplitBy);
				new_provider = new Provider();
				new_provider.id = Integer.parseInt(field[0]);
				new_provider.name = field[1];
				new_provider.street = field[2];
				new_provider.city = field[3];
				new_provider.state = field[4];
				new_provider.zip = field[5];
				providerDB.add(new_provider);			
		}
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					 reader.close();
				} catch (IOException e) {
					 e.printStackTrace();
				}
			}
		}
		// Fill Service list with names and corresponding codes
		reader = null;
		file = new File("CS_300_ChocAn\\src\\ChocAn\\serviceDB.csv");
		filename = file.getAbsolutePath();
		line = "";
		cvsSplitBy = ",";
		Service new_service = null;
		try 
		{
			reader = new BufferedReader(new FileReader(filename));
			while ((line = reader.readLine()) != null) {
 
				
				// use comma as separator
				String[] field = line.split(cvsSplitBy);
				new_service = new Service();
				new_service.code = Integer.parseInt(field[0]);
				new_service.name = field[1];
				serviceDB.add(new_service);
				
		}
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					 reader.close();
				} catch (IOException e) {
					 e.printStackTrace();
				}
			}
		}
		// Fill ConsulLog with seed member visit data
		reader = null;
		file = new File("CS_300_ChocAn\\src\\ChocAn\\consultationDB.csv");
		filename = file.getAbsolutePath();
		line = "";
		cvsSplitBy = ",";
		DateTimeFormatter formatter;
		Consultation new_consultation = null;
		try 
		{
			reader = new BufferedReader(new FileReader(filename));
			while ((line = reader.readLine()) != null) {
				// use comma as separator
				String[] field = line.split(cvsSplitBy);
				new_consultation = new Consultation();
				new_consultation.id = Integer.parseInt(field[0]);
				formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				new_consultation.serviceDate = LocalDate.parse(field[1],formatter);
				formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:m:ss");
				new_consultation.currentDateTime = LocalDateTime.parse(field[2],formatter);
				new_consultation.memberNumber = Integer.parseInt(field[3]);
				new_consultation.serviceCode = Integer.parseInt(field[4]);
				new_consultation.fee = field[5];
				new_consultation.memberName = field[6];
				new_consultation.providerNumber = Integer.parseInt(field[7]);
				new_consultation.comment = field[8];
				consultationDB.add(new_consultation);				
		}
 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					 reader.close();
				} catch (IOException e) {
					 e.printStackTrace();
				}
			}
		}
	}
	
	public void WriteAllToDisk()
	{
		File file = new File("CS_300_ChocAn\\src\\ChocAn\\memberDB.csv");
		String file_out = file.getAbsolutePath();
		try
		{
		    BufferedWriter write_out = new BufferedWriter(new FileWriter(file_out));
			for(int i = 0; i < memberDB.size(); ++i)
			{
				write_out.write(String.valueOf(memberDB.get(i).id));
				write_out.append(",");
				write_out.append(memberDB.get(i).name);
				write_out.append(",");
				write_out.append(memberDB.get(i).street);
				write_out.append(",");
				write_out.append(memberDB.get(i).city);
				write_out.append(",");
				write_out.append(memberDB.get(i).state);
				write_out.append(",");
				write_out.append(memberDB.get(i).zip);
				write_out.append(",");
				write_out.append(Boolean.toString(memberDB.get(i).isSuspended));
				write_out.append("\n");
			}
			write_out.flush();
			write_out.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		file = new File("CS_300_ChocAn\\src\\ChocAn\\providerDB.csv");
		file_out = file.getAbsolutePath();
		try
		{
		    BufferedWriter write_out = new BufferedWriter(new FileWriter(file_out));
			for(int i =0; i < providerDB.size(); ++i)
			{
				write_out.write(String.valueOf(providerDB.get(i).id));
				write_out.append(",");
				write_out.append(providerDB.get(i).name);
				write_out.append(",");
				write_out.append(providerDB.get(i).street);
				write_out.append(",");
				write_out.append(providerDB.get(i).city);
				write_out.append(",");
				write_out.append(providerDB.get(i).state);
				write_out.append(",");
				write_out.append(providerDB.get(i).zip);
				write_out.append("\n");
			}
			write_out.flush();
			write_out.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		file = new File("CS_300_ChocAn\\src\\ChocAn\\serviceDB.csv");
		file_out = file.getAbsolutePath();
		try
		{
		    BufferedWriter write_out = new BufferedWriter(new FileWriter(file_out));
			for(int i =0; i < serviceDB.size(); ++i)
			{
				write_out.write(String.valueOf(serviceDB.get(i).code));
				write_out.append(",");
				write_out.append(serviceDB.get(i).name);
				write_out.append("\n");
			}
			write_out.flush();
			write_out.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		file = new File("CS_300_ChocAn\\src\\ChocAn\\consultationDB.csv");
		file_out = file.getAbsolutePath();
		try
		{
		    BufferedWriter write_out = new BufferedWriter(new FileWriter(file_out));
			for(int i =0; i < consultationDB.size(); ++i)
			{
				write_out.write(String.valueOf(consultationDB.get(i).id));
				write_out.append(",");
				write_out.append(consultationDB.get(i).serviceDate.toString());
				write_out.append(",");
				write_out.append(consultationDB.get(i).currentDateTime.toString());
				write_out.append(",");
				write_out.append(String.valueOf(consultationDB.get(i).memberNumber));
				write_out.append(",");
				write_out.append(String.valueOf(consultationDB.get(i).serviceCode));
				write_out.append(",");
				write_out.append(consultationDB.get(i).fee);
				write_out.append(",");
				write_out.append(consultationDB.get(i).memberName);
				write_out.append(",");
				write_out.append(String.valueOf(consultationDB.get(i).providerNumber));
				write_out.append(",");
				write_out.append(consultationDB.get(i).comment);
				write_out.append("\n");
			}
			write_out.flush();
			write_out.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
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
	/**Update the member's suspension status.
	* @return true if members isSuspended status is updated, false if member could not be located in the database.
	*/
	public Boolean SetMemberSuspension(int id, Boolean status) {
	for(int i = 0; i < memberDB.size(); i++) {
	if(memberDB.get(i).id == id) {
		memberDB.get(0).isSuspended = status;
		return true;
	}
	}
		return false;
	}
}
