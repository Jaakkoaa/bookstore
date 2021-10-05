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
import palvelinohjelmointi.bookstore.domain.User;
import palvelinohjelmointi.bookstore.domain.UserRepository;



@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, GategoryRepository grepository,
			UserRepository urepository) {
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
			
			urepository.save(new User("admin", "$2a$10$fMKk86JHMeM0n963Lsz4Jux4e.uj8HDeQvEYLfHczJsyWRAD8zzFO", "ADMIN", "admin.admin@admin.com"));
			urepository.save(new User("user", "$2a$10$FQOYjvd8h5N0j0eXl8pNJeCIVjfRQZ9sPY1T5pdbwvLXRg9JCuzAa", "USER", "user.user@user.com"));
			urepository.save(new User("jakko", "$2a$10$faNxzuacHR.x1XhyIZkiduKEYOR5E3TQUJz8XnWcXsD030cG2vjRW", "USER", "jakko.akku@mail.com"));
		};
	}
}
