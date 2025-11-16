package com.exam.dto;

import java.time.LocalDate;

import com.exam.entities.Author;
import com.exam.entities.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookReqDTO {
	@NotBlank(message = "Book title must be filled")
	private String title;
	@Positive(message = "Please mention book price")
	private double price;
	@NotNull(message = "please enter publish date")
	private LocalDate publishDate;
	private Category category;
	private boolean active;
	private Long authorId;
	

}
