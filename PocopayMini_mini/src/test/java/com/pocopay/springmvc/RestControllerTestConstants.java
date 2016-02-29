package com.pocopay.springmvc;

public class RestControllerTestConstants {

	//Request
	public static String JSON_BODY_FOR_NEW_ACCOUNT ="{\"ownerName\":\"NAIM\",\"dateOfBirth\":\"04-05-1988\"}";
	public static String JSON_BODY_FOR_NEW_PAYMENT ="{\"srcAccountID\":\"1\",\"destAccountID\":\"2\", \"paymentAmount\":\"100.00\", \"paymentReference\":\"Ref 02\" }";
	
	//Response		
	public static String EXPECTED_200_JSON_PAYMENT_HISTORY = "[{\"paymentID\":1,\"srcAccountID\":1,\"destAccountID\":2,\"paymentAmount\":100.000,"
				+ "\"paymentReference\":\"Test Payment\",\"transactionTime\":{\"dayOfMonth\":1,\"month\":\"JANUARY\","
				+ "\"monthValue\":1,\"year\":2016,\"dayOfWeek\":\"FRIDAY\",\"hour\":1,\"minute\":1,\"nano\":0,\"second\":1,"
				+ "\"dayOfYear\":1,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}}}]";
		
	public static String EXPECTED_200_JSON_BODY_FOR_GET_ACCOUNT = "{\"accountID\":1,\"ownerName\":\"PAYEL\",\"dateOfBirth\":\"25-11-1982\",\"accountBalance\":500.000}";
	
	
	public static String EXPECTED_200_JSON_PAYMENT_BY_ID_1 = "{\"paymentID\":1,\"srcAccountID\":1,\"destAccountID\":2,\"paymentAmount\":100.000,\"paymentReference\":\"Test Payment\",\"transactionTime\":{\"dayOfMonth\":1,\"month\":\"JANUARY\",\"monthValue\":1,\"year\":2016,\"dayOfWeek\":\"FRIDAY\",\"hour\":1,\"minute\":1,\"nano\":0,\"second\":1,\"dayOfYear\":1,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}}}";
	
}
