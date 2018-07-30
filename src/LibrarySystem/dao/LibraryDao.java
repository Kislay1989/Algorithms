package LibrarySystem.dao;

import LibrarySystem.exception.BookNotFoundException;
import LibrarySystem.pojo.Book;
import LibrarySystem.pojo.User;

import java.util.Map;

public class LibraryDao
{
	private static volatile LibraryDao dao;

	private Map<String, Book> bookMapByTitle;
	private Map<String, Book> bookMapByAuthor;
	private Map<String, User> userMap;

	public static LibraryDao getInstance () {
		if (dao == null) {
			synchronized (LibraryDao.class) {
				if (dao == null) {
					dao = new LibraryDao();
				}
			}
		}
		return dao;
	}

	private LibraryDao () {
		//Singleton Instance
	}

	public boolean addBookToTitleMap (Book book) {
		String title = book.getTitle();
		if (bookMapByTitle.containsKey(title))
			return false;
		else
			bookMapByTitle.put(title, book);
		return true;
	}

	public boolean addBookToAuthorMap (Book book) {
		String author = book.getAuthor();
		if (bookMapByTitle.containsKey(author))
			return false;
		else
			bookMapByTitle.put(author, book);
		return true;
	}

	public boolean addUserToMap (User user) {
		String name = user.getName();
		if (userMap.containsKey(name))
			return false;
		else
			userMap.put(name, user);
		return true;
	}

	public Book getBookFromTitleMap (String title) throws BookNotFoundException {
		if (!bookMapByTitle.containsKey(title))
			throw new BookNotFoundException(String.format("%s book not found in system", title));
		return bookMapByTitle.get(title);
	}

}
