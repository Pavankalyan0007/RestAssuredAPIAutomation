import Files.payload;
import io.restassured.path.json.JsonPath;

public class CompareJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(payload.CoursePrice());

		// Print the No of Courses in API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		// Print the Purchase Amount

		int TotalPurchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(TotalPurchaseAmount);

		// Print the first Course
		String FirstCurse = js.get("courses[0].title");
		System.out.println(FirstCurse);
		// Print the Third Course
		String ThirdCurse = js.get("courses[2].title");
		System.out.println(ThirdCurse);

		// Print All title and prices
		for (int i = 0; i < count; i++) {
			String Courses = js.get("courses[" + i + "].title");
			System.out.println(Courses);
			System.out.println(js.getInt("courses[" + i + "].price"));

		}
		System.out.println("Print the no of copies sold by RPA");
		for (int i = 0; i < count; i++) {
			String Courses = js.get("courses[" + i + "].title");
			if (Courses.equalsIgnoreCase("RPA")) {
				int Copies = js.get("courses[" + i + "].copies");
				System.out.println(Copies);
				break;
			}
		}
		//Varify Total count of all courses
		
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
