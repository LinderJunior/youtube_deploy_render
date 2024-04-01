package br.com.danieleleaoe.deploy.service;

import br.com.danieleleaoe.deploy.checkout.Checkout;
import br.com.danieleleaoe.deploy.checkout.CheckoutRepository;
import br.com.danieleleaoe.deploy.checkout.MatriculaCarroRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CheckoutService {

    @Autowired
    private CheckoutRepository checkoutRepository;
    
    public ResponseEntity<Object> fazerCheckout(String matriculaCarro) {
        // Busca o checkout pelo número da matrícula do carro
        Checkout checkout = checkoutRepository.findByMatriculaCarro(matriculaCarro);

        // Verifica se o checkout foi encontrado
        if (checkout == null) {
            // Retorna resposta indicando que o checkout não foi encontrado com status 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o checkout para a matrícula do carro fornecida SERVICE.");
        }

        // Verifica o saldo disponível
        Double saldoDisponivel = checkout.getSaldoDisponivel();
        if (saldoDisponivel < 300) {
            // Retorna resposta indicando saldo insuficiente com status 403
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Saldo insuficiente.");
        }

        // Retorna resposta indicando que o checkout foi bem-sucedido com status 200
        return ResponseEntity.ok("Checkout realizado com sucesso.");
    }


    //Checkout mix
    public ResponseEntity<Object> fazerCheckoutPost(String checkoutData) {
        return ResponseEntity.ok("Checkout realizado com sucesso.");
    }


    public ResponseEntity<Object> fazerCheckoutBody(MatriculaCarroRequestBody requestBody) {
        String matriculaCarro = requestBody.getMatriculaCarro();
        // Aqui você colocaria a lógica para buscar o checkout pelo matriculaCarro
        // Esta é uma implementação de exemplo
        String resultado = "Realizando checkout com base no corpo da requisição: " + matriculaCarro;
        return ResponseEntity.ok(resultado);
    }



    public ResponseEntity<Object> fazerCheckoutParametro(String outraParametro) {
        // Aqui você colocaria a lógica para buscar o checkout pelo outraParametro
        // Esta é uma implementação de exemplo
        String resultado = "Realizando checkout com base no parâmetro: " + outraParametro;
        return ResponseEntity.ok(resultado);
    }

}
