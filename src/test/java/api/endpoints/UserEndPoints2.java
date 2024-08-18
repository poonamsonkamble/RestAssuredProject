package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;

import api.payloads.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//created for perform create,Read,Update and delete(CRUD) requests the user API
public class UserEndPoints2 {

//	public static String getURL(String key) throws IOException {
//		FileInputStream input = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\RestAssuredProject\\src\\test\\resources\\routes.properties");
//		Properties prop = new Properties();
//		prop.load(input);
//		//get the property value and print it out
//		return prop.getProperty(key);
//		
//
//	}

	public static ResourceBundle getURL() {
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	

	public static Response createUser(User payload) throws IOException {
		String post_url = getURL().getString("post_url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(post_url);

		return response;
	}

	public static Response readUser(String userName) throws IOException {
		String get_url = getURL().getString("get_url");
		Response response = given().pathParam("userName", userName).when().get(get_url);
		return response;
	}

	public static Response updateUser(User payload, String userName) throws IOException {
		String put_url = getURL().getString("put_url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("userName", userName).body(payload).when().put(put_url);

		return response;
	}

	public static Response deleteUser(String userName) throws IOException {
		String delete_url = getURL().getString("delete_url");
		Response response = given().pathParam("userName", userName).when().delete(delete_url);

		return response;
	}

}
