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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.AuthorReqDTO;
import com.exam.dto.AuthorResDTO;
import com.exam.entities.Author;
import com.exam.service.AuthorService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
@RestController
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorController {
	//Controller is depend upon Service layer
	
	private final AuthorService authorService;
	
	
	//methods fir add new authors
	
	@PostMapping("/addAuthor")
	public ResponseEntity<?> addAuthor(@Valid @RequestBody AuthorReqDTO dto){
		
		AuthorResDTO newAuthor=authorService.addAuthorDetails(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(newAuthor);
		
	}
	
	//Get All Authors Details
	@GetMapping("/getAll")
	public ResponseEntity<?>getAllAuthors(){
		List<AuthorResDTO> list=authorService.getAllAuthors();
		return ResponseEntity.ok(list);
		
	}
	
	//delete AuthorBy ID
	@GetMapping("/{cid}/delete")
	public ResponseEntity<?> deleteAuthor(Long cid){
		return ResponseEntity.ok(authorService.deleteAuthorById(cid));
		
	}
	
	//update author details by id
	
	@PutMapping("/{id}/update")
	public ResponseEntity<?> updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorReqDTO dto){
		AuthorResDTO update=authorService.updateAuthor(id, dto);
		
		return ResponseEntity.ok(update); //200 Success
		
	}
	
	

}
