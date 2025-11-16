package com.exam.entities;

import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@AttributeOverride(name = "id", column = @Column(name="book_id"))

public class Book extends BaseEntitiy{

	@Column(name = "book_title", nullable = false, length = 30)
	private String title;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private LocalDate publishDate;
	@Enumerated(EnumType.STRING)
	private Category category;
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author authorId;
	
	
	
	
	
}
