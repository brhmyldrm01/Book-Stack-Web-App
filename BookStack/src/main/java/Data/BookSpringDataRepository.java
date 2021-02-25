package Data;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entities.Book;
import Entities.Person;
public interface BookSpringDataRepository extends JpaRepository<Book, Integer> {

	 
	 int isExists(int id);
	 
	 List <Book> findBypersonId(String personId);
	 
	 Book findById(int id);
	
}
