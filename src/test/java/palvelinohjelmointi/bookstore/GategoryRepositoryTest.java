package palvelinohjelmointi.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


import palvelinohjelmointi.bookstore.domain.Gategory;
import palvelinohjelmointi.bookstore.domain.GategoryRepository;

public class GategoryRepositoryTest {
	
	GategoryRepository repository;
	
	@Test
	public void createGategory() {
	repository.save(new Gategory("fantasy"));
	assertThat(repository.findByName("fantasy")).isNotNull();
	}
	
	@Test
    public void deleteGategory() {
    	Gategory g = new Gategory("History");
    	repository.delete(g);
    	assertThat(repository.findByName("History")).isNull();
    }    

	
}
