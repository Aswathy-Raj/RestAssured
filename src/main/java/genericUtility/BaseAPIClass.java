package genericUtility;


	import static io.restassured.RestAssured.*;

	import java.sql.SQLException;

	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeSuite;
	/**
	 * 
	 * @author Aswathy
	 *
	 */

	public class BaseAPIClass {

		public DatabaseUtility dLib=new DatabaseUtility();
		public JavaUtility jLib=new JavaUtility();
		public RestAssuredUtility rLib=new RestAssuredUtility();
		
		@BeforeSuite
		public void bsConfig() throws Throwable {
			baseURI="http://localhost";
			port=8084;
			dLib.connectToDB();
			System.out.println("database connection established");
		}
		
		@AfterSuite
		public void asConfig() throws SQLException {
			dLib.closeDB();
			System.out.println("database connection closed");
		}
		
}
