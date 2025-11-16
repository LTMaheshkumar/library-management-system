package com.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.BookReqDTO;
import com.exam.dto.BookResDTO;
import com.exam.dto.BookUpdateDTO;
import com.exam.service.BookService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
	
	//controller is depend on Service layer
	private final BookService bookService;
	
	//method to add the Book details
	
	@PostMapping("/addBook") //for adding new deatail post method used
	public ResponseEntity<?> addBookDetails(@Valid @RequestBody BookReqDTO dto){
		BookResDTO newBook =bookService.addBookDetails(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
		
	}
	
	//fetch all books
	@GetMapping("/showAll")
	public ResponseEntity<?>getAllBoook(){
		List<BookResDTO>list=bookService.fetchAllBookDetails();
		return ResponseEntity.ok(list);
	}
	
	//update book details by id
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateBook(@PathVariable Long id, @Valid @RequestBody BookUpdateDTO dto){
		BookResDTO update=bookService.updateBookDetails(id, dto);
		return ResponseEntity.ok(update);
		
	}
	
	//delete Book by ID
	@GetMapping("/{cid}/delete")
	public ResponseEntity<?> deleteBook(Long cid){
		return ResponseEntity.ok(bookService.deleteBookById(cid));
		
	}
}
