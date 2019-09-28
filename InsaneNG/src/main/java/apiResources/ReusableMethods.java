package apiResources;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods {

	// Function fr json parser to conver raw response to JsonPath
	public static JsonPath rawToJson(Response res) {

		String resString = res.asString();
		JsonPath js = new JsonPath(resString);
		return js;
	}

	public static XmlPath rawToXml(Response res) {
		String resString = res.asString();
		XmlPath x = new XmlPath(resString);
		return x;
	}
}
