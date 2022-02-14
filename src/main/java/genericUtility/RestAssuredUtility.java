package genericUtility;

import io.restassured.response.Response;

/**
 * this class contains all generic methods specific to rest assured
 * @author Aswathy
 *
 */
public class RestAssuredUtility {

	/**
	 * this method will return the data specified by jsonpath
	 * @param resp
	 * @param jsonPath
	 * @return
	 */
	public String getJSONData(Response resp,String jsonPath) {
		String jsonData = resp.jsonPath().get(jsonPath);
		return jsonData;
	}
	
}
