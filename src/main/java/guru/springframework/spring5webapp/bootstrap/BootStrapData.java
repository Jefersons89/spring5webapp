package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Component
public class BootStrapData implements CommandLineRunner
{
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(final AuthorRepository authorRepository, final BookRepository bookRepository,
			final PublisherRepository publisherRepository)
	{
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(final String... args) throws Exception
	{
		Author jeff = new Author();
		jeff.setFirstName("Jeferson");
		jeff.setLastName("Salazar");

		Author hayder = new Author();
		hayder.setFirstName("Hayder");
		hayder.setLastName("Bedoya");

		authorRepository.save(jeff);
		authorRepository.save(hayder);


		Book gow = new Book();
		gow.setTitle("God of War");
		gow.setIsbn("1234");

		Book cod = new Book();
		cod.setTitle("Call of Duty");
		cod.setIsbn("4321");

		bookRepository.save(gow);
		bookRepository.save(cod);


		Publisher sony = new Publisher("sony", "Street 1", "Montreal", "Florida", 19264);
		Publisher ubisoft = new Publisher("ubisoft", "Street 2", "New York", "Canzas", 81724);

		publisherRepository.save(sony);
		publisherRepository.save(ubisoft);

		jeff.getBooks().add(gow);
		gow.getAuthors().add(jeff);
		gow.setPublisher(sony);
		sony.getBooks().add(gow);

		hayder.getBooks().add(cod);
		cod.getAuthors().add(hayder);
		cod.setPublisher(ubisoft);
		ubisoft.getBooks().add(cod);

		authorRepository.save(jeff);
		bookRepository.save(gow);
		publisherRepository.save(sony);

		authorRepository.save(hayder);
		bookRepository.save(cod);
		publisherRepository.save(ubisoft);

		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Number of Publishers: " + publisherRepository.count());
	}
}
