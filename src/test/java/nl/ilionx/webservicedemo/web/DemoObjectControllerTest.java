package nl.ilionx.webservicedemo.web;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import nl.ilionx.webservicedemo.config.DemoConfig;
import nl.ilionx.webservicedemo.model.DemoObject;


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
		Page<DemoObject> demoObjects = controller.demoObjectsSummary(PageRequest.of(0, 5));
		assertNotNull(demoObjects);
		assertEquals(demoObjects.getContent().get(0).getName(), ("Amsterdam"));
	}

}
