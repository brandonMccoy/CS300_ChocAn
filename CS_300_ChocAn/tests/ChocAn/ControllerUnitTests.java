package ChocAn;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControllerUnitTests {
	
	// test member information, initialized in the setUp method
	public int id;
	public String name;
	public String street;
	public String city;
	public String state;
	public String zip;

	@BeforeEach
	void setUp() throws Exception {
		id = 1234567;
		name = "John Doe";
		street = "1234 Main St";
		city = "Portland";
		state = "Oregon";
		zip = "12345";
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateMemberWithCorrectInput() {
		Boolean result = Controller.CreateMember(id, name, street, city, state, zip);
		assertTrue("Member not created", result);
	}

	@Test
	void testDeleteMember() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateMember() {
		fail("Not yet implemented");
	}

	@Test
	void testSetMemberSuspension() {
		fail("Not yet implemented");
	}

	@Test
	void testValidateMember() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMember() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllMembers() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateProvider() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteProvider() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateProvider() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProvider() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllProviders() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateConsultation() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteConsultation() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateConsultation() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllConsultations() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateService() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteService() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateService() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllServices() {
		fail("Not yet implemented");
	}

	@Test
	void testGetServiceName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetServiceCode() {
		fail("Not yet implemented");
	}

}
