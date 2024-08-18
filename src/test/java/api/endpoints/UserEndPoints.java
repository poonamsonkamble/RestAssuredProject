package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//created for perform create,Read,Update and delete(CRUD) requests the user API
public class UserEndPoints {

	public static Response createUser(User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url);

		return response;
	}

	public static Response readUser(String userName) {
		Response response = given().pathParam("userName", userName).when().get(Routes.get_url);
		return response;
	}

	public static Response updateUser(User payload, String userName) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("userName", userName).body(payload).when().put(Routes.put_url);

		return response;
	}

	public static Response deleteUser(String userName) {
		Response response = given().pathParam("userName", userName).when().delete(Routes.delete_url);

		return response;
	}

}
