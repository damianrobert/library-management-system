package com.lms.library_management_system.controller;

import com.lms.library_management_system.dto.BookSaveDTO;
import com.lms.library_management_system.dto.BorrowDTO;
import com.lms.library_management_system.dto.BorrowSaveDTO;
import com.lms.library_management_system.dto.BorrowUpdateDTO;
import com.lms.library_management_system.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping(path = "/save")
    public String saveBorrow(@RequestBody BorrowSaveDTO borrowSaveDTO)
    {
        String borrowBooks = borrowService.addBorrow(borrowSaveDTO);
        return  "Borrowed Successfully";
    }

    @GetMapping(path = "/getAllBorrows")
    public List<BorrowDTO> getAllBorrows()
    {
        List<BorrowDTO> allborrows = borrowService.getAllBorrows();
        return allborrows;
    }

    @PostMapping(path = "/update")
    public String updateBorrow(@RequestBody BorrowUpdateDTO borrowUpdateDTO)
    {
        String borrow = borrowService.updateBorrow(borrowUpdateDTO);
        return borrow;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteBorrow(@PathVariable(value = "id") int id){
        String borrowName = borrowService.deleteBorrow(id);
        return "Borrow deleted successfully";
    }

}
