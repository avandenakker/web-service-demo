package nl.ilionx.webservicedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import nl.ilionx.webservicedemo.model.DemoObject;
import nl.ilionx.webservicedemo.repository.DemoObjectRepository;

import java.util.Optional;

@Service
public class DemoObjectServiceImpl implements DemoObjectService {

	@Autowired
	private DemoObjectRepository companyRepository;

	@Override
	@PreAuthorize("hasAuthority('OBJECT_READ')")
	public Optional<DemoObject> get(Long id) {
		return companyRepository.findById(id);
	}

	@Override
	@PreAuthorize("hasAuthority('OBJECT_READ')")
	public DemoObject get(String name) {
		return companyRepository.findByName(name);
	}

	@Override
	@PreAuthorize("hasAuthority('OBJECT_READ')")
	public Page<DemoObject> findAll(Pageable pageable) {
		return companyRepository.findAll(pageable);
	}

	@Override
	@PreAuthorize("hasAuthority('OBJECT_CREATE')")
	public DemoObject create(DemoObject company) {
		companyRepository.save(company);
		return company;
	}

	@Override
	@PreAuthorize("hasAuthority('OBJECT_UPDATE')")
	public DemoObject update(DemoObject company) {
		return companyRepository.save(company);
	}

	@Override
	@PreAuthorize("hasAuthority('OBJECT_DELETE')")
	public void delete(Long id) {
		companyRepository.deleteById(id);
	}
}
