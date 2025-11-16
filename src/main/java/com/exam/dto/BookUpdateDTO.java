package com.exam.dto;

import java.time.LocalDate;

import com.exam.entities.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class BookUpdateDTO {

	@NotBlank(message = "book title cant be blank")
	private String title;
	@Positive(message = "price must be greater than zero")
	private double price;
	@NotNull(message = "publish date cant be null")
	private LocalDate publishDate;
	private Category category;
	private boolean active;
	private String message;
}
