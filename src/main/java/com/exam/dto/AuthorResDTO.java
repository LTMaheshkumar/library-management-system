package com.exam.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorResDTO {
	
	private Long id;
	private String name;
	private String email;
	private boolean active;
	private String message;
	

}
