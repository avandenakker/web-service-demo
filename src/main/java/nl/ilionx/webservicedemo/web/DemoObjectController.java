package nl.ilionx.webservicedemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.ilionx.webservicedemo.internal.DemoObject;
import nl.ilionx.webservicedemo.internal.DemoObjectRepository;


@RestController
public class DemoObjectController {
	
	public DemoObjectController(DemoObjectRepository repository) {
		this.repository = repository;
	}

	@Autowired
	private DemoObjectRepository repository;
	
	@GetMapping("/objects")
	public Page<DemoObject> demoObjectsSummary(Pageable pageable) {
		return (Page<DemoObject>) repository.findAll(pageable);
	}
}
