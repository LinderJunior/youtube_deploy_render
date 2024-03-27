package br.com.danieleleaoe.deploy.checkout;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "checkout")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Checkout {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String numeroCartao;
    private String matriculaCarro;
    private Double saldoDisponivel;

}
