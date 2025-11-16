package com.exam.dto;

import java.time.LocalDate;

import com.exam.entities.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResDTO {
	private Long id;
	private String title;
	private double price;
	private LocalDate publishDate;
	private Category category;
	private boolean active;
	private String message;

}
