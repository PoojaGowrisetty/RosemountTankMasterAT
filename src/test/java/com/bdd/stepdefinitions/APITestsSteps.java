package com.bdd.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import org.testng.Assert;
public class APITestsSteps {
	
	private String apiUrl;
    private Response response;
    
	@Given("the TankMaster API endpoint is {string}")
	public void the_tank_master_api_endpoint_is(String url) {
		apiUrl = url;
	}
	@When("I send a GET request to the TankMaster API")
	public void i_send_a_get_request_to_the_tank_master_api() {
	    response = given().header("Accept","application/json").when().get(apiUrl);
	}
	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer statusCode) {
		 Assert.assertEquals(response.getStatusCode(), statusCode.intValue());
	}
	


}
