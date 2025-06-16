package fr.library_management.test;

import fr.library_management.entity.Book;
import fr.library_management.entity.BookDao;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Book little_prince = new Book("The Little Prince", "Antoine de Saint-Exupéry", 
				"Dreamers", "adventure", 154, "english", "Story like no other.", null, "epub", 19.99, 0);
		
		Book big_prince = new Book("The Big Prince", "Mary de Saint-Exupéry", 
				"Thinkers", "action", 254, "english", "Story like every other.", null, "epub", 21.99, 0);
		
		
		BookDao bd = new BookDao();
		
		bd.addBook(little_prince);
		
		bd.removeBook(big_prince);
		
		//System.out.println(little_prince.getId_book());
		
		//bd.updateImageBook(82, "Little_Prince.jpg");
		
		//bd.removeBook(little_prince);
		
//		System.out.println(bd.countAllBooks());
//		bd.showAllBooks();
//		System.out.println(bd.inTheLibrary(little_prince));
		
	}

}
