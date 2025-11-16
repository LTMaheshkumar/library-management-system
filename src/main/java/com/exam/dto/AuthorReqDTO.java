package com.exam.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorReqDTO {
	@NotBlank(message = "Author name cannot be blank")
	private String name;
	@Email(message = "please enter valid email")
	private String email;
	@NotNull
	private boolean active;
	

}
