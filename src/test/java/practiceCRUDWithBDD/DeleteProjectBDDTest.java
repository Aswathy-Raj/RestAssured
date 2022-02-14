package practiceCRUDWithBDD;


	import static io.restassured.RestAssured.*;

	import org.testng.annotations.Test;

	public class DeleteProjectBDDTest {

		@Test
		public void delProject() {
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_004")
			
		.then()
			.assertThat().statusCode(204)
			.log().all();
		}
	}

