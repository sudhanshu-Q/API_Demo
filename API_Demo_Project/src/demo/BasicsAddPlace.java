package demo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static demo.Payload.*;
import static org.hamcrest.Matchers.*;


public class BasicsAddPlace 
{

	public static void main(String[] args) 
	{
		System.out.println("hi");
		//Comment
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123")
      .header("Content-Type","application/json").body(Payload.addPlace())
      .when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).
      body("scope", equalTo("APP"))
      .header("Server", equalTo("Apache/2.4.18 (Ubuntu)"));
		System.out.println("Add place code");
	}

}
