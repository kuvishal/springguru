package guru.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authrRepo;
	private BookRepository bookrepo;
	private PublisherRepository publisherRepo;
	
	
	public DevBootStrap(AuthorRepository authrRepo, BookRepository bookrepo,PublisherRepository publisherRepo) {
		super();
		this.authrRepo = authrRepo;
		this.bookrepo = bookrepo;
		this.publisherRepo=publisherRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}

	private void initData() {
		Author auth1= new Author("sashi", "vatikutti");
		Publisher p1= new Publisher("cisco inc", "San Fransico");
		publisherRepo.save(p1);
		Book b1= new Book("Delligent worker", "1234", p1);
		b1.getAuthors().add(auth1);
		auth1.getBooks().add(b1);
		
		authrRepo.save(auth1);
		bookrepo.save(b1);
		
		Publisher p2= new Publisher("ABC inc", "Bangalore");
		publisherRepo.save(p2);
		Author auth2= new Author("kapil", "yadav");
		Book b2= new Book("smart worker", "9876", p2);
		b2.getAuthors().add(auth2);
		auth2.getBooks().add(b2);
		
		authrRepo.save(auth2);
		bookrepo.save(b2);
		
	}

}
