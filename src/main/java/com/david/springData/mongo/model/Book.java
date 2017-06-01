package com.david.springData.mongo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;


public class Book implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6597617299089538760L;

	@Id
	private String bookId;
	

	private String title;

	private Date publishDate;
	

	private int pageCount;

	private BigDecimal price;


	public Book() {
		super();
	}

	public Book(String title, Date publishDate, int pageCount, BigDecimal price) {
		super();
		this.title = title;
		this.publishDate = publishDate;
		this.pageCount = pageCount;
		this.price = price;
	}


	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", publishDate=" + publishDate + ", pageCount="
				+ pageCount + ", price=" + price + "]";
	}

	

	
	
}
