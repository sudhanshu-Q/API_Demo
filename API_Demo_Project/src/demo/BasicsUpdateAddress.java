package demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class BasicsUpdateAddress {

	public static void main(String[] args)
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";

		//Store the response in String format without using log() method

		String response=given().log().all().queryParam("key", "qaclick123").body(Payload.addPlace()).when()
				.post("/maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).extract().response().asString();

		//Print the response 
		System.out.println(response);

		//To take input as string and parse it to json we need json path.
		JsonPath js=new JsonPath(response);
		String PLACEID=js.getString("place_id");
		System.out.println(PLACEID);	

		//update or put address value
		//Update the address
		String newAddress="bengalutru";
		String resAddress=given().log().all().
				queryParam("key","qaclick123").header("Content-Type","application/json").
				body("{\r\n" + 
						"\"place_id\":\""+PLACEID+"\",\r\n" + 
						"\"address\":\""+newAddress+"\",\r\n" + 
						"\"key\":\"qaclick123\"\r\n" + 
						"}\r\n" + 
						"").
				when().put("/maps/api/place/update/json")
				.then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated")).extract().response().asString();

		//Get place

		String getPaceadd=given().log().all().queryParam("key","qaclick123").queryParam("place_id",PLACEID)
				.when().get("/maps/api/place/get/json").then().log().all().statusCode(200).extract().response().asString();

		//To validate the given address and the response address
		
		System.out.println(resAddress);//put method
		System.out.println(getPaceadd);//Get method

		//validating the address "bengaluru"
		JsonPath jsAdd=new JsonPath(getPaceadd);
		String validateAddress=jsAdd.getString("address");
		System.out.println(validateAddress);
		
		//Testng to validate the address in response
		
		

	}

}
