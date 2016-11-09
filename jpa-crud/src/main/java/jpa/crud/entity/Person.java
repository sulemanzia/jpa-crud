package jpa.crud.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author szia
 *
 */

@Entity
@Table(name="person")
public class Person {

	@Id
	@Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="person_name")
	private String name;

	@OneToMany(cascade=CascadeType.ALL,mappedBy="person")
	private Set<Address> addresses = new HashSet<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}

