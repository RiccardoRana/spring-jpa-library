package com.library.demo.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "must not be null")
	private String lastName;
	@NotNull(message = "must not be null")
	private String firstName;
	@Past(message = "Birthday must e in the past!")
	private LocalDate birthday;
	@PastOrPresent(message = "Deathday must e in the past or in the present!")
	private LocalDate deathday;
	@NotNull
	private String nationality;

	@ManyToMany(mappedBy = "authors") //Scegli tu dove metterlo nelle relazioni ManyToMany!!!
	@JsonManagedReference
	@JsonIgnore	
	private List<Book> books;
	
   
}
