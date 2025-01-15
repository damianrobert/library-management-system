package com.lms.library_management_system.service.IMPL;

import com.lms.library_management_system.dto.AuthorDTO;
import com.lms.library_management_system.dto.AuthorSaveDTO;
import com.lms.library_management_system.dto.AuthorUpdateDTO;
import com.lms.library_management_system.entity.Author;
import com.lms.library_management_system.repo.AuthorRepo;
import com.lms.library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceIMPL implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public String addAuthor(AuthorSaveDTO authorSaveDTO) {

        Author author = new Author(
                authorSaveDTO.getAuthorName()
        );
        authorRepo.save(author);

        return author.getAuthorName();
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {

        List<Author> getAuthors = authorRepo.findAll();
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for (Author author : getAuthors) {
            AuthorDTO authorDTO = new AuthorDTO(
                    author.getAuthorId(),
                    author.getAuthorName()
            );
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }

    @Override
    public String updateAuthor(AuthorUpdateDTO authorUpdateDTO) {

        if(authorRepo.existsById(authorUpdateDTO.getAuthorId())) {

            Author author = authorRepo.findById(authorUpdateDTO.getAuthorId()).get();
            author.setAuthorName(authorUpdateDTO.getAuthorName());

            authorRepo.save(author);
            return author.getAuthorName();
        }else {
            System.out.println("Author not found");
        }

        return null;
    }

    @Override
    public String deleteAuthor(int id) {

        if(authorRepo.existsById(id)) {
            authorRepo.deleteById(id);
        } else {
            System.out.println("Author not found");
        }

        return null;
    }
}
