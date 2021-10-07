package palvelinohjelmointi.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import palvelinohjelmointi.bookstore.domain.User;
import palvelinohjelmointi.bookstore.domain.UserRepository;

public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void createNewUser() {
		
		repository.save(new User("jakko", "$2a$10$faNxzuacHR.x1XhyIZkiduKEYOR5E3TQUJz8XnWcXsD030cG2vjRW", "USER", "jakko.akku@mail.com"));
	}
	
}
