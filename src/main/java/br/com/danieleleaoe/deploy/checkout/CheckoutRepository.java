package br.com.danieleleaoe.deploy.checkout;

import br.com.danieleleaoe.deploy.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckoutRepository extends JpaRepository<Checkout, UUID> {


    Checkout findByMatriculaCarro(String matriculaCarro);
}
