package br.com.danieleleaoe.deploy.books;

import java.util.List;

import br.com.danieleleaoe.deploy.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;



    @GetMapping
    public List<Book> list() {
        return this.booksRepository.findAll();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return this.booksRepository.save(book);
    }



}
