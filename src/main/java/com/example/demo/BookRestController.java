package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String get(@RequestParam String name, @RequestParam Integer pages) {
    
        log.info("Received request to create book with name: {} and pages: {}", name, pages);

        BookEntity existingBook = bookRepository.findByNameAndPages(name, pages);

        if(existingBook == null) {

        BookEntity newBook = BookEntity.builder()
                                       .name(name)
                                       .pages(pages)
                                       .build();

        bookRepository.save(newBook);
        
        log.info("Book saved successfully: {}", newBook);
        return "Book saved successfully";

        } else {
            log.info("Book already exists: {}", existingBook);
            return "Book already exists";
        }






    }



}