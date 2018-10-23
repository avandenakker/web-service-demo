package nl.ilionx.webservicedemo.internal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_DEMO_OBJECT")
public class DemoObject {
	
	private String name;
	
	@Id
	@Column(name="id")
	private Long id;
	
	public DemoObject(String name, Long id, String description) {
		super();
		this.name = name;
		this.id = id;
		this.description = description;
	}

	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
