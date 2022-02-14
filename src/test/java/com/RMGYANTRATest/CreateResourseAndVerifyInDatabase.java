package com.RMGYANTRATest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


import PojoLibrary.PojoClass;
import genericUtility.BaseAPIClass;
import genericUtility.IEndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateResourseAndVerifyInDatabase extends BaseAPIClass{

	@Test
	public void createResourseAndVerifyInDatabase() throws SQLException {
	PojoClass poj=new PojoClass("Chaitra", "Nyka"+jLib.getRandomNum(), "completed", 100);
	
	Response resp = given()
		.body(poj)
		.contentType(ContentType.JSON)
	.when()
		.post(IEndPoints.createProjects);
	
	String expData=rLib.getJSONData(resp, "projectId");
	System.out.println(expData);
	
	String query="select * from project;";
	String actData=dLib.executeQueryAndGetData(query, 1, expData);
	Reporter.log(actData, true);
	
	Assert.assertEquals(expData, actData);
	Reporter.log("validation succesful", true);
}
}
