package com.exam.service;

import java.util.List;

import com.exam.dto.BookReqDTO;
import com.exam.dto.BookResDTO;
import com.exam.dto.BookUpdateDTO;

public interface BookService {

	BookResDTO addBookDetails(BookReqDTO dto);

	List<BookResDTO> fetchAllBookDetails();

	BookResDTO updateBookDetails(Long id, BookUpdateDTO dto);

	String deleteBookById(Long cid);

}
