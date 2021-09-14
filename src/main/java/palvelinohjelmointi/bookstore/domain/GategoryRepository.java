package palvelinohjelmointi.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GategoryRepository extends CrudRepository<Gategory, Long> {


	Gategory findByName(String name);
    
}
