package com.pocopay.springmvc;

//import com.pocopay.springmvc.configuration.PocopayServiceConfiguration;
//import com.pocopay.springmvc.configuration.PocopayServiceConfigurationInitializer;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.expect;

import org.hamcrest.Matchers;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.pocopay.springmvc.configuration.PocopayAppConfiguration;
import com.pocopay.springmvc.configuration.PocopayAppConfigurationInitializer;

import com.pocopay.springmvc.RestControllerTestConstants;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { PocopayAppConfiguration.class, PocopayAppConfigurationInitializer.class})

public class PocopayAccountRestControllerTest {

	@Before
    public void setup() {        
    	RestAssured.baseURI = "http://localhost:8090/pocopay";
        RestAssured.port = 8090;   
    }

	// ACCOUNT Info, Method: Get - Expected: 200 for Valid Account ID
    @Test      
    public void getAccount_shouldReturnAccountForValidID() {
      expect().
        statusCode(200).
        body(Matchers.equalTo(RestControllerTestConstants.EXPECTED_200_JSON_BODY_FOR_GET_ACCOUNT)).
        when().
        get("/v1/account/{id}",1); // 1 is valid ID
    }
    
    //ACCOUNT Info, Method: Get - Expected: 401 for invalid Account ID
    @Test     
    public void getAccount_shouldReturn404forInvalidID() {
      expect().
        statusCode(404).
        when().
        get("/v1/account/{id}",-1); // -1 is valid ID
    }   
    
    //ACCOUNT Create, Method: Post - Expected: 201 for valid credentials
    @Test     
    public void createAccount_shouldReturn201WhenNewAccountCreated() {
    	given().contentType(ContentType.JSON)
        .body(RestControllerTestConstants.JSON_BODY_FOR_NEW_ACCOUNT)
        .when()
        .post("/v1/account/")
        .then()
        .statusCode(201);
    }  
    
    // ACCOUNT Create, Method: Post - Expected: 409 For Duplicate request
	@Test 
    public void createAccount_shouldReturn409WhenAccountExists() {
        given().contentType(ContentType.JSON)
        .body(RestControllerTestConstants.JSON_BODY_FOR_NEW_ACCOUNT)
        .when()
        .post("/v1/account/")
        .then()
        .statusCode(409);
    } 
    
    // ACCOUNT Transaction Info - GET - Expected: 200 for Valid Request	
    @Test      
    public void getPaymentHistory_shouldReturnPaymentsDetailJSON() {
    	expect().
        	statusCode(200).
        body(Matchers.equalTo(RestControllerTestConstants.EXPECTED_200_JSON_PAYMENT_HISTORY)).
        when().
        get("/v1/account/{id}/transaction/",1); // 1 is valid ID	
           
    }
    
}