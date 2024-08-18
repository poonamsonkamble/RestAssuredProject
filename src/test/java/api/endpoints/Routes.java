package api.endpoints;

/*
    get_url="https://petstore.swagger.io/v2/user"
    post_url="https://petstore.swagger.io/v2/user/createUser"
    put_url="https://petstore.swagger.io/v2/user/updateUser"
    delete_url="https://petstore.swagger.io/v2/user/deleteUser"
 */

public class Routes {

	public static String base_URL = "https://petstore.swagger.io/v2/user";
	public static String post_url = base_URL;
	public static String get_url = base_URL + "/{userName}";
	public static String put_url = base_URL + "/{userName}";
	public static String delete_url = base_URL + "/{userName}";
}
