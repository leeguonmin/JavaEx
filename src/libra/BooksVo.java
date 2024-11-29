package libra;

import java.util.Date;

public class BooksVo {

	private int id;
	private String title;
	private String author;
	private String publisher;
	private Date pubdate;
	private int rate;
	private int stock;
	private int Locations_id;
	private int type_id;
	private int publisher_id;
	private int author_id;
	
	
	private String author_name;

	public BooksVo() {} 

	
	
	
	public String getAuthor_name() {
		return author_name;
	}




	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}


	


	public BooksVo(int id, String title, String publisher, String author_name) {
		super();
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.author_name = author_name;
	}




	public BooksVo(int id, String title, String author, String publisher, Date pubdate, int rate, int stock,
			int locations_id, int type_id, int publisher_id, int author_id) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.pubdate = pubdate;
		this.rate = rate;
		this.stock = stock;
		Locations_id = locations_id;
		this.type_id = type_id;
		this.publisher_id = publisher_id;
		this.author_id = author_id;
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

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getLocations_id() {
		return Locations_id;
	}

	public void setLocations_id(int locations_id) {
		Locations_id = locations_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}




	@Override
	public String toString() {
		return "BooksVo [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", pubdate=" + pubdate + ", rate=" + rate + ", stock=" + stock + ", Locations_id=" + Locations_id
				+ ", type_id=" + type_id + ", publisher_id=" + publisher_id + ", author_id=" + author_id
				+ ", author_name=" + author_name + "]";
	}

	
	
	
	
	
	
	
	
}
