package apiResources;

public class payLoad {

	public static String getAddMovieBody() {
		String payload1 = "{\r\n" + 
				"  \"movie\": {\r\n" + 
				"    \"rating\": 1,\r\n" + 
				"    \"title\": \"TestersSQAUD\",\r\n" + 
				"    \"description\": \"Test for autothon testers squad\",\r\n" + 
				"    \"categories\": [\r\n" + 
				"      \"Comedy\"\r\n" + 
				"    ],\r\n" + 
				"    \"image\": \"https://upload.wikimedia.org/wikipedia/en/6/62/Dirty_Grandpa_teaser_poster.jpg\",\r\n" + 
				"    \"director\": \"TEST DIRECTOR\",\r\n" + 
				"    \"reviews\": [],\r\n" + 
				"    \"rented\": false\r\n" + 
				"  }\r\n" + 
				"}\r\n" + 
				"";

		return payload1;
	}
	
	
	
	

	
	

}
