package LibraryApi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson
{
	@Test
	public void addBook()
	{
		//Base URL
		RestAssured.baseURI="http://216.10.245.166";

		//Capturing response for gien, when and then
		String resp=given().log().all().header("Content-Type","application/json").body(Payload.addBook()).
				when().

				//Resource=/Library/Addbook.php
				post("/Library/Addbook.php").
				then().log().all().assertThat().statusCode(200).extract().response().asString();

		//Printing the response
		JsonPath js=new JsonPath(resp);
		String iD=js.getString("ID");
		System.out.println("ID generated :"+iD);

	}
}
