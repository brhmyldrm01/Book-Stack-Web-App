package Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Book.isExists",
query = "select count(u) from Book u where u.id= ?1")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "personId")
	private String personId;
	private String name;
	private String author;
	private Date due_date;
	private int page;

	
	public Book() {
	}



	public Book(int id,String personid, String name, String author, Date date, int page) {
		super();
		this.personId = personid;
		this.id = id;
		this.name = name;
		this.author = author;
		this.due_date = date;
		this.page = page;
	}

	public Book(String personid,String name, String author, int page) {
		super();
		Date date=new Date();
		this.personId=personid;
		this.name = name;
		this.author = author;
		this.page = page;
		this.due_date=date;
	}



	public Book(String personid,String name, String author, Date date, int page) {
		super();
		this.personId=personid;
		this.name = name;
		this.author = author;
		this.due_date = date;
		this.page = page;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPerson_Id(String person_id) {
		this.personId = person_id;
	}

	public String getPerson_Id() {
		return personId;
	}






	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public Date getDue_Date() {
		return due_date;
	}



	public void setDue_Date(Date date) {
		this.due_date = date;
	}



	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}
	
	
	
	@Override
	public String toString() {
		return "\nBook [id=" + id + ", person_id=" + personId + ", name=" + name+", author=" + author+", due_date=" + due_date+", page=" + page+"]";
	}
	
	
	
	
	
	
	
	
	
}
