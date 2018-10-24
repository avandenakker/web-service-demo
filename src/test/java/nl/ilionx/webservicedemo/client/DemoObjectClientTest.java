package nl.ilionx.webservicedemo.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import nl.ilionx.webservicedemo.internal.DemoObject;
import nl.ilionx.webservicedemo.util.RestPageImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoObjectClientTest {
	
	private static final String BASE_URL_FOR_OBJECTS = "http://localhost:8080/objects";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void listDemoObjectsFirstPageIsRetrieved() {
		RestPageImpl page = restTemplate.getForObject(BASE_URL_FOR_OBJECTS + "?page=0&size=1", RestPageImpl.class);
		assertNotNull(page);
	    assertEquals("Amsterdam", page.getContent().get(0).getName());
		assertEquals(1, page.getSize());
	}
		
	@Test
	public void listDemoObjectsSecondPageIsRetrieved() {
		RestPageImpl page = restTemplate.getForObject(BASE_URL_FOR_OBJECTS + "?page=1&size=1", RestPageImpl.class);
		assertNotNull(page);
		assertEquals("Eindhoven", page.getContent().get(0).getName());
		assertEquals(1, page.getSize());
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
