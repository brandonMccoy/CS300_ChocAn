package ChocAn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseTest {

	Database testDatabase;
	
	final int defaultID = 999999;
	
	@BeforeEach
	void setUp() throws Exception {
		testDatabase = new Database();
		int id = 999998;
		for(int i = 0; i < 100; i++) {
			Member newMember = new Member();
			newMember.id = id;
			testDatabase.AddMember(newMember);
			
			Provider newProvider = new Provider();
			newProvider.id = id;
			testDatabase.AddProvider(newProvider);
			
			Consultation newConsultation = new Consultation();
			newConsultation.id = id;
			testDatabase.AddConsultation(newConsultation);
			
			Service newService = new Service();
			newService.code = id;
			testDatabase.AddService(newService);
			
			id--;
		}
	}
	
	@AfterEach
	void tearDown() throws Exception {
		testDatabase.memberDB.clear();
		testDatabase.providerDB.clear();
		testDatabase.consultationDB.clear();
		testDatabase.serviceDB.clear();
		testDatabase = null;
	}

	@Test
	void testConstructor() {
		Database newDatabase = new Database();
		assertNotNull("Database constructor has failed", newDatabase);
	}

	/// Member Tests //////////////////////////////////////////////////////////
	
	@Test
	void testAddMember() {
		Member newMember = new Member();
		Boolean result = testDatabase.AddMember(newMember);
		assertEquals("Add Member function failed", true, result);
	}
	
	@Test
	void testDeleteMember() {
		Member newMember = new Member();
		testDatabase.AddMember(newMember);
		Boolean result = testDatabase.DeleteMember(newMember.id);
		assertEquals("Delete Member function failed", true, result);
	}
	
	@Test
	void testUpdateMember() {
		Member newMember = new Member();
		Boolean result = testDatabase.UpdateMember(newMember);
		assertEquals("Update Member function failed", false, result);
		testDatabase.AddMember(newMember);
		result = testDatabase.UpdateMember(newMember);
		assertEquals("Update Member function failed", true, result);
	}
	
	@Test
	void testMemberExists() {
		Member newMember = new Member();
		newMember.id = defaultID;
		testDatabase.AddMember(newMember);
		Boolean result = testDatabase.MemberExists(newMember.id);
		assertEquals("Member Exists function failed", true, result);
		
	}
	
	@Test
	void testGetMember() {
		Member newMember = new Member();
		newMember.id = defaultID;
		testDatabase.AddMember(newMember);
		Member result = testDatabase.GetMember(defaultID);
		assertEquals("Get Member function failed", newMember, result);
	}
	
	@Test
	void testSetMemberSuspension() {
		Member newMember = new Member();
		newMember.id = defaultID;
		testDatabase.AddMember(newMember);
		Boolean result = testDatabase.SetMemberSuspension(defaultID, true);
		assertEquals("Set Member Supension Status function failed", true, result);
	}
	
	/// Provider Tests ////////////////////////////////////////////////////////
	
	@Test
	void testAddProvider() {
		Provider newProvider = new Provider();
		Boolean result = testDatabase.AddProvider(newProvider);
		assertEquals("Add Provider function failed", true, result);
	}
	
	@Test
	void testDeleteProvider() {
		Provider newProvider = new Provider();
		testDatabase.AddProvider(newProvider);
		Boolean result = testDatabase.DeleteProvider(newProvider.id);
		assertEquals("Delete Provider function failed", true, result);
	}
	
	@Test
	void testUpdateProvider() {
		Provider newProvider = new Provider();
		Boolean result = testDatabase.UpdateProvider(newProvider);
		assertEquals("Update Provider function failed", false, result);
		testDatabase.AddProvider(newProvider);
		result = testDatabase.UpdateProvider(newProvider);
		assertEquals("Update Provider function failed", true, result);
	}
	
	@Test
	void testProviderExists() {
		Provider newProvider = new Provider();
		newProvider.id = defaultID;
		testDatabase.AddProvider(newProvider);
		Boolean result = testDatabase.ProviderExists(newProvider.id);
		assertEquals("Provider Exists function failed", true, result);
		
	}
	
	@Test
	void testGetProvider() {
		Provider newProvider = new Provider();
		newProvider.id = defaultID;
		testDatabase.AddProvider(newProvider);
		Provider result = testDatabase.GetProvider(defaultID);
		assertEquals("Get Provider function failed", newProvider, result);
	}
	
	/// Consultation Tests ////////////////////////////////////////////////////
	
	@Test
	void testAddConsultation() {
		Consultation newConsultation = new Consultation();
		Boolean result = testDatabase.AddConsultation(newConsultation);
		assertEquals("Add Consultation function failed", true, result);
	}
	
	@Test
	void testDeleteConsultation() {
		Consultation newConsultation = new Consultation();
		testDatabase.AddConsultation(newConsultation);
		Boolean result = testDatabase.DeleteConsultation(newConsultation.id);
		assertEquals("Delete Consultation function failed", true, result);
	}
	
	@Test
	void testUpdateConsultation() {
		Consultation newConsultation = new Consultation();
		Boolean result = testDatabase.UpdateConsultation(newConsultation);
		assertEquals("Update Consultation function failed", false, result);
		testDatabase.AddConsultation(newConsultation);
		result = testDatabase.UpdateConsultation(newConsultation);
		assertEquals("Update Consultation function failed", true, result);
	}
	
	@Test
	void testConsultationExists() {
		Consultation newConsultation = new Consultation();
		newConsultation.id = defaultID;
		testDatabase.AddConsultation(newConsultation);
		Boolean result = testDatabase.ConsultationExists(newConsultation.id);
		assertEquals("Consultation Exists function failed", true, result);
		
	}
	
	@Test
	void testGetConsultation() {
		Consultation newConsultation = new Consultation();
		newConsultation.id = defaultID;
		testDatabase.AddConsultation(newConsultation);
		Consultation result = testDatabase.GetConsultation(defaultID);
		assertEquals("Get Consultation function failed", newConsultation, result);
	}
	
	/// Service Tests /////////////////////////////////////////////////////////
	
	@Test
	void testAddService() {
		Service newService = new Service();
		Boolean result = testDatabase.AddService(newService);
		assertEquals("Add Service function failed", true, result);
	}
	
	@Test
	void testDeleteService() {
		Service newService = new Service();
		testDatabase.AddService(newService);
		Boolean result = testDatabase.DeleteService(newService.code);
		assertEquals("Delete Service function failed", true, result);
	}
	
	@Test
	void testUpdateService() {
		Service newService = new Service();
		Boolean result = testDatabase.UpdateService(newService);
		assertEquals("Update Service function failed", false, result);
		testDatabase.AddService(newService);
		result = testDatabase.UpdateService(newService);
		assertEquals("Update Service function failed", true, result);
	}
	
	@Test
	void testServiceExists() {
		Service newService = new Service();
		newService.code = defaultID;
		testDatabase.AddService(newService);
		Boolean result = testDatabase.ServiceExists(newService.code);
		assertEquals("Service Exists function failed", true, result);
		
	}
	
	@Test
	void testGetService() {
		Service newService = new Service();
		newService.code = defaultID;
		testDatabase.AddService(newService);
		Service result = testDatabase.GetService(defaultID);
		assertEquals("Get Service function failed", newService, result);
	}
	
	@Test
	void testGetServiceCode() {
		Service newService = new Service();
		newService.code = defaultID;
		newService.name = "BestService";
		testDatabase.AddService(newService);
		int result = testDatabase.GetServiceCode(newService.name);
		assertEquals("Get Service Code function failed", defaultID, result);
	}
	
	@Test
	void testGetServiceName() {
		Service newService = new Service();
		newService.code = defaultID;
		newService.name = "BestService";
		testDatabase.AddService(newService);
		String result = testDatabase.GetServiceName(defaultID);
		assertEquals("Get Service Name function failed", "BestService", result);
		assertNotEquals("Get Service Name function failed", "Invalid Code", result);
	}
}
