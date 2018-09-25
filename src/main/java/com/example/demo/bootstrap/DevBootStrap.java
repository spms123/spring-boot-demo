package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	

	public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {
		Publisher publisher1=new Publisher("Haper Collins", "102,Bakerstreet");
		publisherRepository.save(publisher1);
		Publisher publisher2=new Publisher("Schildt", "104,Bakerstreet");
		publisherRepository.save(publisher2);
		Author eric=new Author("Eric","Evan");
		Book ddd=new Book("Domain Design", "1234", publisher1);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		Author rose=new Author("Rose","Jhon");
		Book eee=new Book("J2EE", "5678", publisher2);
		rose.getBooks().add(eee);
		authorRepository.save(rose);
		bookRepository.save(eee);
	}
}
