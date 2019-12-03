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
	
	@BeforeEach
	void setUp() throws Exception {
		testService = new Service();
		testService.code = 123456;
		testService.name = "Back breaker, then fixer";
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
		Service newService = new Service();
		boolean result = newService.Database(Action.ADD);
		assertEquals("Service not added", true, result);
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
	}

	@Test
	void testGetAll() {
		List<Service> list = null;
		list = testService.GetAll();
		assertNotNull("Could not get all Service", list);
	}
	
	@Test
	void testGetServiceName() {
		
	}
	
	@Test
	void testGetServiceCode() {
		
	}
}
