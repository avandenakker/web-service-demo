package nl.ilionx.webservicedemo.internal;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface DemoObjectRepository extends PagingAndSortingRepository<DemoObject, Long> {

	public DemoObject findByName(String name);
	
	
}
