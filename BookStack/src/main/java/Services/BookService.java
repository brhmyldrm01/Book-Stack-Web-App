package Services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Data.BookSpringDataRepository;
import Data.PersonSpringDataRepository;
import Entities.Book;

@Service
public class BookService {
	@Autowired
	BookSpringDataRepository bookSpringDataRepository;

	public List<Book> findBypersonId(String id){
		List<Book> books=bookSpringDataRepository.findBypersonId(id);
		return books;
	}
	
	public void save(String person_id,String name,String author,int page) {
		Book book =new Book(person_id,name,author,page);
		bookSpringDataRepository.save(book);
	}

	public boolean update(int id,String name,String author,int page) {
		if(bookSpringDataRepository.isExists(id)>0) {
			Book book=bookSpringDataRepository.findById(id);
			book.setName(name);
			book.setAuthor(author);
			book.setPage(page);
			bookSpringDataRepository.save(book);
			return true;
			
		}
		else {
			return false;
		}
	}
	
	
	public boolean deleteBook(int id) {
		if(bookSpringDataRepository.isExists(id)>0) {
			bookSpringDataRepository.deleteById(id);
			return true;
		}
		else
		return false;
			
	}
	
	
	
	
	
	
	
	
}
