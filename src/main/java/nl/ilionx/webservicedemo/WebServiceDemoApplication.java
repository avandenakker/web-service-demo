package nl.ilionx.webservicedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import nl.ilionx.webservicedemo.web.DemoObjectController;

@SpringBootApplication
@EnableResourceServer
@EnableJpaRepositories
public class WebServiceDemoApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceDemoApplication.class);

	public static void main(String[] args) {
		LOGGER.debug("Start REST Web-Service application");
		SpringApplication.run(WebServiceDemoApplication.class, args);
	}
}
