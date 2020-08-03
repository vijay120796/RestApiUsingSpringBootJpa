package com.springboot.libraryproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class History {
	@Id
	private Integer historyid;
	private Integer userid;
	private Integer bookid;
	private String issuedate;
	private String returndate;
	private String isreturned;
	private Integer fine;
	
	
	
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	public History(Integer historyid, Integer userid, Integer bookid, String issuedate, String returndate,
			String isreturned, Integer fine) {
		super();
		this.historyid = historyid;
		this.userid = userid;
		this.bookid = bookid;
		this.issuedate = issuedate;
		this.returndate = returndate;
		this.isreturned = isreturned;
		this.fine = fine;
	}
	public Integer getHistoryid() {
		return historyid;
	}
	public void setHistoryid(Integer historyid) {
		this.historyid = historyid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public String getIsreturned() {
		return isreturned;
	}
	public void setIsreturned(String isreturned) {
		this.isreturned = isreturned;
	}
	public Integer getFine() {
		return fine;
	}
	public void setFine(Integer fine) {
		this.fine = fine;
	}
	@Override
	public String toString() {
		return "History [historyid=" + historyid + ", userid=" + userid + ", bookid=" + bookid + ", issuedate="
				+ issuedate + ", returndate=" + returndate + ", isreturned=" + isreturned + ", fine=" + fine + "]";
	}
}
