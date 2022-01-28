package tests;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class TesExample3 {
     // @Test
	public void GetAndPostAPI() {
    	  
    	  
    	baseURI= "https://reqres.in/api";
    	given()
    	.get("/users?page=2")
    	.then()
    	.statusCode(200)
    	.body("data[4].first_name",equalTo("George"))
    	.body("data.first_name", hasItems("Michael","Lindsay","George","Tobias"));
		
	}
      @Test
      public void POST() {
    	  Map<String, Object> map = new HashMap<String, Object>();
    	 // map.put("\"name\"", "morpheus");
    	 // map.put("job", "leader");
    	  //System.out.println("it is "+map);
    	  
    	  JSONObject request = new JSONObject(map);
    	 
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
    	             .post("/users")
    	  .then().statusCode(201)
    	          .log().all();
      }
}
