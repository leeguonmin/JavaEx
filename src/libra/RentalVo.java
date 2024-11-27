package libra;

import java.util.Date;

public class RentalVo {
	private int rentalId;
	private int bookId;
	private int customerId;
	private Date rentalDate;
	private Date returnDate;
	private Date realreturnDate;
	private String status;
	
	public RentalVo() {}

	public RentalVo(int rentalId, int bookId, int customerId, Date rentalDate, Date returnDate, Date realreturnDate,
			String status) {
		super();
		this.rentalId = rentalId;
		this.bookId = bookId;
		this.customerId = customerId;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.realreturnDate = realreturnDate;
		this.status = status;
	}
	
//	public RentalVo(int bookId, Date rentalDate, Date returnDate, Date realreturnDate, String status) {
//		
//	}
	
	public RentalVo(int bookId, Date rentalDate, Date returnDate, Date realreturnDate, String status) {
		super();
		this.bookId = bookId;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.realreturnDate = realreturnDate;
		this.status = status;
	}
	


	public RentalVo(int bookId, Date realreturnDate) {
		super();
		this.bookId = bookId;
		this.realreturnDate = realreturnDate;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getRealreturnDate() {
		return realreturnDate;
	}

	public void setRealreturnDate(Date realreturnDate) {
		this.realreturnDate = realreturnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RentalVo [rentalId=" + rentalId + ", bookId=" + bookId + ", customerId=" + customerId + ", rentalDate="
				+ rentalDate + ", returnDate=" + returnDate + ", realreturnDate=" + realreturnDate + ", status="
				+ status + "]";
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
