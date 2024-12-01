package lilili.copy;

import java.util.Date;

public class Rental {
	 private int rental_id;
	 private int book_id;
	 private int customer_id;
	 private Date rental_date;
	 private Date return_date;
	 private Date realretuen_date;
	 
	 
	 
	 
	public Rental(int rental_id, int book_id, int customer_id, Date rental_date, Date return_date,
			Date realretuen_date) {
		super();
		this.rental_id = rental_id;
		this.book_id = book_id;
		this.customer_id = customer_id;
		this.rental_date = rental_date;
		this.return_date = return_date;
		this.realretuen_date = realretuen_date;
	}




	public Rental(int int1, String string, String string2, String string3, int int2) {
		// TODO Auto-generated constructor stub
	}




	public int getRental_id() {
		return rental_id;
	}




	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}




	public int getBook_id() {
		return book_id;
	}




	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}




	public int getCustomer_id() {
		return customer_id;
	}




	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}




	public Date getRental_date() {
		return rental_date;
	}




	public void setRental_date(Date rental_date) {
		this.rental_date = rental_date;
	}




	public Date getReturn_date() {
		return return_date;
	}




	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}




	public Date getRealretuen_date() {
		return realretuen_date;
	}




	public void setRealretuen_date(Date realretuen_date) {
		this.realretuen_date = realretuen_date;
	}




	@Override
	public String toString() {
		return "RentalVo [rental_id=" + rental_id + ", book_id=" + book_id + ", customer_id=" + customer_id
				+ ", rental_date=" + rental_date + ", return_date=" + return_date + ", realretuen_date="
				+ realretuen_date + "]";
	}
	 
	 
	 
	  
	
}
