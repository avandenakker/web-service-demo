package nl.ilionx.webservicedemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages="nl.ilionx.webservicedemo.internal")
@EnableTransactionManagement
public class DemoConfig {
	
	DataSource dataSource;

	@Autowired
	public DemoConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
