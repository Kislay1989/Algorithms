package LibrarySystem.pojo;

import LibrarySystem.common.Constants;

public class User
{
	private final String name;
	private int maxBooks;

	public User (String name) {
		this.name = name;
		this.maxBooks = Constants.MAX_BOOKS_TO_USER;
	}

	public String getName () {
		return name;
	}

	public int getMaxBooks () {
		return maxBooks;
	}

	public void setMaxBooks (int maxBooks) {
		this.maxBooks = maxBooks;
	}
}
