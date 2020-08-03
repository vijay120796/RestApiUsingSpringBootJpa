package com.springboot.libraryproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Books implements Comparable<Books> {
	@Id
	private Integer bookid;
	private String bookname;
	private Integer price;
	private String genre;
	
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", bookname=" + bookname + ", price=" + price + ", genre=" + genre + "]";
	}

	@Override
	public int compareTo(Books o) {
		return this.price>o.price?-1:this.price<o.price?1:0;
	}

}

