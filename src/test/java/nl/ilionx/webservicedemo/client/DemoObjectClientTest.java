package nl.ilionx.webservicedemo.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import nl.ilionx.webservicedemo.model.DemoObject;
import nl.ilionx.webservicedemo.util.RestPageImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoObjectClientTest {
	
	private static final String BASE_URL_FOR_OBJECTS = "http://localhost:8080/objects";
	
	private static final String AUTHENTICATION_URL = "http://localhost:8080/oauth/token";
	
	private RestTemplate restTemplate;
	
	@Before
	public void getRestTemplate() {
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setUsername("annavdakker");
		resourceDetails.setPassword("password");
		resourceDetails.setAccessTokenUri(AUTHENTICATION_URL);
		resourceDetails.setClientId("webservicedemo");
		resourceDetails.setClientSecret("secret");
		resourceDetails.setGrantType("password");
		resourceDetails.setScope(Arrays.asList("read", "write"));
		resourceDetails.setId("oauth2-resource");
		restTemplate = new OAuth2RestTemplate(resourceDetails, new DefaultOAuth2ClientContext());
	}

	
	@Test
	public void listDemoObjectsFirstPageIsRetrieved() {
		RestPageImpl page = restTemplate.getForObject(BASE_URL_FOR_OBJECTS + "?page=0&size=1", RestPageImpl.class);
		assertNotNull(page);
	    assertEquals("Amsterdam", page.getContent().get(0).getName());
		assertEquals(1, page.getSize());
	}
		
	@Test
	public void listDemoObjectsSecondPageIsRetrieved() {
		RestPageImpl page =restTemplate .getForObject(BASE_URL_FOR_OBJECTS + "?page=1&size=1", RestPageImpl.class);
		assertNotNull(page);
		assertEquals("Eindhoven", page.getContent().get(0).getName());
		assertEquals(1, page.getSize());
	}
	
	
	@Test
	public void getExistingObjectDetails() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "1");
		DemoObject demoObject =  restTemplate.getForObject(BASE_URL_FOR_OBJECTS+"/{id}", DemoObject.class, params);
		assertEquals("Amsterdam",demoObject.getName());
	}
	
	@Test
	public void getNotExistingObjectDetails() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "500");
		try {
		    restTemplate.getForEntity(BASE_URL_FOR_OBJECTS+"/{id}", ResponseEntity.class, params);
			fail("Should have received 404 Not Found");
		} catch(HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}
	
	@Test
	public void addAndDeleteDemoObject() {
		DemoObject demoObject = restTemplate.postForObject(BASE_URL_FOR_OBJECTS,
				new DemoObject("New York", "Description"), DemoObject.class );
		assertEquals("New York", demoObject.getName());
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", demoObject.getId().toString());
		
		restTemplate.delete(BASE_URL_FOR_OBJECTS+"/{id}", demoObject.getId().toString() );
		
		try {
			restTemplate.getForEntity(BASE_URL_FOR_OBJECTS + "/{id}", DemoObject.class, params);
			fail("Should have received 404 Not Found after deleting demo object");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}
	
	@Test
	public void addUpdateDeleteDemoObject() {
		
		DemoObject demoObject = restTemplate.postForObject(BASE_URL_FOR_OBJECTS,
				new DemoObject("London", "London description"), DemoObject.class );
		
		assertEquals("London", demoObject.getName());
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", demoObject.getId().toString());
		
		DemoObject updatedDemoObject = new DemoObject(demoObject.getId(), "London", "Updated description");
		restTemplate.put(BASE_URL_FOR_OBJECTS + "/{id}", updatedDemoObject, params);
		
		demoObject = restTemplate
				.getForObject(BASE_URL_FOR_OBJECTS + "/{id}", DemoObject.class, params);
		assertEquals("Updated description", demoObject.getDescription());
		
		restTemplate.delete(BASE_URL_FOR_OBJECTS+"/{id}", demoObject.getId().toString() );
		
		try {
			restTemplate.getForEntity(BASE_URL_FOR_OBJECTS + "/{id}", DemoObject.class, params);
			fail("Should have received 404 Not Found after deleting demo object");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	
	}

}
