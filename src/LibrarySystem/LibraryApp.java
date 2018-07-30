package LibrarySystem;

import LibrarySystem.exception.BookNotAvailabileException;
import LibrarySystem.exception.BookNotFoundException;
import LibrarySystem.exception.InvalidBookException;
import LibrarySystem.exception.NoMoreBookAllocationException;
import LibrarySystem.pojo.Book;
import LibrarySystem.pojo.User;
import LibrarySystem.service.LibraryService;

public class LibraryApp
{
	private LibraryService service;

	LibraryApp () {
		service = LibraryService.getInstance();
	}

	public boolean addBooksToLibrary (String title, String author) {
		return service.processBookToLibrary(title, author);
	}

	public boolean addUserToLibrary (String name) {
		return service.addUserToLibrary(name);
	}

	public boolean returnBookToLibrary(String title,User user)
	{
		try {
			return service.setBookToLibrary(title,user);
		} catch (BookNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Book getBookFromLibrary (String title,User user) {
		try {
			return service.fetchBookFromLibrary(title,user);
		} catch (BookNotFoundException | BookNotAvailabileException | NoMoreBookAllocationException e) {
			e.printStackTrace();
		}
		return null;
	}
}
