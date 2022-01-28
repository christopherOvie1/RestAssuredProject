package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;


import org.testng.annotations.Test;


@Test
public class TestExample5 {
	
public void deleteRequest() {
	
	
	  
	  baseURI= "https://reqres.in";
	  given()
	             
	  .when()
	             .delete("/api/users/2")
	  .then()
	            .statusCode(204)
	            .log().all();
	
}
	 
	
	
	
}
