package demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetPlace {

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
		
		
				
	}

}
