package nl.ilionx.webservicedemo.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nl.ilionx.webservicedemo.model.DemoObject;
import nl.ilionx.webservicedemo.repository.DemoObjectRepository;
import nl.ilionx.webservicedemo.service.DemoObjectService;
import nl.ilionx.webservicedemo.web.exception.DemoObjectNotFoundException;

@RestController
@RequestMapping("/objects")
public class DemoObjectController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoObjectController.class);
	
	@Autowired
	private DemoObjectService service;
	
	@GetMapping()
	public Page<DemoObject> demoObjectsSummary(Pageable pageable) {
		return (Page<DemoObject>) service.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DemoObject> demoObjectDetails(@PathVariable long id) {
		Optional<DemoObject> demoObject = service.get(id);
		if (!demoObject.isPresent()) {
			throw new DemoObjectNotFoundException("id = " + id);
		}
		return new ResponseEntity<DemoObject>(demoObject.get(), HttpStatus.OK);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public DemoObject createDemoObject(@RequestBody DemoObject demoObject) {
		return service.create(demoObject);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DemoObject> updateDemoObject(@RequestBody DemoObject demoObject, @PathVariable Long id) {
		LOGGER.debug("updateDemoObject");
		demoObject.setId(id);
		return new ResponseEntity<DemoObject>(service.update(demoObject), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDemoObject(@PathVariable long id) {
		service.delete(id);
	}
	
	
}
