package Com.Test.HarshitJain.pageObjects;

import java.net.MalformedURLException;
import java.net.URL;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class APIBasePage {

	public int getStatusCode(String url){
		System.out.println("Current url is >>> " + url);
		int code = RestAssured.given().when().get(url).then().extract().statusCode();
		System.out.println(code);
		return code;
	}
	
	public Response postRequest(String url,String body){
        try {
            return RestAssured.given().contentType("application/json").body(body).when().post(new URL(url)).then().extract().response();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }return null;
    }
	
	public String createBody(String title, String body, int userId) {
		String jsonBody = new JSONObject()
                .put("title", title)
                .put("body", body)
                .put("userId", userId)
                .toString();
		return jsonBody;
	}

}
