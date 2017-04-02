package isi.project.banking.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="FACILITY")
public class Facility {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String address;
	@Column(name="nr_tel")
	private String nrTel;
	
	@OneToMany(mappedBy="facilityId")
	private Set<Person> people;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNrTel() {
		return nrTel;
	}
	public void setNrTel(String nrTel) {
		this.nrTel = nrTel;
	}
	public Set<Person> getPeople() {
		return people;
	}
	public void setPeople(Set<Person> people) {
		this.people = people;
	}
}
