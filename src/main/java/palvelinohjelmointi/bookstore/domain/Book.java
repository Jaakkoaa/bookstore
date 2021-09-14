package palvelinohjelmointi.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Book {
	
	private Gategory gategory;
	private Long id;
	private String title = "";
	private String author = "";
	private int year;
	private String isbn = "";
	private double price;
	
	
	


	
	
	public Book(String title, String author, int year, String isbn, double price, Gategory gategory) {
		
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.gategory = gategory;
	}
	
	public Book(String title, String author, int year, String isbn, double price) {
		
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Book() {
		
	}
	
	@ManyToOne
	public Gategory getGategory() {
		return gategory;
	}

	public void setGategory(Gategory gategory) {
		this.gategory = gategory;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id = "+ id + " title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
				+ ", gategory= "+ gategory +"]";
	}
	
	

	
	
}
