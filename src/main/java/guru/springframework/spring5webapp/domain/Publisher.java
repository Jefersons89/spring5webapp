package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Publisher
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String addressLine1;
	private String city;
	private String state;
	private Integer zip;

	@OneToMany
	@JoinColumn(name = "publisher_id")
	Set<Book> books = new HashSet<>();

	public Publisher()
	{
	}

	public Publisher(final String name, final String addressLine1, final String city, final String state, final Integer zip)
	{
		this.name = name;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(final String line1)
	{
		this.addressLine1 = line1;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(final String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(final String state)
	{
		this.state = state;
	}

	public Integer getZip()
	{
		return zip;
	}

	public void setZip(final Integer zip)
	{
		this.zip = zip;
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
		return "Publisher{" +
				"id=" + id +
				", name='" + name + '\'' +
				", line1='" + addressLine1 + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zip=" + zip +
				'}';
	}

	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
			return true;
		if (!(o instanceof Publisher))
			return false;

		Publisher publisher = (Publisher) o;

		return Objects.equals(id, publisher.id);
	}

	@Override
	public int hashCode()
	{
		return id != null ? id.hashCode() : 0;
	}
}
