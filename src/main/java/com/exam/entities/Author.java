package com.exam.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="authors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@AttributeOverride(name="id", column = @Column(name="Author_id"))
public class Author extends BaseEntitiy{
	
	@Column(name="author_name", nullable = false, length = 30)
	private String name;
	@Column(nullable = false, length = 30)
	private String email;
	private boolean active= true;
	
	

	
}
