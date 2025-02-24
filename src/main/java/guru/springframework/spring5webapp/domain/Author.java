package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;


/**
 * An Author has a first name, a last name, and a set of books.
 */
@Entity
public class Author
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	@ManyToMany(mappedBy = "authors")
	Set<Book> books = new HashSet<>();

	public Author()
	{
	}

	public Author(final String firstName, final String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(final String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(final String lastName)
	{
		this.lastName = lastName;
	}

	public Set<Book> getBooks()
	{
		return books;
	}

	public void setBooks(final Set<Book> books)
	{
		this.books = books;
	}

	@Override
	public String toString()
	{
		return "Author{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
			return true;
		if (!(o instanceof Author))
			return false;

		Author author = (Author) o;

		return getId() != null ? getId().equals(author.getId()) : author.getId() == null;
	}

	@Override
	public int hashCode()
	{
		return getId() != null ? getId().hashCode() : 0;
	}
}
