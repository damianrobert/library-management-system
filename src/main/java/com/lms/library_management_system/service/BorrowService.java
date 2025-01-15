package com.lms.library_management_system.service;

import com.lms.library_management_system.dto.BorrowDTO;
import com.lms.library_management_system.dto.BorrowSaveDTO;
import com.lms.library_management_system.dto.BorrowUpdateDTO;

import java.util.List;

public interface BorrowService {
    String addBorrow(BorrowSaveDTO borrowSaveDTO);

    List<BorrowDTO> getAllBorrows();

    String updateBorrow(BorrowUpdateDTO borrowUpdateDTO);

    String deleteBorrow(int id);
}
