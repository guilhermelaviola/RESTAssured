package tests;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {

	@Test
	public void TestPut() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Michelle");
		request.put("job", "Reporter");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users").
		then().
			statusCode(200)
			.log().all();
	}
	
	@Test
	public void TestPatch() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Nelson");
		request.put("job", "Doctor");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200)
			.log().all();
	}
	
	@Test
	public void TestDelete() {
		
		baseURI = "https://reqres.in";
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204)
			.log().all();
	}
}
