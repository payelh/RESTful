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

# Request
> Create Account :

POST http://localhost:8090/pocopay/v1/account/

{
    "ownerName":"BART",
    "dateOfBirth":"01-01-2010"
}

Return 200 OK & New account URI in HTTP heder < http://localhost:8090/pocopay/v1/account/3 >

> Get Account :

GET http://localhost:8090/pocopay/v1/account/1/

Return 200 OK & Account Data in JSON Format




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

# Configuration
> Application 

application.properties

> Database Connectivity 

jdbc.properties

> Logger Configuration

logback.xml

