package com.library.demo.model;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@Table(name="")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "Title must not be null")
	private String title;
	@NotNull
	@Size(min = 13, max = 13,message = "isbn length must be 13")
	private String isbn;
	@Positive(message = "Prezzo must be positive!")
	private BigDecimal prezzo;
	@Positive(message = "availableCopies must not be negative!")
	private int availableCopies;
	@NotNull(message = "Pubblisher must not be null")
	private String pubblisher;
	@NotNull(message = "Genres must not be null")
	private String genres;

	@ManyToMany
	@JsonManagedReference(value="authorsList")
	private List<Author> authors;
	@OneToMany(mappedBy="book") //Nome del corrispondente attributo su borrowing!!! Sempre dove c'è la lista!!!
	@JsonBackReference(value = "borrowingList")
	private List<Borrowing> borrowings;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitolo() {
		return title;
	}
	public void setTitolo(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	public int getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	public String getPubblisher() {
		return pubblisher;
	}
	public void setPubblisher(String pubblisher) {
		this.pubblisher = pubblisher;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public List<Borrowing> getBorrowings() {
		return borrowings;
	}
	public void setBorrowings(List<Borrowing> borrowings) {
		this.borrowings = borrowings;
	}
    
	
	









}
