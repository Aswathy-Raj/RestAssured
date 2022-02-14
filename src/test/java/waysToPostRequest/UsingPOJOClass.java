package waysToPostRequest;


	import static io.restassured.RestAssured.*;

	import org.testng.annotations.Test;

	import com.rest.restProject.PojoClassTest;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

	public class UsingPOJOClass {

		@Test
		public void createProjPojo() {
			PojoClass poj=new PojoClass("babu", "KF Strong", "created", 650);
			
			given()
				.body(poj)
				.contentType(ContentType.JSON)
			.when()
				.post("http://localhost:8084/addProject")
			.then()
				.assertThat().statusCode(201)
				.contentType(ContentType.JSON)
				.log().all();
		}
	}

