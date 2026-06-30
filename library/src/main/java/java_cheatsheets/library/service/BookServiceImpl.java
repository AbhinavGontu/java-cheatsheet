package java_cheatsheets.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import java_cheatsheets.library.Book;
import java_cheatsheets.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id){
        return repository.findById(id);
    }

    @Override
    public Book createBook(Book book){
        return repository.save(book);
    }

    @Override
    public Optional<Book> updateBook(Long id, Book book){
        return repository.findById(id).map(existing -> 
        {existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setIsbn(book.getIsbn());
        existing.setAvailable(book.isAvailable());
        return repository.save(existing);
        });
    }

    @Override
    public boolean deleteBook(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
