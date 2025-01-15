package com.lms.library_management_system.controller;

import com.lms.library_management_system.dto.AuthorDTO;
import com.lms.library_management_system.dto.AuthorSaveDTO;
import com.lms.library_management_system.dto.AuthorUpdateDTO;
import com.lms.library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(path = "/save")
    public String saveAuthor(@RequestBody AuthorSaveDTO authorSaveDTO){
        String authorName = authorService.addAuthor(authorSaveDTO);
        return authorName;
    }

    @GetMapping(path = "/getAllAuthors")
    public List<AuthorDTO> getAllAuthors(){
        List<AuthorDTO> allAuthors = authorService.getAllAuthors();
        return allAuthors;
    }

    @PostMapping(path = "/update")
    public String updateAuthor(@RequestBody AuthorUpdateDTO authorUpdateDTO){
        String authorName = authorService.updateAuthor(authorUpdateDTO);
        return authorName;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteAuthor(@PathVariable(value = "id") int id){
        String authorName = authorService.deleteAuthor(id);
        return "Author deleted successfully";
    }
}
