package nl.ilionx.webservicedemo.web;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import nl.ilionx.webservicedemo.config.DemoConfig;
import nl.ilionx.webservicedemo.internal.DemoObject;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(DemoConfig.class)
public class DemoObjectControllerTest {
	
	private DemoObjectController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new DemoObjectController(new StubDemoObjectRepository());
	}

	@Test
	public void testDemoObjectsSummary() {
		List<DemoObject> demoObjects = controller.demoObjectsSummary();
		assertNotNull(demoObjects);
	}

}
