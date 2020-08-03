package com.springboot.libraryproject.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.libraryproject.entity.Books;
import com.springboot.libraryproject.entity.History;
import com.springboot.libraryproject.entity.User;
import com.springboot.libraryproject.exception.ResourceNotFoundException;
import com.springboot.libraryproject.repo.BooksRepo;
import com.springboot.libraryproject.repo.HistoryRepo;
import com.springboot.libraryproject.repo.UserRepo;

@RestController
public class LibraryRestController {
	
	@Autowired
	UserRepo urepo;
	
	@Autowired
	BooksRepo brepo;
	
	@Autowired
	HistoryRepo hrepo;
	
	//Register User:
	
	@PostMapping("registeruser")
	public Map<String,User> postUser(User user) 
	{
		urepo.save(user);
		Map<String, User> newuser = new HashMap<String, User>();
		newuser.put("The user has been registered Successfully.", user);
		return newuser;
	}

	//User Menu:
	
	//Books purchased by user:
	@GetMapping("user/bookspurchased/{userid}")
	public Map<String,List<History>> getBooksPurchased(@PathVariable("userid") int userid) {
		List<History> userbooklist = hrepo.findByUseridOrderByIssuedateDesc(userid);
		Map<String,List<History>> userbooklistmap= new HashMap<>();
		userbooklistmap.put("The list of books purchased  by the user :" +userid, userbooklist);
		return userbooklistmap;
	}

	//Purchase a book:
	
	@PostMapping("user/purchasebook")
	public Map<String,History> purchaseBook(History history)
	{
		hrepo.save(history);
		Map<String, History> bookpurchased = new HashMap<>();
		bookpurchased.put("The book has been purchased. Please find the book details", history);
		return bookpurchased;
		
	}
	
	//Return a book:
	
	@DeleteMapping("user/returnbook/{hid}")
	
	public String deleteHistory(@PathVariable("hid") int hid) {
		try {
		History deleteUser = hrepo.findById(hid).orElseThrow();
		hrepo.delete(deleteUser);
		return "Entry removed";
	}
	catch (Exception e){
		return "Entry Not Found";
	}
	}

	//ADMIN MENU:
	
	//non returned books:
	
	@GetMapping(value="admin/nonreturnedbooks", produces = {"application/JSON"})
	public Map<String,List<History>> getHistory() {
		List<History> history = hrepo.findHistory();
		Map<String,List<History>> historymap = new HashMap<String, List<History>>();
		historymap.put("The list of non returned book details", history);
		return historymap;
	}
	
	//Add user - post:
	@PostMapping("admin/adduser")
	public Map<String,User> addUser(User user) {
		urepo.save(user);
		Map<String,User> addusermap = new HashMap<String, User>();
		addusermap.put("New user has been added", user);
		return addusermap;
	}
	
	//Edit user - put:
	@PutMapping("admin/edituser")
	public Map<String,User> editUser(User user) {
		urepo.save(user);
		Map<String,User> editusermap = new HashMap<String, User>();
		return editusermap;
	}

	//Delete User:
	@DeleteMapping("deleteuser/{uid}")
	public Map<String, Boolean> deleteUser(@PathVariable("uid") int uid) {
		User deleteUser = urepo.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User Not found with id: " +uid));
		urepo.delete(deleteUser);

		Map<String, Boolean> response = new HashMap<>();
		response.put("The user has been deleted", Boolean.TRUE);
		return response;
	}
	
	
	//Other task of Admin:
	
	
	//Get the list of books 
	@GetMapping("admin/booklist")
	public Map<String,List<Books>> getUserBooks()
	{
		List<Books> booklist = brepo.findAll();
		Collections.sort(booklist);
		Map<String,List<Books>> booklistmap = new HashMap<>();
		booklistmap.put("The list of books", booklist);
		return booklistmap;
	}
	
	//Get the list of users:
	@GetMapping("admin/userlist")
	public List<User> getUsers() {
		List<User> user = urepo.findAll();
		return user;
	}
	
	//Add book:
	@PostMapping("admin/addbook")
	public Map<String,Books> addBook(Books book) {
		brepo.save(book);
		Map<String,Books> addbookmap = new HashMap<>();
		addbookmap.put("New book has been added", book);
		return addbookmap;
	}
	
	//Edit a book:
	@PutMapping("admin/editbook")
	public Map<String,Books> editBook(Books book) {
		brepo.save(book);
		Map<String,Books> editbookmap = new HashMap<>();
		editbookmap.put("The book has been edited successfully", book);
		return editbookmap;
	}
	
	//Delete a book:
	@DeleteMapping("deletebook/{bid}")
	public Map<String, Boolean> deleteBook(@PathVariable("bid") int bid) {
		Books deleteBook = brepo.findById(bid).orElseThrow(() -> new ResourceNotFoundException("Book Not found with id: " +bid));
		brepo.delete(deleteBook);

		Map<String, Boolean> response = new HashMap<>();
		response.put("The book has been deleted from list", Boolean.TRUE);
		return response;
	}
}
