package tests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;




public class TestOnLocalAPI {
//@Test
	public void getRequest() {
		baseURI= "http://localhost:3000";
		
		given()
		.get("/users")
		.then()
		.statusCode(200).log().all();	
	}
	//@Test
	public void postRequest() {
		JSONObject request = new JSONObject();
		request.put("firstName", "solomon");
		request.put("lastName", "Etetafia");
		request.put("subjectId", 1);
		request.put("id", 5);
		baseURI= "http://localhost:3000";
		given()
		   .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
		    .body(request.toJSONString())
	  .when()
		.post("/users")
		.then().statusCode(201).log().all();
	}
//	@Test
	public void pUtRequest() {
		JSONObject request = new JSONObject();
		request.put("firstName", "oghomwen");
		request.put("lastName", "sule");
		request.put("subjectId", 1);
		//request.put("id", 5);
		baseURI= "http://localhost:3000";
		given()
		   .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
		    .body(request.toJSONString())
	  .when()
		.put("/users/5")
		.then().statusCode(200).log().all();
	}
	//@Test
	public void patchRequest() {
		JSONObject request = new JSONObject();
		request.put("firstName", "oghomwen");
		
		baseURI= "http://localhost:3000";
		given()
		   .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
		    .body(request.toJSONString())
		    
	  .when()
		.patch("/users/5")
		.then().statusCode(200).log().all();
	}
	@Test
	public void deleteRequest() {
		baseURI= "http://localhost:3000";
		when().delete("/users/5")
		.then()
		.statusCode(200);
		
	}
}
