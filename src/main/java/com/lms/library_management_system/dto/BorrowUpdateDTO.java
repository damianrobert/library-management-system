package com.lms.library_management_system.dto;

import com.lms.library_management_system.entity.Book;
import com.lms.library_management_system.entity.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowUpdateDTO {

    private int borrowId;

    private int bookId;

    private int userId;

    private String borrowDate;

    private String returnDate;

    public BorrowUpdateDTO() {}

    public BorrowUpdateDTO(int borrowId, int bookId, int userId, String borrowDate, String returnDate) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
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
