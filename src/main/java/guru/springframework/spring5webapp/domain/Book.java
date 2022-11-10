package guru.springframework.spring5webapp.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;


/**
 * A Book has a title and an isbn.
 */
@Entity
public class Book
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String isbn;
	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();

	@ManyToOne
	private Publisher publisher;

	public Book()
	{
	}

	public Book(final String title, final String isbn)
	{
		this.title = title;
		this.isbn = isbn;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(final String title)
	{
		this.title = title;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(final String isbn)
	{
		this.isbn = isbn;
	}

	public Set<Author> getAuthors()
	{
		return authors;
	}

	public void setAuthors(final Set<Author> authors)
	{
		this.authors = authors;
	}

	public Publisher getPublisher()
	{
		return publisher;
	}

	public void setPublisher(final Publisher publisher)
	{
		this.publisher = publisher;
	}

	@Override
	public String toString()
	{
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", isbn='" + isbn + '\'' +
				'}';
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
			return true;
		if (!(o instanceof Book))
			return false;

		Book book = (Book) o;

		return getId() != null ? getId().equals(book.getId()) : book.getId() == null;
	}

	@Override
	public int hashCode()
	{
		return getId() != null ? getId().hashCode() : 0;
	}
}
