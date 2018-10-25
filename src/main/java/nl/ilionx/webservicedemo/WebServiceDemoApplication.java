package nl.ilionx.webservicedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import nl.ilionx.webservicedemo.web.DemoObjectController;

@SpringBootApplication
public class WebServiceDemoApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceDemoApplication.class);

	public static void main(String[] args) {
		LOGGER.debug("Start REST Web-Service application");
		SpringApplication.run(WebServiceDemoApplication.class, args);
	}
}
