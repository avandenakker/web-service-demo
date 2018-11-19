package nl.ilionx.webservicedemo.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import nl.ilionx.webservicedemo.model.DemoObject;

public interface DemoObjectService {

	Optional<DemoObject> get(Long id);

	DemoObject get(String name);

    DemoObject create(DemoObject company);

    DemoObject update(DemoObject company);

    void delete(Long id);
    
    Page<DemoObject> findAll(Pageable pageable);

  
}
