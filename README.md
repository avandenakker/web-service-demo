## About
This is a demo application that illustrates creating a RESTful API for manipulating with Demo Objects (CRUD) in Spring Boot 5.0.


Technologies: Spring 5.0, Spring Boot + Spring Security OATH2 (2.2.3) 

For Spring Security OATH I used as basis Spring Boot REST API (Spring Boot 4) - Security with OAuth2 
(https://gigsterous.github.io/engineering/2017/03/01/spring-boot-4.html), but upgraded it to Spring 5.0.

## Get token
```
curl -X POST http://localhost:8080/oauth/token --user webservicedemo:secret -d grant_type=password -d username=annavdakker -d password=password
```

## Commands
### Get demo objects
```
curl -i -H "Accept: application/json" -H "Authorization: Bearer $access_token" -X GET http://localhost:8080/objects
```
### Get demo object by id
```
curl -i -H "Accept: application/json" -H "Authorization: Bearer $access_token" -X GET http://localhost:8080/objects/1
```
### Create demo object
```
curl -i -H "Content-Type: application/json" -H "Authorization: Bearer $access_token" -d "{\"name\": \"Den Bosch\", \"description\": \"This is a test description.\"}" POST http://localhost:8080/objects/
```
### Update demo object
```
curl -i -H "Content-Type: application/json" -H "Authorization: Bearer $access_token" -d "{\"name\": \"Den Bosch\", \"description\": \"This is an updated test description.\"}" -X PUT http://localhost:8080/objects/{id}
```
### Delete demo object
```
curl -i -H "Accept: application/json" -H "Authorization: Bearer $access_token" -X DELETE http://localhost:8080/objects/{id}
```
