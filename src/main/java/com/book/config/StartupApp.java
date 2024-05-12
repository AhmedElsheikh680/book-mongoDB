package com.book.config;

import com.book.entity.Author;
import com.book.repo.AuthorRepo;
import com.book.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class StartupApp implements CommandLineRunner {

    @Autowired
    private final AuthorService authorService;

    @Override
    public void run(String... args) throws Exception {

        if (authorService.findAll().isEmpty()) {


            Author author = new Author();
            author.setName("Ahmed");
            author.setEmail("a@a.com");
            author.setPhone("0100424283");

            Author author2 = new Author();
            author2.setName("Mohamed");
            author2.setEmail("m@m.com");
            author2.setPhone("0100424287");

            Author author3 = new Author();
            author3.setName("Kamal");
            author3.setEmail("k@k.com");
            author3.setPhone("0100424281");

            Author author4 = new Author();
            author4.setName("Ramy");
            author4.setEmail("r@r.com");
            author4.setPhone("0100424280");

            authorService.saveAll(Arrays.asList(author, author2, author3, author4));
        }
    }
}
