package ChocAn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ChocAn.IModel.Action;

class ServiceTest {

	Service testService;
	final int testCode = 124567;
	final String testName = "Back fixer";
	
	@BeforeEach
	void setUp() throws Exception {
		testService = new Service();
		testService.code = testCode;
		testService.name = testName;
	}
	
	@AfterEach
	void tearDown() throws Exception {
		testService = null;
	}

	@Test
	void testConstructor() {
		Service newService = new Service();
		assertNotNull("Service Constructor failed", newService);
	}
	
	@Test
	void testAddToDatabase() {
		boolean result = testService.Database(Action.ADD);
		assertEquals("Service not added", true, result);
		testService.Database(Action.DELETE);
	}
	
	@Test
	void testDeleteFromDatabase() {
		testService.Database(Action.ADD);
		boolean result = testService.Database(Action.DELETE);
		assertEquals("Service not deleted", true, result);
	}

	@Test
	void testGet() {
		testService.Database(Action.ADD);
		Service result = testService.Get(testService.code);
		assertEquals("Could not retrieve Service", testService.code, result.code);
		testService.Database(Action.DELETE);
	}

	@Test
	void testGetAll() {
		List<Service> list = null;
		list = testService.GetAll();
		assertNotNull("Could not get all Service", list);
	}
	
	@Test
	void testGetServiceName() {
		testService.Database(Action.ADD);
		Service newService = new Service();
		String serviceName = newService.GetServiceName(testService.code);
		assertEquals("Get service name failed", testName, serviceName);
		testService.Database(Action.DELETE);
	}
	
	@Test
	void testGetServiceCode() {
		testService.Database(Action.ADD);
		Service newService = new Service();
		int serviceCode = newService.GetServiceCode(testService.name);
		assertEquals("Get service code failed", testCode, serviceCode);
		testService.Database(Action.DELETE);
	}
}
