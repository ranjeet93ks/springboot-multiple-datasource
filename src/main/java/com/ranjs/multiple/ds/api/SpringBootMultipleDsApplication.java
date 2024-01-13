package com.ranjs.multiple.ds.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javatechie.multiple.ds.book.entity.Book;
import com.javatechie.multiple.ds.book.repository.BookMsSqlRepository;
import com.javatechie.multiple.ds.user.entity.User;
import com.javatechie.multiple.ds.user.repository.UserMySqlRepository;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class SpringBootMultipleDsApplication {

	@Autowired
	private BookMsSqlRepository bookRepository;

	@Autowired
	private UserMySqlRepository userRepository;

	@PostConstruct
	public void addData2DB() {
		userRepository.saveAll(Stream.of(new User(744, "John"), new User(455, "Pitter")).collect(Collectors.toList()));
		bookRepository.saveAll(
				Stream.of(new Book(111, "Core Java"), new Book(222, "Spring Boot")).collect(Collectors.toList()));
	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultipleDsApplication.class, args);
	}
}
