package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class SumValidation 
{
	@Test
	public void sumOfCourses()
	{
		int sum=0;
		JsonPath jsCourses=new JsonPath(Payload.NestedArrayJson());
		int countCourse=jsCourses.getInt("courses.size()");
		for(int i=0;i<countCourse;i++)
		{
			int price=jsCourses.getInt("courses["+i+"].price");
			int copies=jsCourses.getInt("courses["+i+"].copies");
			int amount=price*copies;
			System.out.println(amount);
			sum=sum+amount;
			
		}
		System.out.println(sum);
		int purchaseAmt=jsCourses.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmt);
		Assert.assertEquals(sum, purchaseAmt);
	}

}
