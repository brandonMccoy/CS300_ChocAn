package ChocAn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ChocAn.IModel.Action;

class ProviderTest {

	Provider testProvider;
	
	@BeforeEach
	void setUp() throws Exception {
		testProvider = new Provider();
		testProvider.id = 654321;
		testProvider.name = "Providence";
		testProvider.street = "123 S Way";
		testProvider.city = "Portland";
		testProvider.state = "Oregon";
		testProvider.zip = "12345";
	}
	
	@AfterEach
	void tearDown() throws Exception {
		testProvider = null;
	}
	
	@Test
	void testConstructor() {
		Provider newProvider = new Provider();
		assertNotNull("Constructor failed", newProvider);
	}

	@Test
	void testAddToDatabase() {
		Provider c = new Provider();
		boolean result = c.Database(Action.ADD);
		assertEquals("Provider not added", true, result);
	}
	
	@Test
	void testDeleteFromDatabase() {
		testProvider.Database(Action.ADD);
		boolean result = testProvider.Database(Action.DELETE);
		assertEquals("Provider not deleted", true, result);
	}

	@Test
	void testGet() {
		testProvider.Database(Action.ADD);
		Provider result = testProvider.Get(testProvider.id);
		assertEquals("Could not retrieve Provider", testProvider.id, result.id);
	}

	@Test
	void testGetAll() {
		List<Provider> list = null;
		list = testProvider.GetAll();
		assertNotNull("Could not get all Provider", list);
	}

	@Test
	void testPrint() {
		testProvider.Print();
	}

}
