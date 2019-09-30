package com.hellofresh;

import com.hellofresh.api.TestBaseAPI;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * @author Avinash Patel
 *
 */
public class API_Tests extends TestBaseAPI{

	static Logger log = Logger.getLogger(API_Tests.class);
	String BASE_URL= "http://services.groupkt.com/country";


	@Test(priority=1, description="Test case to verify few countries(US,DE & GB) are validated  ")
	public void testcase_1() throws Exception {
		given()
		.when().get(BASE_URL+"/get/all")
		.then().statusCode(200).body("alpha2Code", hasItems("US","DE","GB"));	
	}

	@Test(priority=2, description="To validate responses of individual countries")
	public void testcase_2() throws Exception {
		given().when().get(BASE_URL+"/get/iso2code/US").then().statusCode(200)
		.body("RestResponse.result.name", equalTo("United States of America"))
		.body("RestResponse.result.alpha2_code", equalTo("US"))
		.body("RestResponse.result.alpha3_code", equalTo("USA"));

		given().when().get(BASE_URL+"/get/iso2code/DE").then().statusCode(200)
		.body("RestResponse.result.name", equalTo("Germany"))
		.body("RestResponse.result.alpha2_code", equalTo("DE"))
		.body("RestResponse.result.alpha3_code", equalTo("DEU"));

		
		given().when().get(BASE_URL+"/get/iso2code/GB").then().statusCode(200)
		.body("RestResponse.result.name", equalTo("United Kingdom of Great Britain and Northern Ireland"))
		.body("RestResponse.result.alpha2_code", equalTo("GB"))
		.body("RestResponse.result.alpha3_code", equalTo("GBR"));
	}

	@Test(priority=3, description="Test case to check for inexistent country code & validate the response")
	public void testcase_3() throws Exception {
		given().when().get(BASE_URL+"/get/iso2code/HF").then().statusCode(404)
		.body("RestResponse.messages", equalTo("No matching country found for requested code [HF]."));
	}
	
	@Test(priority=4, description="Test case to check for inexistent country code & validate the response")
	public void testcase_4() throws Exception {
		given().when().body("{name: \"Test Country\", alpha2_code: \"TC\", alpha3_code: \"TCY\"}")
		.post(BASE_URL+"/post/HF").then().statusCode(201);
	}


}
