package LibraryApi;

public class Payload
{
	public static String addBook()
	{
	String addPayload="{\r\n" + 
		"\r\n" + 
		"\"name\":\"asSn Appium Automation with Java\",\r\n" + 
		"\"isbn\":\"bsQWEcd\",\r\n" + 
		"\"aisle\":\"2WEdf7\",\r\n" + 
		"\"author\":\"Johnfds WEQWEQfoe\"\r\n" + 
		"}\r\n" + 
		"";
	return addPayload;
	}

	public static String AddbookVariablePayload(String isbn, String aisle) 
	//Method to add variable payload 
	{
		String payload="{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn feewrAppium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"Johnwerwe foe\"\r\n" + 
				"}\r\n" + 
				"";
		return payload;
	}
	

}
