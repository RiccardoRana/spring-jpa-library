package Exceptions;

import com.library.demo.model.Book;

public class NotEnougthCopiesException extends Exception {
	/**
	 * 
	 */
	
private static final long serialVersionUID = 1L;
	
	private Book book;

	public NotEnougthCopiesException(Book book) {
		super("Not enough copies. Book: "+book.getTitolo());
		this.book = book;
	}
	
	public Book getBook() {
		return book;
	}	
	
	
	

}
