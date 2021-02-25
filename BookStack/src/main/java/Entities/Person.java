package Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQuery(name = "Person.isExists",
query = "select count(u) from Person u where u.id= ?1")
public class Person {
	
	@Id
	private String id;
	private String name;
	private String surname;
	 private String password;
	
	

	public Person() {
	}

	public Person(String id, String name,String surname,String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname=surname;
		this.password=password;
	}
	
	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name +", surname="+surname + "]";
	}
	
	
	
	
	
}
