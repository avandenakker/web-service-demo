package nl.ilionx.webservicedemo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import nl.ilionx.webservicedemo.internal.DemoObject;
import nl.ilionx.webservicedemo.internal.DemoObjectRepository;


public class StubDemoObjectRepository implements DemoObjectRepository {

	private List<DemoObject> demoObjects = new ArrayList<DemoObject>();

	public StubDemoObjectRepository() {
		demoObjects.add(new DemoObject("Amsterdam", 1L, "This is a demo object"));
		demoObjects.add(new DemoObject("Eindhoven", 2L, "This is a demo object"));
		demoObjects.add(new DemoObject("Helmond", 3L, "This is a demo object"));
		demoObjects.add(new DemoObject("Den Bosch", 4L, "This is a demo object"));
		demoObjects.add(new DemoObject("Rosmalen", 5L, "This is a demo object"));
		demoObjects.add(new DemoObject("Amersfoort", 6L, "This is a demo object"));
		demoObjects.add(new DemoObject("Zwolle", 7L, "This is a demo object"));
		demoObjects.add(new DemoObject("Maastricht", 8L, "This is a demo object"));
		demoObjects.add(new DemoObject("Den Haag", 9L, "This is a demo object"));
		demoObjects.add(new DemoObject("Nuenen", 10L, "This is a demo object"));
	}

	@Override
	public Iterable<DemoObject> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<DemoObject> findAll(Pageable pageable) {
		return new PageImpl<DemoObject>(demoObjects, pageable, demoObjects.size());
	}

	@Override
	public <S extends DemoObject> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends DemoObject> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<DemoObject> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<DemoObject> findAll() {
		return demoObjects;
	}

	@Override
	public Iterable<DemoObject> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DemoObject entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends DemoObject> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DemoObject findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}