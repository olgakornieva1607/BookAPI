package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;


    @Override
    public List<Book> getBooks() {

        return bookRepository.findAll();
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);

    }

    @Override
    public Optional<Book> get(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void delete(Long id) {

        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book book) {

        bookRepository.save(book);
    }
}
