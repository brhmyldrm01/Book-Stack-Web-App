package Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import Data.PersonSpringDataRepository;
import Entities.Person;

@Repository
public class PersonService {
	

	@Autowired
	PersonSpringDataRepository personSpringDataRepository;
	

	public boolean savePerson(String id,String name,String surname,String password) {
		Person person=new Person(id,name,surname,password);
		
		if(personSpringDataRepository.isExists(id)>0)
			return false;
		else {
			personSpringDataRepository.save(person);	
		}
		return true;
	}
	
	
	public Person getPerson(String id){
		Person dbPerson= personSpringDataRepository.findById(id);
			return dbPerson;
	}
	
	
	public boolean validate(String id , String pass) {
		if(personSpringDataRepository.isExists(id)==1) {
		Person person=this.getPerson(id);
		String personPass=person.getPassword();
			if(personPass.equals(pass)) {
				return true;	
				}
			else {return false;}
		}
		else { return false;}
		
	

	}
	
	
}


