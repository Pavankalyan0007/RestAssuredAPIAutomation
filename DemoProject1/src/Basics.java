import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.ReeuableMethods;
import Files.payload;
public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// validate if Add place API is worked as expected
		
		//Given  inputs need to give
		//When validate API
		//Ten response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
	String Response= 	given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.Addplace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		String PlaceId = js.getString("place_id");
		System.out.println(PlaceId);
		//Update
		String Address ="Venkatagiri AP";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \r\n"
				+ "    \"place_id\": \""+PlaceId+"\",\r\n"
				+ "   \"address\": \""+Address+"\",\r\n"
				+ "   \"key\":\"qaclick123\"\r\n"
				+ "   \r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//GET
		String Response2 = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", PlaceId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		JsonPath js1 = ReeuableMethods.rawTojson(Response2);
		String ActualAddress = js1.getString("address");
		System.out.println(ActualAddress);
		//TestNg //junit
		Assert.assertEquals(ActualAddress, Address);
		
	}
}
