package com.exam.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.exam.dto.AuthorReqDTO;
import com.exam.dto.AuthorResDTO;
import com.exam.entities.Author;
import com.exam.exception.ResourceNotFoundException;
import com.exam.repository.AuthorRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
	private final AuthorRepository authorRepository;
	private final ModelMapper mapper;
	

	@Override
	public AuthorResDTO addAuthorDetails(AuthorReqDTO dto) {
		
		//Map DTO entities with class
		Author author= mapper.map(dto, Author.class);
		//save entities into the Database
		AuthorResDTO map=mapper.map(authorRepository.save(author),AuthorResDTO.class );
		map.setMessage("Author Added Successfully");
		return map;
	}


	@Override
	public List<AuthorResDTO> getAllAuthors() {
		List<Author> authors= authorRepository.findAll();
		
		return authors.stream() //stream ke jariye Author ki pipe line banyi
				.map(author -> mapper.map(author, AuthorResDTO.class)) //map se ek ek object map kiya autgor ka AuthResp entitiy se
				.toList(); //last me list me convert kiya
	}


	@Override
	public String deleteAuthorById(Long cid) {
		authorRepository.deleteById(cid);
		return "Author Deleted SuccessFully!";
	}


	@Override
	public AuthorResDTO updateAuthor(Long id, AuthorReqDTO dto) {
		//Firstly Get author by id
		Author author=authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Author ID: "+id));
		//then update using getters and setter of DTO
		author.setName(dto.getName());
		author.setEmail(dto.getEmail());
		author.setActive(dto.isActive());
		
		//now save details in Repository
		
		Author saved= authorRepository.save(author);
		
		//convert to Response DTO
		return mapper.map(saved, AuthorResDTO.class);
	}


	

}
