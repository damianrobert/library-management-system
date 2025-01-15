package com.lms.library_management_system.service.IMPL;

import com.lms.library_management_system.dto.BookDTO;
import com.lms.library_management_system.dto.BookSaveDTO;
import com.lms.library_management_system.dto.BookUpdateDTO;
import com.lms.library_management_system.entity.Book;
import com.lms.library_management_system.repo.AuthorRepo;
import com.lms.library_management_system.repo.BookRepo;
import com.lms.library_management_system.repo.PublisherRepo;
import com.lms.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    @Autowired
    private BookRepo bookRepo;

    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {

        Book book = new Book(
                bookSaveDTO.getBookTitle(),
                authorRepo.getById(bookSaveDTO.getAuthorId()),
                publisherRepo.getById(bookSaveDTO.getPublisherId())
        );
        bookRepo.save(book);
        return book.getBookTitle();
    }
    
    

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> getBooks = bookRepo.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();

        for (Book book : getBooks) {
            BookDTO bookDTO = new BookDTO(
                    book.getBookId(),
                    book.getBookTitle(),
                    book.getAuthor().getAuthorId(),
                    book.getPublisher().getPublisherId()
            );
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    @Override
    public String updateBook(BookUpdateDTO bookUpdateDTO) {

        if(bookRepo.existsById(bookUpdateDTO.getBookId())) {
            Book book = bookRepo.getById(bookUpdateDTO.getBookId());
            book.setBookTitle(bookUpdateDTO.getBookTitle());
            book.setAuthor(authorRepo.getById(bookUpdateDTO.getAuthorId()));
            book.setPublisher(publisherRepo.getById(bookUpdateDTO.getPublisherId()));

            bookRepo.save(book);
            return book.getBookTitle();
        } else {
            System.out.println("Book not found");
        }
        return null;
    }

    @Override
    public String deleteBook(int id) {
        if(bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
        } else {
            System.out.println("Book not found");
        }
        return null;
    }
}
