package com.RMGYANTRATest;

import static io.restassured.RestAssured.given;


import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



import PojoLibrary.PojoClass;
import genericUtility.IEndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateResourseAndVerifyInDB extends genericUtility.BaseAPIClass{

	@Test
	public void updateResourseAndVerifyInDB() throws Throwable {
		PojoClass poj=new PojoClass("Chaitra", "Tyss"+jLib.getRandomNum(), "completed", 10);
		
		Response resp = given()
				.body(poj)
				.contentType(ContentType.JSON)
			.when()
				.put(IEndPoints.updateProjects);
		
		String expData=rLib.getJSONData(resp, "projectId");
		System.out.println(expData);
		
		String query="select * from project;";
		String actData=dLib.executeQueryAndGetData(query, 1, expData);
		Reporter.log(actData, true);
		
		Assert.assertEquals(expData, actData);
		Reporter.log("validation  succesful", true);
	}
}