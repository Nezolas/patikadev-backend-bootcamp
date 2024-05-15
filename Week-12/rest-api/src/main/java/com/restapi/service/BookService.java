package com.restapi.service;

import com.restapi.entitiy.Book;
import com.restapi.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException(id + "id li Kitap Bulunamadı !!!"));
    }

    @Transactional
    public Book create(Book book) {
        Optional<Book> isBookExist = bookRepository.findByNameAndAuthor(book.getName(), book.getAuthor());

        if (isBookExist.isEmpty()) {
            return this.bookRepository.save(book);
        }
        throw new RuntimeException("Bu kitap daha önce sisteme kayıt olmuştur !!!");
    }

    public Book update(Long id, Book book) {

        Optional<Book> bookFromDb = bookRepository.findById(id);

        if (bookFromDb.isEmpty()) {
            throw new RuntimeException(id + "Güncellemeye çalıştığınız kitap sistemde bulunamadı. !!!.");
        }

        book.setId(id);
        return this.bookRepository.save(book);
    }

    public void deleteById(Long id) {
        Optional<Book> bookFromDb = bookRepository.findById(id);
        if (bookFromDb.isPresent()) {
            bookRepository.delete(bookFromDb.get());
        } else {
            throw new RuntimeException(id + "id li Kitap sistemde bulunamadı !!!");
        }
    }

    public List<Book> findByCategoryId(Long id) {
        return bookRepository.findByCategoryId(id);
    }
}
