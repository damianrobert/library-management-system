package com.lms.library_management_system.controller;

import com.lms.library_management_system.dto.AuthorUpdateDTO;
import com.lms.library_management_system.dto.BookDTO;
import com.lms.library_management_system.dto.BookSaveDTO;
import com.lms.library_management_system.dto.BookUpdateDTO;
import com.lms.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(path = "/save")
    public String saveBook(@RequestBody BookSaveDTO bookSaveDTO){
        String bookTitle = bookService.addBook(bookSaveDTO);
        return bookTitle;
    }

    @GetMapping(path = "/getAllBooks")
    public List<BookDTO> getAllBooks(){
        List<BookDTO> allBooks = bookService.getAllBooks();
        return allBooks;
    }

    @PostMapping(path = "/update")
    public String updateBook(@RequestBody BookUpdateDTO bookUpdateDTO){
        String bookTitle = bookService.updateBook(bookUpdateDTO);
        return bookTitle;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") int id){
        String bookTitle = bookService.deleteBook(id);
        return bookTitle;
    }
}
