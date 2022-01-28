package tests;

 import static io.restassured.RestAssured.*;
 import static io.restassured.matcher.RestAssuredMatchers.*;
 import static  org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
public class TestExample2 {

	@Test
	public void get_01() {
		
		baseURI="https://reqres.in/api";
		
		given()
		   .get("/users?page=2")
		   .then()
		   .statusCode(200)
		   .body("data.id[1]",equalTo(8))
		   .log().all();
		

	}
}
