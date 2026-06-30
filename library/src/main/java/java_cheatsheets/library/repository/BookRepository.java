package java_cheatsheets.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java_cheatsheets.library.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}