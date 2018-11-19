package nl.ilionx.webservicedemo.web;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.test.context.junit4.SpringRunner;

import nl.ilionx.webservicedemo.config.DemoConfig;
import nl.ilionx.webservicedemo.model.DemoObject;
import nl.ilionx.webservicedemo.repository.DemoObjectRepository;
import nl.ilionx.webservicedemo.repository.UserRepository;
import nl.ilionx.webservicedemo.service.DemoObjectServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoObjectControllerTest {
	
	@Autowired
	private DemoObjectController controller;
	

	@Test
	public void testDemoObjectsSummary() {
		Page<DemoObject> demoObjects = controller.demoObjectsSummary(PageRequest.of(0, 5));
		assertNotNull(demoObjects);
		assertEquals(demoObjects.getContent().get(0).getName(), ("Amsterdam"));
	}
	
	@Configuration
	@ComponentScan(basePackageClasses = { DemoObjectServiceImpl.class})
	static class Config {
		@Bean
		DemoObjectRepository demoObjectRepository() {
			return new StubDemoObjectRepository();
		}
		
		@Bean
		UserRepository userRepository() {
			return new StubUserRepository();
		}
		
	}

}
