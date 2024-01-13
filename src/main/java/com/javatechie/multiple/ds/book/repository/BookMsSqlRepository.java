package com.javatechie.multiple.ds.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javatechie.multiple.ds.book.entity.Book;

@Repository
public interface BookMsSqlRepository extends JpaRepository<Book, Integer> {

}
