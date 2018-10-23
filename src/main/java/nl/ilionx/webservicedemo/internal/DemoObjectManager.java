package nl.ilionx.webservicedemo.internal;

import java.util.List;

/**
 * Manages access to demo object information.
 */
public interface DemoObjectManager {

	public String getInfo();

	public List<DemoObject> getAllDemoObjects();
	public DemoObject getDemoObject(Long id);

	public DemoObject save(DemoObject demoObject);

	public void update(DemoObject demoObject);

}
