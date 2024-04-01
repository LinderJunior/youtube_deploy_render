package br.com.danieleleaoe.deploy.checkout;

import br.com.danieleleaoe.deploy.books.Book;
import br.com.danieleleaoe.deploy.books.BooksRepository;
import br.com.danieleleaoe.deploy.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


//    @PostMapping
//    public ResponseEntity<Object> fazerCheckoutt(@RequestBody String matriculaCarro) {
//        // Realize uma busca na base de dados pelo cartão associado à matrícula do carro
//        Checkout cartao = checkoutRepository.findByMatriculaCarro(matriculaCarro);
//        if (cartao != null) {
//            // Faça o processamento necessário utilizando os dados do cartão encontrado
//            return checkoutService.fazerCheckout(String.valueOf(cartao));
//        } else {
//            // Caso o cartão não seja encontrado, retorne uma resposta de erro
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado para a matrícula do carro fornecida");
//        }
//    }

//    @PostMapping("test/{matriculaCarro}")
//    public ResponseEntity<Object> fazerCheckoutt2(@PathVariable String matriculaCarro) {
//        // Realize uma busca na base de dados pelo checkout associado à matrícula do carro
//        Checkout checkout = checkoutRepository.findByMatriculaCarro(matriculaCarro);
//
//        if (checkout != null) {
//            // Faça o processamento necessário utilizando os dados do checkout encontrado
//            return checkoutService.fazerCheckout(String.valueOf(checkout));
//        } else {
//            // Caso o checkout não seja encontrado, retorne uma resposta de erro
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checkout não encontrado para a matrícula do carro fornecida");
//        }
//    }



//    @PostMapping("test")
//    public ResponseEntity<Object> fazerCheckout3(@RequestBody String matriculaCarro) {
//        // Realize uma busca na base de dados pelo checkout associado à matrícula do carro
//        Checkout checkout = checkoutRepository.findByMatriculaCarro(matriculaCarro);
//
//        if (checkout != null) {
//            // Faça o processamento necessário utilizando os dados do checkout encontrado
//            return checkoutService.fazerCheckoutPost(String.valueOf(checkout));
//        } else {
//            // Caso o checkout não seja encontrado, retorne uma resposta de erro
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checkout não encontrado para a matrícula do carro fornecida");
//        }
//    }





/* 12:24
    @PostMapping("test/{outraParametro}")
    public ResponseEntity<Object> fazerCheckout3(@PathVariable String outraParametro, @RequestBody MatriculaCarroRequestBody requestBody) {
        String matriculaCarro = requestBody.getMatriculaCarro();

        // Realize uma busca na base de dados pelo checkout associado à matrícula do carro
        Checkout checkout = checkoutRepository.findByMatriculaCarro(matriculaCarro);

        if (checkout != null) {
            // Faça o processamento necessário utilizando os dados do checkout encontrado
            return checkoutService.fazerCheckoutPost(String.valueOf(checkout));
        } else {
            // Caso o checkout não seja encontrado, retorne uma resposta de erro
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checkout não encontrado para a matrícula do carro fornecida");
        }
    }

    */



    //PASSANDO PARAMETRO VIA POST E NO BODY
    @PostMapping("test/{outraParametro}")
    public ResponseEntity<Object> fazerCheckout3(@PathVariable String outraParametro, @RequestBody MatriculaCarroRequestBody requestBody) {
        String matriculaCarro = requestBody.getMatriculaCarro();

        // Verifica se o parâmetro do path e a matrícula do carro no corpo da requisição são iguais
        if (!outraParametro.equals(matriculaCarro)) {
            // Caso não sejam iguais, retorna uma resposta de erro
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A matrícula do carro no path e no corpo da requisição não correspondem.");
        }

        // Realize uma busca na base de dados pelo checkout associado à matrícula do carro
        Checkout checkout = checkoutRepository.findByMatriculaCarro(matriculaCarro);

        if (checkout != null) {
            // Faça o processamento necessário utilizando os dados do checkout encontrado
            return checkoutService.fazerCheckoutPost(String.valueOf(checkout));
        } else {
            // Caso o checkout não seja encontrado, retorne uma resposta de erro
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Checkout não encontrado para a matrícula do carro fornecida");
        }
    }

    //parametro caetano
    @PostMapping("test/parametro/{outraParametro}")
    public ResponseEntity<Object> fazerCheckoutByParametro(@PathVariable String outraParametro) {
        return checkoutService.fazerCheckoutParametro(outraParametro);
    }













    @PostMapping("test/body")
    public ResponseEntity<Object> fazerCheckoutByBody(@RequestBody MatriculaCarroRequestBody requestBody) {
        return checkoutService.fazerCheckoutBody(requestBody);
    }



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
