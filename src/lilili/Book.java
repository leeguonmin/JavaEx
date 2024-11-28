package lilili;

// import java.awt.print.Book;
import java.util.Date;
// import lilili.Book;

public class Book {
	private int id;
    private String title;
    private String author;
    private String publisher;
    private Date pub_date;
    private int rate;
    private int Locations_id;
    private int publisher_id;
    private int stock;
    
    

    
    
    
	public Book() {
		super();
	}






	public Book(int id, String title, String author, String publisher, int stock) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.stock = stock;
	}






	public Book(int id, String title, String author, String publisher, Date pub_date, int rate, int locations_id,
			int publisher_id, int stock) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.pub_date = pub_date;
		this.rate = rate;
		Locations_id = locations_id;
		this.publisher_id = publisher_id;
		this.stock = stock;
	}






	public int getId() {
		return id;
	}






	public void setId(int id) {
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






	public String getPublisher() {
		return publisher;
	}






	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}






	public Date getPub_date() {
		return pub_date;
	}






	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}






	public int getRate() {
		return rate;
	}






	public void setRate(int rate) {
		this.rate = rate;
	}






	public int getLocations_id() {
		return Locations_id;
	}






	public void setLocations_id(int locations_id) {
		Locations_id = locations_id;
	}






	public int getPublisher_id() {
		return publisher_id;
	}






	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}






	public int getStock() {
		return stock;
	}






	public void setStock(int stock) {
		this.stock = stock;
	}






	@Override
	public String toString() {
		return "BooksVo [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", pub_date=" + pub_date + ", rate=" + rate + ", Locations_id=" + Locations_id + ", publisher_id="
				+ publisher_id + ", stock=" + stock + "]";
	}
    
	
	
	
	
	
	
	
	
	
	
    
	

}
