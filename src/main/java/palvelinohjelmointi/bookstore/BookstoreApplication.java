package palvelinohjelmointi.bookstore;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;
import palvelinohjelmointi.bookstore.domain.Gategory;
import palvelinohjelmointi.bookstore.domain.GategoryRepository;



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, GategoryRepository grepository) {
		return (args) -> {
			
			log.info("save a gategory");
			
	
			grepository.save(new Gategory("Holy Books"));
			grepository.save(new Gategory("History"));
			
			log.info("save two books");
			
			
			
			
			
			repository.save(new Book("Bible","many authors", 200,"131554ss", 2.0,
					grepository.findByName("Holy Books")));
			
			repository.save(new Book("Quran","many authors", 600,"131554ss", 2.0,
					grepository.findByName("Holy Books")));	
			
			repository.save(new Book("The history of christianity","D. MacCulloch", 2015,"1312554ss", 6.0,
					grepository.findByName("History")));	
			
		
			log.info("finding every book");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
