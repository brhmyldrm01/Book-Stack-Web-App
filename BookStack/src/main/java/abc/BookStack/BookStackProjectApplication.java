package abc.BookStack;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import Data.*;
import Entities.Book;
import Entities.Person;


@ComponentScan("Controller")
@EnableJpaRepositories("Data")
@EnableAutoConfiguration
@SpringBootApplication
@EntityScan("Entities")
public class BookStackProjectApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(BookStackProjectApplication.class, args);
	}


}
