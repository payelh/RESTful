# RESTful
RESTful web Service for PocoPay

> Spring MVC + Jetty + MyBatis + MySQL

# Commands
Build:	 gradlew build -x test

Start:	 gradlew jettyRun

Stop:	 gradlew jettyStop

Test:	 gradlew test

# TestResult
Get test result in PocopayMini/build/reports/tests/index.html

# Detail Explanation
https://github.com/payelh/RESTful/blob/master/Pocopay.docx

# Request
> Create Account :

POST http://localhost:8090/pocopay/v1/account/

{
    "ownerName":"BART",
    "dateOfBirth":"01-01-2010"
}

Return 200 OK & New account URI in HTTP heder < http://localhost:8090/pocopay/v1/account/3 >

> Attempt to create Account with duplicate credentials:

POST http://localhost:8090/pocopay/v1/account/

{
    "ownerName":"BART",
    "dateOfBirth":"01-01-2010"
}

Return 409  & Error detail in JSON Format, Moreover, ther is a option to put helpLink for developer


{
  "requestedUrl": "http://localhost:8090/pocopay/v1/account/",
  "errorCode": 409905,
  "message": "Account already exists with the requested credentials",
  "helpLink": "http://pocopaymin.com/devSupport/409905"
}


> Get Account :

GET http://localhost:8090/pocopay/v1/account/1/

Return 200 OK & Account Data in JSON Format

{
  "accountID": 1,
  "ownerName": "PAYEL",
  "dateOfBirth": "25-11-1982",
  "accountBalance": 500
}


> Create Payment :
POST http://localhost:8090/pocopay/v1/payment/

{
  "srcAccountID":"1",
  "destAccountID":"2",
  "paymentAmount":"100",
  "paymentReference":"Ref 01"
}

> Get Payment History from an Account :
GET http://localhost:8090/pocopay/v1/account/{id}/transaction

Return 200 OK & Payment History in JSON Format


[
  {
    "paymentID": 1,
    "srcAccountID": 1,
    "destAccountID": 2,
    "paymentAmount": 100,
    "paymentReference": "Test Payment",
    "transactionTime": {
      "dayOfMonth": 1,
      "month": "JANUARY",
      "monthValue": 1,
      "year": 2016,
      "dayOfWeek": "FRIDAY",
      "hour": 1,
      "minute": 1,
      "nano": 0,
      "second": 1,
      "dayOfYear": 1,
      "chronology": {
        "id": "ISO",
        "calendarType": "iso8601"
      }
    }
  }
]

# Configuration
> Application 

application.properties

> Database Connectivity 

jdbc.properties

> Logger Configuration

logback.xml

