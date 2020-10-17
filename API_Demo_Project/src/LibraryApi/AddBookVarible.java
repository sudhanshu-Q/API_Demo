package LibraryApi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddBookVarible 
{
	@Test
	//creating a method to pass variable in payload
	public void addBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		String resp=given().header("Content-Type","application/json").body(Payload.AddbookVariablePayload("iasdsasbn","aisle")).
				when().post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonResp=new JsonPath(resp);
		String id=jsonResp.get("ID");
		System.out.println(id);
	}


}
