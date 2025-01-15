package com.lms.library_management_system.service;

import com.lms.library_management_system.dto.BookDTO;
import com.lms.library_management_system.dto.BookSaveDTO;
import com.lms.library_management_system.dto.BookUpdateDTO;

import java.util.List;

public interface BookService {
    String addBook(BookSaveDTO bookSaveDTO);

    List<BookDTO> getAllBooks();

    String updateBook(BookUpdateDTO bookUpdateDTO);

    String deleteBook(int id);
}
