package LibrarySystem.service;

import LibrarySystem.common.Constants;
import LibrarySystem.dao.LibraryDao;
import LibrarySystem.exception.BookNotAvailabileException;
import LibrarySystem.exception.BookNotFoundException;
import LibrarySystem.exception.InvalidBookException;
import LibrarySystem.exception.NoMoreBookAllocationException;
import LibrarySystem.pojo.Book;
import LibrarySystem.pojo.User;

public class LibraryService
{
	private static volatile LibraryService service;
	private static LibraryDao dao;

	public static LibraryService getInstance () {
		if (service == null) {
			synchronized (LibraryService.class) {
				if (service == null) {
					service = new LibraryService();
					dao = LibraryDao.getInstance();
				}
			}
		}
		return service;
	}

	private LibraryService () {
		//Singleton class
	}

	public synchronized boolean processBookToLibrary (String title, String author) {
		Book book = new Book(title, author, true);
		boolean titleMapStatus = dao.addBookToTitleMap(book);
		boolean authorMapStatus = dao.addBookToAuthorMap(book);
		return titleMapStatus && authorMapStatus;
	}

	public boolean addUserToLibrary (String name) {
		User user = new User(name);
		return dao.addUserToMap(user);
	}

	public Book fetchBookFromLibrary (String title, User user) throws BookNotFoundException, BookNotAvailabileException, NoMoreBookAllocationException {
		int maxBooks = user.getMaxBooks();
		if (maxBooks > Constants.MAX_BOOKS_TO_USER) {
			throw new NoMoreBookAllocationException(String.format("%s not allowed any more books", user.getName()));
		}
		Book book = dao.getBookFromTitleMap(title);
		boolean availability = book.isAvailability();
		if (availability) {
			book.setAvailability(false);
			maxBooks++;
			user.setMaxBooks(maxBooks);
			return book;
		} else
			throw new BookNotAvailabileException(String.format("%s book not available", book.getTitle()));
	}

	public boolean setBookToLibrary (String title, User user) throws BookNotFoundException {
		Book book = dao.getBookFromTitleMap(title);
		book.setAvailability(true);
		int maxBooks = user.getMaxBooks();
		maxBooks--;
		user.setMaxBooks(maxBooks);

		return false;
	}
}
