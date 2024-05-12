package com.book.service;

import com.book.entity.Author;
import com.book.repo.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthorService {

    @Autowired
    private final AuthorRepo authorRepo;

    public Author findById(String id) {
        return authorRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Author Not Found With ID: "+ id));
    }

    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    public Author save(Author author) {

        if (author.getId() != null){
            throw new RuntimeException();
        }
        return authorRepo.save(author);
    }

    public List<Author> saveAll(List<Author> authors) {
        return authorRepo.saveAll(authors);
    }

    public Author update(Author author) {
        return authorRepo.save(author);
    }

    public void deleteById(String id) {
        authorRepo.deleteById(id);
    }
}
