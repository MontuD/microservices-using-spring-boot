package com.example.libraryadmin.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryadmin.dto.BookDTO;
import com.example.libraryadmin.dto.UserDTO;
import com.example.libraryadmin.services.LibraryAdminService;

@RestController
@RequestMapping("/api/admin/")
public class LibraryAdminController {
	
	private LibraryAdminService adminService;
	
	public LibraryAdminController( LibraryAdminService adminService){
		this.adminService = adminService;
	}
	
	@PostMapping("/adduser")
	@ResponseBody
	public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(adminService.createUser(userDTO).get());
	}

	@PostMapping("/book/add")
	@ResponseBody
	public ResponseEntity addBook(@RequestBody BookDTO book) {
		return ResponseEntity.ok(this.adminService.addBookToLibrary(book));
	}
	
	@PostMapping("/books/add")
	@ResponseBody
	public ResponseEntity addBook(@RequestBody List<BookDTO> book) {
		return ResponseEntity.ok(this.adminService.addBooksToDatabase(book));
	}
	
	@GetMapping("/books/getall")
	@ResponseBody
	public ResponseEntity getAllBooks() {
		System.out.println("GETALLBOOKS");
		return ResponseEntity.ok(this.adminService.getAllBooks());
	}
	
	
	@GetMapping("/books/get/name")
	@ResponseBody
	public ResponseEntity getBooksByBookName(@PathVariable String bookname
			) {
		System.out.println("GETALLBOOKS");
		return ResponseEntity.ok(this.adminService.getBooksByBookName(bookname));
	}
	
	@GetMapping("/books/get/author={author}")
	@ResponseBody
	public ResponseEntity getBooksByAuthor(@PathVariable String author
			) {
		System.out.println("GETALLBOOKS");
		return ResponseEntity.ok(this.adminService.getBooksByAuthor(author));
	}
	
	
}