package ChocAn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ChocAn.Controller.Status;
import ChocAn.IModel.Action;

class ControllerUnitTests {
	
	// test member information, initialized in the setUp method
	public int id;
	public String name;
	public String street;
	public String city;
	public String state;
	public String zip;
	public Member testMember;
	
	// test provider information, initialized in the setUp method
	public String providerName;
	public Provider testProvider;
	
	// test consultation information, initialized in the setUp method
	public int serviceId;
    public int memberNumber;
    public int serviceCode;
    public String fee;
    public String memberName;
    public int providerNumber;
    public String comment;
    public Consultation testConsultation;
    
    // test service information, initialized in the setUp method
    public int code;
    public String serviceName;
    public Service testService;

	@BeforeEach
	void setUp() throws Exception {
		id = 1234567;
		name = "John Doe";
		street = "1234 Main St";
		city = "Portland";
		state = "Oregon";
		zip = "12345";
		
		testMember = new Member();
		testMember.id = id;
		testMember.name = name;
		testMember.street = street;
		testMember.city = city;
		testMember.state = state;
		testMember.zip = zip;
		
		providerName = "Doctor Strange";
		
		testProvider = new Provider();
		testProvider.id = id;
		testProvider.name = providerName;
		testProvider.street = street;
		testProvider.city = city;
		testProvider.state = state;
		testProvider.zip = zip;
		
		serviceId = 654987;
	    memberNumber = 456789;
	    serviceCode = 987654;
	    fee = "999.99";
	    memberName = "Iron Man";
	    providerNumber = 654321;
	    comment = "here are some comments...";
	    
	    testConsultation = new Consultation();
	    testConsultation.id = serviceId;
	    testConsultation.memberNumber = memberNumber;
	    testConsultation.serviceCode = serviceCode;
	    testConsultation.fee = fee;
	    testConsultation.memberName = memberName;
	    testConsultation.providerNumber = providerNumber;
	    testConsultation.comment = comment;
	    
	    code = 99999;
	    serviceName = "Hypnosis Therapy";
	    
	    testService = new Service();
	    testService.code = code;
	    testService.name = serviceName;
	}

	@AfterEach
	void tearDown() throws Exception {
		testMember.Database(Action.DELETE);
		testMember = null;
		testProvider.Database(Action.DELETE);
		testProvider = null;
		testConsultation.Database(Action.DELETE);
		testConsultation = null;
		testService.Database(Action.DELETE);
		testService = null;
	}

	@Test
	void testCreateMember() {
		Boolean result = Controller.CreateMember(id, name, street, city, state, zip);
		assertTrue("Member not created", result);
	}

	@Test
	void testDeleteMember() {
		testMember.Database(Action.ADD);
		boolean result = Controller.DeleteMember(testMember.id);
		assertTrue("Member not deleted", result);
	}

	@Test
	void testUpdateMember() {
		testMember.Database(Action.ADD);
		String newName = "Jane Doe";
		boolean result = Controller.UpdateMember(id, newName, street, city, state, zip);
		if (result) {
			Member updatedMemberRecord = testMember.Get(id);
			assertEquals("Member not updated", "Jane Doe", updatedMemberRecord.name);
		} else {
			fail("Member not updated");
		}
	}

	@Test
	void testSetMemberSuspension() {
		testMember.Database(Action.ADD);
		boolean result = Controller.SetMemberSuspension(id, true);
		assertTrue("SetMemberSuspension() returned false", result);
		assertTrue("Member not set to suspended", testMember.isSuspended);
	}

	@Test
	void testValidateMemberValid() {
		testMember.Database(Action.ADD);
		Status status = Controller.ValidateMember(id);
		assertEquals("Member not validated", Status.VALID, status);
	}
	
	@Test
	void testValidateMemberInvalid() {
		Status status = Controller.ValidateMember(-1);
		assertEquals("Member not validated", Status.INVALID, status);
	}
	
	@Test
	void testValidateMemberSuspended() {
		testMember.Database(Action.ADD);
		testMember.isSuspended = true;
		Status status = Controller.ValidateMember(id);
		assertEquals("Member not validated", Status.SUSPENDED, status);
	}

	@Test
	void testGetMember() {
		testMember.Database(Action.ADD);
		Member fromDatabase = Controller.GetMember(id);
		assertEquals("Could not get member", fromDatabase.name, name);
	}

	@Test
	void testGetAllMembers() {
		testMember.Database(Action.ADD);
		List<Member> list = new LinkedList<Member>();
		list.add(testMember);
		List<Member> listFromController = Controller.GetAllMembers();
		assertEquals("Could not get all members", list, listFromController);
	}

	@Test
	void testCreateProvider() {
		Boolean result = Controller.CreateProvider(id, providerName, street, city, state, zip);
		assertTrue("Provider not created", result);
	}

	@Test
	void testDeleteProvider() {
		testProvider.Database(Action.ADD);
		boolean result = Controller.DeleteProvider(testProvider.id);
		assertTrue("Provider not deleted", result);
	}

	@Test
	void testUpdateProvider() {
		testProvider.Database(Action.ADD);
		String newName = "Doctor Livingston";
		boolean result = Controller.UpdateProvider(id, newName, street, city, state, zip);
		if (result) {
			Provider updatedProviderRecord = testProvider.Get(id);
			assertEquals("Provider not updated", "Doctor Livingston", updatedProviderRecord.name);
		} else {
			fail("Provider not updated");
		}
	}

	@Test
	void testGetProvider() {
		testProvider.Database(Action.ADD);
		Provider fromDatabase = Controller.GetProvider(id);
		assertEquals("Could not get provider", fromDatabase.name, providerName);
	}

	@Test
	void testGetAllProviders() {
		testProvider.Database(Action.ADD);
		List<Provider> list = new LinkedList<Provider>();
		list.add(testProvider);
		List<Provider> listFromController = Controller.GetAllProviders();
		assertEquals("Could not get all providers", list, listFromController);
	}

	@Test
	void testCreateConsultation() {
		Boolean result = Controller.CreateConsultation(serviceId, LocalDate.now(), memberNumber, memberName, serviceCode, fee, providerNumber, comment);
		assertTrue("Consultation not created", result);
	}

	@Test
	void testDeleteConsultation() {
		testConsultation.Database(Action.ADD);
		boolean result = Controller.DeleteConsultation(testConsultation.id);
		assertTrue("Consultation not deleted", result);
	}

	@Test
	void testUpdateConsultation() {
		testConsultation.Database(Action.ADD);
		String newFee = "5.00";
		boolean result = Controller.UpdateConsultation(serviceId, LocalDate.now(), memberNumber, memberName, serviceCode, newFee, providerNumber, comment);
		if (result) {
			Consultation updatedConsultationRecord = testConsultation.Get(serviceId);
			assertEquals("Consultation not updated", "5.00", updatedConsultationRecord.fee);
		} else {
			fail("Consultation not updated");
		}
	}

	@Test
	void testGetAllConsultations() {
		testConsultation.Database(Action.ADD);
		List<Consultation> list = new LinkedList<Consultation>();
		list.add(testConsultation);
		List<Consultation> listFromController = Controller.GetAllConsultations();
		assertEquals("Could not get all consultations", list, listFromController);
	}

	@Test
	void testCreateService() {
		Boolean result = Controller.CreateService(code, serviceName);
		assertTrue("Service not created", result);
	}

	@Test
	void testDeleteService() {
		testService.Database(Action.ADD);
		boolean result = Controller.DeleteService(testService.code);
		assertTrue("Service not deleted", result);
	}

	@Test
	void testUpdateService() {
		testService.Database(Action.ADD);
		String newName = "Talk Therapy";
		boolean result = Controller.UpdateService(code, newName);
		if (result) {
			Service updatedServiceRecord = testService.Get(code);
			assertEquals("Service not updated", newName, updatedServiceRecord.name);
		} else {
			fail("Service not updated");
		}
	}

	@Test
	void testGetAllServices() {
		testService.Database(Action.ADD);
		List<Service> list = new LinkedList<Service>();
		list.add(testService);
		List<Service> listFromController = Controller.GetAllServices();
		assertEquals("Could not get all services", list, listFromController);
	}

	@Test
	void testGetServiceName() {
		testService.Database(Action.ADD);
		String nameFromDatabase = Controller.GetServiceName(code);
		assertEquals("Could not get service name", serviceName, nameFromDatabase);
	}

	@Test
	void testGetServiceCode() {
		testService.Database(Action.ADD);
		int codeFromDatabase = Controller.GetServiceCode(serviceName);
		assertEquals("Could not get service code", code, codeFromDatabase);
	}

}
