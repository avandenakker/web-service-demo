package nl.ilionx.webservicedemo;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class LogbackApplicationTest {
	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testLoadedCustomLogbackConfig() throws Exception {
		WebServiceDemoApplication.main(new String[0]);
		this.outputCapture.expect(containsString("Start REST Web-Service application"));
	}
}
