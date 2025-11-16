package com.exam.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.exam.dto.BookReqDTO;
import com.exam.dto.BookResDTO;
import com.exam.dto.BookUpdateDTO;
import com.exam.entities.Book;
import com.exam.exception.ResourceNotFoundException;
import com.exam.repository.BookRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService {
	//service layer is depend upon repository
	private final BookRepository bookRepository;
	private final ModelMapper mapper;
	
	
	

	@Override
	public BookResDTO addBookDetails(BookReqDTO dto) {
		//mapped details to the Book clas
		Book book= mapper.map(dto, Book.class);
		//saving into the database
		BookResDTO map= mapper.map(bookRepository.save(book), BookResDTO.class);
		
		return map;
	}




	@Override
	public List<BookResDTO> fetchAllBookDetails() {
		List<Book>books= bookRepository.findAll();
		
		return books.stream()
				.map(book -> mapper.map(book, BookResDTO.class))
				.toList();
	}




	@Override
	public BookResDTO updateBookDetails(Long id, BookUpdateDTO dto) {
		Book book= bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid book id"));
		
		book.setTitle(dto.getTitle());
		book.setPrice(dto.getPrice());
		book.setPublishDate(dto.getPublishDate());
		book.setActive(dto.isActive());
		
		
		
		return mapper.map(book, BookResDTO.class);
	}




	@Override
	public String deleteBookById(Long cid) {
		bookRepository.deleteById(cid);
		return "Book deleted Successfuly!";
	}




	
	

}
