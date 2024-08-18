package api.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest2 {

	Faker faker;
	User userPayload;
    Logger log;
	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		userPayload = new User();
		log=LogManager.getLogger(this.getClass());
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(8, 10));
		userPayload.setPhone(faker.phoneNumber().phoneNumber());
		userPayload.setUsername(faker.name().username());

	}

	@Test(priority = 1)
	public void testPostUser() throws IOException {
		log.info("Post method Started");
		Response response = UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		log.info("Post method Ended");
	}

	@Test(priority = 2)
	public void testGetUserByName() throws IOException {
		log.info("Get method Started");
		Response response = UserEndPoints2.readUser(userPayload.getUsername());
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		log.info("Get method Ended");
	}

	@Test(priority = 3)
	public void testUpdateUserByName() throws IOException {
		log.info("Put method Started");
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(8, 10));
		userPayload.setPhone(faker.phoneNumber().phoneNumber());
		Response response = UserEndPoints2.updateUser(userPayload, userPayload.getUsername());
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		testGetUserByName();
		log.info("Put method Ended");
	}

	@Test(priority = 4)
	public void testDeleteUserByName() throws IOException {
		log.info("Delete method Started");
		Response response = UserEndPoints2.deleteUser(userPayload.getUsername());
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		log.info("Delete method Ended");
	}

}
