package practiceCRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetAllProjectTest {

	@Test
	public void getAllProjects() {
		int expStatus=200;
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		System.out.println(resp.prettyPeek());
		int actStatus = resp.getStatusCode();
		Assert.assertEquals(expStatus, actStatus);
	}
}
