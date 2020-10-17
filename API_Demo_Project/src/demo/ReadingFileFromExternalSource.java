package demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;

public class ReadingFileFromExternalSource {

	public static void main(String[] args) throws IOException 
	{
		{
			System.out.println("hi");

			RestAssured.baseURI="https://rahulshettyacademy.com";
			String resp=given().log().all().queryParam("key", "qaclick123")
					.header("Content-Type","application/json").
					body(new String(Files.readAllBytes(Paths.get("./src/demo/externalStaticData.json"))))
					.when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).
					body("scope", equalTo("APP"))
					.header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).log().all().extract().response().asString();
			System.out.println("Add place code");
			System.out.println(resp);
		}
	}

}
