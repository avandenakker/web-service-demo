## About
This is a demo application that illustrates creating a RESTful API for manipulating with Demo Objects in Spring Boot 5.0.


Technologies: Spring 5.0, Spring Boot + Spring Security OATH2 (2.2.3) 

For Spring Security OATH I used as basis Spring Boot REST API (4) - Security with OAuth2 
(https://gigsterous.github.io/engineering/2017/03/01/spring-boot-4.html), but upgraded it to Spring 5.0.

## Get token
```
curl -X POST http://localhost:8080/oauth/token --user webservicedemo:secret -d grant_type=password -d username=annavdakker -d password=password
```

## Example commands
```
curl -i -H "Accept: application/json" -H "Authorization: Bearer $access_token" -X GET http://localhost:8080/objects
```
