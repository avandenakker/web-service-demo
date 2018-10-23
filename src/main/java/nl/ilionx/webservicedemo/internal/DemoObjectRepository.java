package nl.ilionx.webservicedemo.internal;

import org.springframework.data.repository.Repository;

public interface DemoObjectRepository extends Repository<DemoObject, Long> {

	public DemoObject findByName(String name);
}
