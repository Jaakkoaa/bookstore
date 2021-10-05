package palvelinohjelmointi.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;
import palvelinohjelmointi.bookstore.domain.GategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private GategoryRepository grepository;
	
	
	  @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	
	
	 @RequestMapping(value= {"/", "/books"})
	    public String studentList(Model model) {	
	        model.addAttribute("books", repository.findAll());
	        return "booklist";
	    }

	 @RequestMapping(value="/save")
	 	public String saveBook(Book book) {
		System.out.println(book);
		repository.save(book); 
		return "redirect:/books"; 
	 }
	 

	 @RequestMapping(value="/add")
	 	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("gategories", grepository.findAll());
		return "addbook"; 
	 }
	 
	 @RequestMapping(value="/modify/{id}")
	 	public String modifyBook(Model model, @PathVariable("id") Long id) {
		model.addAttribute("book", repository.findById(id)); 
		model.addAttribute("gategories", grepository.findAll());
		return "addbook"; 
	 }
	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long id) {

		repository.deleteById(id);
		return "redirect:/books"; 
	 }
	 
	 
	 //api kamat
	 
	 @RequestMapping(value="/api/book/{id}", method = RequestMethod.GET)
	  public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {	
	    	return repository.findById(id);
	  }    
	 
	 @RequestMapping(value="/api/book", method = RequestMethod.GET)
	  public @ResponseBody Optional<Iterable<Book>> findAllBookRest() {	
	    	return Optional.ofNullable(repository.findAll());
	  }    
	 
	
}
