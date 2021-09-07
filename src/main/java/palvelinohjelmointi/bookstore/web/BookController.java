package palvelinohjelmointi.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import palvelinohjelmointi.bookstore.domain.Book;

@Controller
public class BookController {
	
	@RequestMapping("/index")
	public String getBook(Model model)  {

		model.addAttribute("book", new Book());	
		
		return "index";
	}

}
