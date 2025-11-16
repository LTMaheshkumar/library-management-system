package com.exam.service;

import java.util.List;

import com.exam.dto.AuthorReqDTO;
import com.exam.dto.AuthorResDTO;
import com.exam.entities.Author;

public interface AuthorService {

	AuthorResDTO addAuthorDetails(AuthorReqDTO dto);

	List<AuthorResDTO> getAllAuthors();

	String deleteAuthorById(Long cid);

	AuthorResDTO updateAuthor(Long id, AuthorReqDTO dto);

	

}
