package com.example.demo.pessoas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PessoaConfig {

    @Bean
    CommandLineRunner commandLineRunner(PessoaRepository repository){
        return args -> {
            Address addressCaio = new Address(
                    "Rua do Caio",
                    "000-000",
                    "0",
                    "Cidade dos Caios",
                    Boolean.FALSE
            );

            Address addressCaio2 = new Address(
                    "Rua do caio 2",
                    "1111-111",
                    "1",
                    "Cidade do Caios",
                    Boolean.TRUE
            );


            Pessoa CaioRenan = new Pessoa(
                    "Caio Renan",
                    LocalDate.of(2001, Month.JULY, 7),
                    List.of(addressCaio, addressCaio2)
            );


            Address enderecoLeonardo = new Address(
                    "Rua do Leonardo",
                    "0623-123",
                    "22",
                    "Osasco",
                    Boolean.TRUE
            );

            Pessoa Leonardo = new Pessoa(
                    "Leonardo Oliveira",
                    LocalDate.of(1990, Month.NOVEMBER, 2),
                    List.of(enderecoLeonardo)

            );

            Address enderecoKurt = new Address(
                    "Rua do Kurt",
                    "0623-123",
                    "322",
                    "São Paulo",
                    Boolean.TRUE
            );

            Pessoa Kurt = new Pessoa(
                    "Kaique Botti",
                    LocalDate.of(1993, Month.NOVEMBER, 3),
                    List.of(enderecoKurt)
            );

            Address enderecoRafa = new Address(
                    "Rua dos sapos",
                    "0618-222",
                    "3",
                    "São Paulo",
                    Boolean.TRUE
            );

            Pessoa Rafa = new Pessoa(
                    "Rafael Arruda",
                    LocalDate.of(1993, Month.DECEMBER, 29),
                    List.of(enderecoRafa)
            );

            repository.saveAll(
                    List.of(CaioRenan, Rafa, Kurt, Leonardo)
            );

        };
    }
}
