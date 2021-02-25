package Data;

import org.springframework.data.jpa.repository.JpaRepository;

import Entities.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

	
	 Person findById(String id);	
	 int isExists(String id);
}
