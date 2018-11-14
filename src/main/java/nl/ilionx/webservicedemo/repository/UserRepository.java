package nl.ilionx.webservicedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nl.ilionx.webservicedemo.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}