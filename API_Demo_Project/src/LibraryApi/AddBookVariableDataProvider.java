package LibraryApi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddBookVariableDataProvider 
{
	@Test(dataProvider="BooksData")
	//creating a method to pass variable in payload
	public void addBook(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String resp=given().header("Content-Type","application/json").body(Payload.AddbookVariablePayload(isbn,aisle)).
				when().post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jsonResp=new JsonPath(resp);
		String id=jsonResp.get("ID");
		System.out.println(id);
	}
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"fg","23"},{"dasfd","855"},{"dadadc","33"}};
	}
}
