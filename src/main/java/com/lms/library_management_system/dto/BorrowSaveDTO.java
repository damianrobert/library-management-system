package com.lms.library_management_system.dto;

import com.lms.library_management_system.entity.Book;
import com.lms.library_management_system.entity.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowSaveDTO {

    private int bookId;

    private int userId;

    private String borrowDate;

    private String returnDate;

    public BorrowSaveDTO() {}

    public BorrowSaveDTO(int bookId, int userId, String borrowDate, String returnDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
