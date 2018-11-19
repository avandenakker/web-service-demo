package nl.ilionx.webservicedemo.security;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;

import nl.ilionx.webservicedemo.model.DemoObject;
import nl.ilionx.webservicedemo.repository.DemoObjectRepository;
import nl.ilionx.webservicedemo.repository.UserRepository;
import nl.ilionx.webservicedemo.service.DemoObjectService;
import nl.ilionx.webservicedemo.service.DemoObjectServiceImpl;
import nl.ilionx.webservicedemo.web.StubDemoObjectRepository;
import nl.ilionx.webservicedemo.web.StubUserRepository;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration
@TestExecutionListeners(listeners={ServletTestExecutionListener.class,
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		WithSecurityContextTestExecutionListener.class})
public class DemoObjectSecurityTests {
	 
	 @Autowired
	 private DemoObjectService demoObjectService;

	@Test
	@WithMockUser(value = "annavdakker", authorities = "OBJECT_READ")
	public void getMessageUnauthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Page<DemoObject> page = demoObjectService.findAll(PageRequest.of(0, 5));
		assertEquals("Amsterdam", page.getContent().get(0).getName());
	}
	
	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled = true)
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
