package demo;

import io.restassured.path.json.JsonPath;

public class NestedJSon {

	public static void main(String[] args) 
	{

		JsonPath jsNested=new JsonPath(Payload.NestedArrayJson());

		//Print Number Of Course Returned By API

		int countCousres=jsNested.getInt("courses.size()");
		System.out.println(countCousres);
		
		//Print purchase amount
		int countPurchaseAmount=jsNested.getInt("dashboard.purchaseAmount");
		System.out.println(countPurchaseAmount);
	
		//Print Title of the first course
		
		String titleFirstCourse=jsNested.get("courses[0].title");
		System.out.println(titleFirstCourse);
		
		//Print All course titles and their respective Prices
		
		for (int i=0;i<countCousres;i++)
		{
			String courseTitle=jsNested.getString("courses["+i+"].title");
			System.out.println(courseTitle);
			int coursePrices=jsNested.getInt("courses["+i+"].price");
			System.out.println(coursePrices);
		}
		
	   //Print no of copies sold by RPA Course
		for (int i=0;i<countCousres;i++)
		{
			String getCourseTitle=jsNested.getString("courses["+i+"].title");
           if (getCourseTitle.equals("RPA"))
           {
        	   System.out.println(jsNested.getInt("courses["+i+"].copies"));
        	   break;
           }
		}
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		
		
	}
	

}
