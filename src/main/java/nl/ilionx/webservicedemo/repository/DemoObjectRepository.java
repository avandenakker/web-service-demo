package nl.ilionx.webservicedemo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import nl.ilionx.webservicedemo.model.DemoObject;

public interface DemoObjectRepository extends PagingAndSortingRepository<DemoObject, Long> {

	public DemoObject findByName(String name);
}
