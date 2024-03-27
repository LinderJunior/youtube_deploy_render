package br.com.danieleleaoe.deploy.checkout;

import br.com.danieleleaoe.deploy.books.Book;
import br.com.danieleleaoe.deploy.books.BooksRepository;
import br.com.danieleleaoe.deploy.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    private CheckoutService checkoutService;



    @GetMapping
    public List<Checkout> list() {
        return this.checkoutRepository.findAll();
    }

    @PostMapping
    public Checkout create(@RequestBody Checkout checkout) {
        return this.checkoutRepository.save(checkout);
    }

    @GetMapping("/{matriculaCarro}")
    public ResponseEntity<Object> fazerCheckout(@PathVariable String matriculaCarro) {
        return checkoutService.fazerCheckout(matriculaCarro);
    }

}
