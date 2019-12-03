package ChocAn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserModelTest {

	UserModel testUserModel;
	
	@BeforeEach
	void setUp(){
		testUserModel = new UserModel();
		testUserModel.id = 123456;
		testUserModel.name = "name";
		testUserModel.street = "street";
		testUserModel.city = "city";
		testUserModel.state = "state";
		testUserModel.zip = "zip";
	}
	
	@AfterEach
	void tearDown(){
		testUserModel = null;
	}
	
	@Test
	void testConstructor() {
		UserModel newUserModel = new UserModel();
		asserNotNull("UserModel constructor failed",newUserModel);
	}

}
