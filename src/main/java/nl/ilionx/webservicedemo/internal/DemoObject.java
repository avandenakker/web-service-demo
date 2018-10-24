package nl.ilionx.webservicedemo.internal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_DEMO_OBJECT")
public class DemoObject {
	
	private String name;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	protected DemoObject() {
	}
	
	public DemoObject(Long id, String name, String description) {
		super();
		this.name = name;
		this.id = id;
		this.description = description;
	}
	
	public DemoObject(String name, String description) {
		super();
		this.name = name;
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
