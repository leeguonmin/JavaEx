package lilili.masterbookup;

public class ManagerVo {
    private String title; // 책 제목
    private String authorName; // 작가 이름
    private String authorEmail; // 작가 이메일
    private String publisherName; // 출판사 이름
    private String publisherEmail; // 출판사 이메일
    private String pubDate; // 출판일
    private int typeId; // 장르 ID
    private int rate; // 별점
    private int locationsId; // 위치 ID
    private String publishernumber;

    // 기본 생성자
    public ManagerVo(int bookId, String title2, String authorName2, String typeName, String publisherName2, String pubDate2, int rate2, int stock, int locationsId2, String rentalDate, String returnExpect, String name, String nameId) {}

    // 생성자
    public ManagerVo(String title, String authorName, String authorEmail, String publisherName, String publisherEmail, String publishernumber, String pubDate, int typeId, int rate, int locationsId) {
        this.title = title;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.publisherName = publisherName;
        this.publisherEmail = publisherEmail;
        this.publishernumber = publishernumber;
        this.pubDate = pubDate;
        this.typeId = typeId;
        this.rate = rate;
        this.locationsId = locationsId;
    }

    
    
    
    
    
    
    public String getPublishernumber() {
		return publishernumber;
	}

	public void setPublishernumber(String publishernumber) {
		this.publishernumber = publishernumber;
	}

	// Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherEmail() {
        return publisherEmail;
    }

    public void setPublisherEmail(String publisherEmail) {
        this.publisherEmail = publisherEmail;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getLocationsId() {
        return locationsId;
    }

    public void setLocationsId(int locationsId) {
        this.locationsId = locationsId;
    }
	
	
	
	
	/*
    private int bookId;
    private String title;
    private String authorName;
    private String typeName;
    private String publisherName;
    private String pubDate;
    private String rentalDate;
    private String returnDate;
    private String name;
    private String nameId;
    private int rate;
    private int stock;
    private int locationsId;
    private int typeId;
    private int publisherId;
    private int authorId;
    
    private int customerId;
    private String customerName;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private String customerNameId;
    private String customerPassword;
    
    //
    private String authoremail;
    private String publisheremail;
    //
    
    
    public ManagerVo() {
    	
    }
    
    
    
    //






	public String getPublisheremail() {
		return publisheremail;
	}



	public String getAuthoremail() {
		return authoremail;
	}



	public void setAuthoremail(String authoremail) {
		this.authoremail = authoremail;
	}



	public void setPublisheremail(String publisheremail) {
		this.publisheremail = publisheremail;
	}



	public String getCustomerPassword() {
		return customerPassword;
	}
    
	

    


    
    //
    
    
    



	public ManagerVo(int bookId) {
		super();
		this.bookId = bookId;
    }

	



	public ManagerVo(int bookId, String title, String authorName, String typeName, String publisherName, String pubDate,
			int rate, int stock, int locationsId, String rentalDate, String returnDate, String name, String nameId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.authorName = authorName;
		this.typeName = typeName;
		this.publisherName = publisherName;
		this.pubDate = pubDate;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.name = name;
		this.nameId = nameId;
		this.rate = rate;
		this.stock = stock;
		this.locationsId = locationsId;
	}

	public ManagerVo(String title, int authorId, int typeId, String pubDate, int publisherId,
			int rate, int locationsId) {
		super();
		this.title = title;
		this.pubDate = pubDate;
		this.rate = rate;
		this.locationsId = locationsId;		
		this.typeId = typeId;
		this.publisherId = publisherId;
		this.authorId = authorId;
	}


	public ManagerVo(int customerId, String customerName, String email, String phoneNumber, String birthDate,
			String customerNameId, String CustomerPassword) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.customerNameId = customerNameId;
		this.customerPassword = CustomerPassword;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
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

	public int getLocationsId() {
		return locationsId;
	}

	public void setLocationsId(int locationsId) {
		this.locationsId = locationsId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}



	public String getAuthorName() {
		return authorName;
	}



	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}



	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public String getPublisherName() {
		return publisherName;
	}



	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}



	public String getRentalDate() {
		return rentalDate;
	}



	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}



	public String getReturnDate() {
		return returnDate;
	}



	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getNameId() {
		return nameId;
	}



	public void setNameId(String nameId) {
		this.nameId = nameId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCustomerNameId() {
		return customerNameId;
	}

	public void setCustomerNameId(String customerNameId) {
		this.customerNameId = customerNameId;
	}

	public String getCustomerpassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "ManagerVo [bookId=" + bookId + ", title=" + title + ", authorName=" + authorName + ", typeName="
				+ typeName + ", publisherName=" + publisherName + ", pubDate=" + pubDate + ", rentalDate=" + rentalDate
				+ ", returnDate=" + returnDate + ", name=" + name + ", nameId=" + nameId + ", rate=" + rate + ", stock="
				+ stock + ", locationsId=" + locationsId + ", typeId=" + typeId + ", publisherId=" + publisherId
				+ ", authorId=" + authorId + ", CustomerId=" + customerId + ", CustomerName=" + customerName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", birthDate=" + birthDate + ", CustomerNameId="
				+ customerNameId + ", Customerpassword=" + customerPassword + "]";
	}




	



	public String getPublisherEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
    */
}