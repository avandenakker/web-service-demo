package nl.ilionx.webservicedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import nl.ilionx.webservicedemo.config.DemoConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(DemoConfig.class)
public class WebServiceDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
