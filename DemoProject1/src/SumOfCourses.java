import org.testng.annotations.Test;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class SumOfCourses {

	@Test
	public void sumValidation() {
		JsonPath js = new JsonPath(payload.CoursePrice());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		int TotalA =0;
		for (int i = 0; i < count; i++) 
		{
			
			int price = js.get("courses[" + i + "].price");
			int copies = js.get("courses[" + i + "].copies");
			TotalA = price * copies +TotalA;
			
			}
		System.out.println(TotalA);
	}
}
