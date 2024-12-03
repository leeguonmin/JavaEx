package library.lilili.libra;

import java.util.Date;

public class RentalVo {
	private int rental_id;
	private int book_id;
	private int customer_id;
	private Date rental_date;
	private Date return_date;
	private Date realretuen_date;
	private String status;
	
	public RentalVo() {}

	


	public RentalVo(int rental_id, int book_id, int customer_id, Date rental_date, Date return_date,
			Date realretuen_date, String status) {
		super();
		this.rental_id = rental_id;
		this.book_id = book_id;
		this.customer_id = customer_id;
		this.rental_date = rental_date;
		this.return_date = return_date;
		this.realretuen_date = realretuen_date;
		this.status = status;
	}





	public RentalVo(int book_id) {
		super();
		this.book_id = book_id;
	}



	public RentalVo(int book_id, Date realretuen_date) {
		super();
		this.book_id = book_id;
		this.realretuen_date = realretuen_date;
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




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}



	
	

	@Override
	public String toString() {
		return "RentalVo [rental_id=" + rental_id + ", book_id=" + book_id + ", customer_id=" + customer_id
				+ ", rental_date=" + rental_date + ", return_date=" + return_date + ", realretuen_date="
				+ realretuen_date + ", status=" + status + "]";
	}




	public Date update(int bookId2, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public RentalVo get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	

}
