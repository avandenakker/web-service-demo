package nl.ilionx.webservicedemo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<DemoObject> demoObjectsSummary() {
		return (List<DemoObject>) repository.findAll();
	}
}
