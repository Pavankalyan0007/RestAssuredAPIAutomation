package Files;

import io.restassured.path.json.JsonPath;

public class ReeuableMethods {

	public static JsonPath rawTojson(String Response) {
		JsonPath js1 = new JsonPath(Response);
		return js1;
	}
}
