package Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Entities.Book;
import Entities.Person;
import Services.BookService;
import Services.PersonService;

@org.springframework.stereotype.Controller
@ComponentScan("Services")
public class Controller {
	
	

		@Autowired
		PersonService personService;
		@Autowired
		BookService bookService;
		Person person;
		List <Book > books;
		
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginPage() {
		return "loginPage";
	}
	
		@RequestMapping(value="/signUp",method=RequestMethod.GET)
		public String showSignUpPage() {
			return "SignUp";
		}



	
	
	@RequestMapping(value="/Info",method = RequestMethod.POST)
	public String showSignUpInfo(
			@RequestParam(name="userName", required=true) String userName,
			@RequestParam(name="surname", required=true) String surname,
			@PathVariable("id")	@RequestParam(name="id", required=true) String id,
			@RequestParam(name="password", required=true) String password,
			Model model) {	
		
		boolean result =personService.savePerson(id, userName, surname, password);
		
		if(result) {
			
		model.addAttribute("id", id);
		model.addAttribute("userName",userName);
		model.addAttribute("surname", surname);
		model.addAttribute("pattern","When you add a book it will shown here.");
		
		this.person=new Person(id,userName,surname,password);
		return "PersonP";
		}
		
		else {
			model.addAttribute("pattern", "A user with same id is already exist!!!");
			return this.showSignUpPage();
		}
		
		
		
	}
	
	@RequestMapping(value="/books",method = RequestMethod.POST)
	public String showPersonPage(
			@PathVariable ("id")
			@RequestParam(name="id", required=true) String id,
			@RequestParam(name="password", required=true) String password,
			Model model){	
		
		
		boolean b=	personService.validate(id, password);
		if(b){
		this.person =personService.getPerson(id);
		
		model.addAttribute("id", id);
		model.addAttribute("userName",person.getName());
		model.addAttribute("surname", person.getSurname());
		this.books=getBooks(id);
		model.addAttribute("books",books);	
		return "PersonP";
		}
		else{
			model.addAttribute("pattern", "Wrong ID or Password!!! ");
			return this.showLoginPage();
		}
	}
	
	
	@RequestMapping(value="/del",method = RequestMethod.GET)
	public String CrudBookDel(Model model) {	
		this.books=getBooks(person.getId());
		model.addAttribute("books", books);
		return "delP";
	}
	
	@RequestMapping(value="/updt",method = RequestMethod.GET)
	public String CrudBookUpdate(Model model) {
		this.books=getBooks(person.getId());
		model.addAttribute("books", books);
		return "updateP";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String CrudBookAdd(Model model) {
		this.books=getBooks(person.getId());
		model.addAttribute("books", books);
	return "addP";
	}
	
	

	@RequestMapping(value="/Rdel",method = RequestMethod.POST)
	public String Del(
			@RequestParam(name="id", required=true) int id,
			Model model) {	
		
		if(bookService.deleteBook(id)) {
			this.books=getBooks(person.getId());
			model.addAttribute("books", books);
			model.addAttribute("pattern", "Book deleted succesfully id:"+id);
			return "delP";
			}
		else {
			this.books=getBooks(person.getId());
			model.addAttribute("books", books);
			model.addAttribute("pattern", "No book found to delete by id:" + id);
			return "delP";
		}
	
		
	}
	
	@RequestMapping(value="/Rupdt",method = RequestMethod.POST)
	public String Update(
			Model model,
			@RequestParam(name="name", required=true) String name,
			@RequestParam(name="id", required=true) int id,
			@RequestParam(name="author", required=true) String author,
			@RequestParam(name="page", required=true) int page) {
		
		if(bookService.update(id, name, author, page)) {
			this.books=getBooks(person.getId());
			model.addAttribute("books", books);
			model.addAttribute("pattern", "Book with id "+id+" updated ");
			return "updateP";
		}
		else {
			this.books=getBooks(person.getId());
			model.addAttribute("books", books);
			model.addAttribute("pattern"," No book founded to update by id: "+ id );
			return "updateP";		
			}
		}
	
	@RequestMapping(value="/Radd",method = RequestMethod.POST)
	public String Add(
			Model model,
			@RequestParam(name="name", required=true) String name,
			@RequestParam(name="author", required=true) String author,
			@RequestParam(name="page", required=true) int page) {
		
		bookService.save(this.person.getId(), name, author, page);
		this.books=getBooks(person.getId());
		model.addAttribute("books", books);
		model.addAttribute("pattern","Book saved");
		return "addP";
	}
	
	
	
	public List<Book> getBooks(String id){
		List<Book> books=bookService.findBypersonId(id);
		return books;
	}

}
