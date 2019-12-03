package ChocAn;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ChocAn.IModel.Action;

class MemberTest {

	Member testMember;
	
	@BeforeEach
	void setUp() throws Exception {
		testMember = new Member();
		testMember.id = 123456;
		testMember.name = "John Doe";
		testMember.street = "123 S Way";
		testMember.city = "Portland";
		testMember.state = "Oregon";
		testMember.zip = "12345";
	}
	
	@AfterEach
	void tearDown() throws Exception {
		testMember = null;
	}
	
	@Test
	void testConstructor() {
		Member newMember = new Member();
		assertNotNull("Member Constructor failed", newMember);
		assertEquals("Member SetSuspension failed", false, testMember.isSuspended);
	}

	@Test
	void testAddToDatabase() {
		Member c = new Member();
		boolean result = c.Database(Action.ADD);
		assertEquals("Member not added", true, result);
	}
	
	@Test
	void testDeleteFromDatabase() {
		testMember.Database(Action.ADD);
		boolean result = testMember.Database(Action.DELETE);
		assertEquals("Member not deleted", true, result);
	}

	@Test
	void testGet() {
		testMember.Database(Action.ADD);
		Member result = testMember.Get(testMember.id);
		assertEquals("Could not retrieve Member", testMember.id, result.id);
	}

	@Test
	void testGetAll() {
		List<Member> list = null;
		list = testMember.GetAll();
		assertNotNull("Could not get all Member", list);
	}
	
	@Test
	void testSetSuspension() {
		testMember.SetSuspension(true);
		assertEquals("Member SetSuspension failed", true, testMember.isSuspended);
		testMember.Database(Action.ADD);
		assertEquals("Member Update failed", true, testMember.Database(Action.UPDATE));
		assertEquals("Member SetSuspension failed", true, testMember.Get(testMember.id).isSuspended);
	}

	@Test
	void testPrint() {
		testMember.Print();
	}
}
