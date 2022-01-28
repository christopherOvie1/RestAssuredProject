package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestExample4 {
	//@Test
	public void putRequest() {
		
		JSONObject request = new JSONObject();
   	 
  	  request.put("name","morpheus");
  	  request.put("job","leader");
  	  System.out.println(request.toString());
  	  
  	  baseURI= "https://reqres.in/api";
  	  given()
  	             .header("Content-Type","application/json")
  	             .contentType(ContentType.JSON)
  	              .accept(ContentType.JSON)
  	             .body(request.toJSONString())
  	  .when()
  	             .put("/users/2")
  	  .then().statusCode(200)
  	          .log().all();
	}
	@Test
	public void patchRequest() {
		
		JSONObject request = new JSONObject();
   	 
  	  request.put("name","morpheus");
  	  request.put("job","leader");
  	  System.out.println(request.toString());
  	  
  	            baseURI= "https://reqres.in";
  	  given()
  	             .header("Content-Type","application/json")
  	             .contentType(ContentType.JSON)
  	              .accept(ContentType.JSON)
  	             .body(request.toJSONString())
  	  .when()
  	             .patch("/api/users/2")
  	  .then()
  	           .statusCode(200)
  	           .log().all();
	}
}
