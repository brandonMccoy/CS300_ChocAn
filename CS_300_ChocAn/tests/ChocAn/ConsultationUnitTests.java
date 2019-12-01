package ChocAn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ChocAn.IModel.Action;

class ConsultationUnitTests {
	
	Consultation testConsultation;
	
	@BeforeEach
	void beforeEach() {
		testConsultation = new Consultation();
		testConsultation.id = 123456;
		testConsultation.memberNumber = 234567;
		testConsultation.serviceCode = 345678;
		testConsultation.fee = "999.99";
		testConsultation.memberName = "John Doe";
		testConsultation.providerNumber = 456789;
		testConsultation.comment = "comments go here";
	}
	
	@AfterEach
	void afterEach() {
		testConsultation = null;
	}
	
	@Test
	void testConstructor() {
		Consultation newConsultation = new Consultation();
		assertNotNull("Constructor failed", newConsultation);
	}

	@Test
	void addToDatabase() {
		Consultation c = new Consultation();
		boolean result = c.Database(Action.ADD);
		assertEquals("Consultation not added", true, result);
	}
	
	@Test
	void deleteFromDatabase() {
		testConsultation.Database(Action.ADD);
		boolean result = testConsultation.Database(Action.DELETE);
		assertEquals("Consultation not deleted", true, result);
	}

	@Test
	void testGet() {
		testConsultation.Database(Action.ADD);
		Consultation result = testConsultation.Get(testConsultation.id);
		assertEquals("Could not retrieve consultation", testConsultation, result);
	}

	@Test
	void testGetAll() {
		List<Consultation> list = null;
		list = testConsultation.GetAll();
		assertNotNull("Could not get all consultations", list);
	}

	@Test
	void testPrint() {
		testConsultation.Print();
	}

}
