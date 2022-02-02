package LibrarySystem.pojo;

public class Book
{
	private final String title;
	private final String author;
	private boolean availability;

	public Book (String title, String author, boolean availability) {
		this.availability = availability;
		this.title = title;
		this.author = author;
	}

	public String getTitle () {
		return title;
	}

	public String getAuthor () {
		return author;
	}

	public boolean isAvailability () {
		return availability;
	}

	public void setAvailability (boolean availability) {
		this.availability = availability;
	}
}
