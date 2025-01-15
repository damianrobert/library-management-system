package com.lms.library_management_system.service.IMPL;

import com.lms.library_management_system.dto.BorrowDTO;
import com.lms.library_management_system.dto.BorrowSaveDTO;
import com.lms.library_management_system.dto.BorrowUpdateDTO;
import com.lms.library_management_system.entity.Borrow;
import com.lms.library_management_system.repo.*;
import com.lms.library_management_system.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceIMPL implements BorrowService {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BorrowRepo borrowRepo;
    @Override
    public String addBorrow(BorrowSaveDTO borrowSaveDTO) {
        Borrow borrow = new Borrow(
                bookRepo.getById(borrowSaveDTO.getBookId()),
                userRepo.getById(borrowSaveDTO.getUserId()),
                borrowSaveDTO.getBorrowDate(),
                borrowSaveDTO.getReturnDate()
        );
        borrowRepo.save(borrow);
        return null;
    }

    @Override
    public List<BorrowDTO> getAllBorrows() {
        List<Borrow> borrows = borrowRepo.findAll();
        List<BorrowDTO> borrowDTOList = new ArrayList<>();

        for (Borrow borrow : borrows) {
            BorrowDTO borrowDTO = new BorrowDTO(
                    borrow.getBorrowId(),
                    borrow.getBook().getBookId(),
                    borrow.getUser().getUserId(),
                    borrow.getBorrowDate(),
                    borrow.getReturnDate()
            );
            borrowDTOList.add(borrowDTO);
        }

        return borrowDTOList;
    }

    @Override
    public String updateBorrow(BorrowUpdateDTO borrowUpdateDTO) {
        if(borrowRepo.existsById(borrowUpdateDTO.getBorrowId())){
            Borrow borrow = borrowRepo.getById(borrowUpdateDTO.getBorrowId());
            borrow.setBook(bookRepo.getById(borrowUpdateDTO.getBookId()));
            borrow.setUser(userRepo.getById(borrowUpdateDTO.getUserId()));
            borrow.setBorrowDate(borrowUpdateDTO.getBorrowDate());
            borrow.setReturnDate(borrowUpdateDTO.getReturnDate());

            borrowRepo.save(borrow);
        } else {
            System.out.println("Borrow does not exist");
        }

        return null;
    }

    @Override
    public String deleteBorrow(int id) {

        if(borrowRepo.existsById(id)){
            borrowRepo.deleteById(id);
        } else {
            System.out.println("Borrow does not exist");
        }

        return null;
    }


}
