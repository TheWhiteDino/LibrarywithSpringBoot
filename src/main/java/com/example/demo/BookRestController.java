package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController 
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/book")
    public String get() {
        BookEntity newBook = BookEntity.builder()
                                       .title("DungeonCrawlerCarl")
                                       .pages(510)
                                       .build();

        log.info("New book created: {}", newBook);

        bookRepository.save(newBook);
        
        return "Hello World";
    }






}