package com.book.controller;


import com.book.entity.Author;
import com.book.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(authorService.findById(id));
    }
    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.save(author));

    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.update(author));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
