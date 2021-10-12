package palvelinohjelmointi.bookstore;





import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	BookRepository repository;
	
	@Test
	public void createBook() {
	repository.save(new Book("old testament", "many authors",-1000, 
			"123asdas", 8.00 ));
	assertThat(repository.findByTitle("old testament").getAuthor()).isEqualTo("many authors");
	}
	
	@Test
    public void deleteBook() {
    	Book book = new Book("Bible","many authors", 200,"131554ss", 2.0);
    	repository.delete(book);
    	assertThat(repository.findByTitle("Bible")).isNull();;
    }    
	
	
}
