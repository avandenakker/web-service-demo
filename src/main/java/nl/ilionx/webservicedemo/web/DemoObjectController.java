package nl.ilionx.webservicedemo.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nl.ilionx.webservicedemo.internal.DemoObject;
import nl.ilionx.webservicedemo.internal.DemoObjectRepository;

@RestController
@RequestMapping("/objects")
public class DemoObjectController {
	
	public DemoObjectController(DemoObjectRepository repository) {
		this.repository = repository;
	}

	@Autowired
	private DemoObjectRepository repository;
	
	@GetMapping()
	public Page<DemoObject> demoObjectsSummary(Pageable pageable) {
		return (Page<DemoObject>) repository.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DemoObject> demoObjectDetails(@PathVariable long id) {
		Optional<DemoObject> demoObject = repository.findById(id);
		if (demoObject.isPresent()) {
			return new ResponseEntity<DemoObject>(demoObject.get(), HttpStatus.OK);
		}
		return new ResponseEntity<DemoObject>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public DemoObject createDemoObject(@RequestBody DemoObject demoObject) {
		return repository.save(demoObject);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DemoObject> updateDemoObject(@RequestBody DemoObject demoObject) {
		return new ResponseEntity<DemoObject>(repository.save(demoObject), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDemoObject(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
}
