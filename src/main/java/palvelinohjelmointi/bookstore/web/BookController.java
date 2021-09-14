package palvelinohjelmointi.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.bookstore.domain.Book;
import palvelinohjelmointi.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
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
		return "addbook"; 
	 }
	 
	 @RequestMapping(value="/modify/{id}")
	 	public String modifyBook(Model model, @PathVariable("id") Long id) {
		model.addAttribute("book", repository.findById(id)); 
		return "addbook"; 
	 }
	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteStudent(@PathVariable("id") Long id) {

		repository.deleteById(id);
		return "redirect:/books"; 
	 }
	 
	 
	 
}
