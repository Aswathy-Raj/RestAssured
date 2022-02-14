package requestChaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.rest.restProject.PojoClassTest;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PostAndDeleteRequestChainingTest {

	@Test
	public void postAndDel() {
		Random randNum = new Random();
		int ranNum=randNum.nextInt();
		String projName="film"+ranNum;
		PojoClass poj = new PojoClass("basha", projName, "created", 30);
		
		 Response resp = given()
			.body(poj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject");
//		resp.then()
//			.assertThat().statusCode(201)
//			.contentType(ContentType.JSON)
//			.log().all();
		
		
		String res = resp.jsonPath().get("projectId");
		when()
			.delete("http://localhost:8084/projects/"+res)
		.then()
			.assertThat().statusCode(204)
			.contentType(ContentType.JSON)
			.log().all();
		
		
	}
}
