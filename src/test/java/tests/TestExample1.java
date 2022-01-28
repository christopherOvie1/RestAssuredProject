package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestExample1 {
	@Test
	public void test_01() {
		
		Response resp= RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(),200);
		
	}

}
