package com.example.demo;

import com.example.demo.pessoas.Address;
import com.example.demo.pessoas.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PessoasTests {
    @Test
    public void pessoasTests() {
        Address address1 = new Address("Rua 1", "0000-000", "1",
                "Cidade1", Boolean.TRUE);
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Guilherme");
        pessoa.setDataNascimento(LocalDate.of(1998, 8, 18));
        pessoa.setAddress(List.of(address1));
        assertEquals(1L, pessoa.getId());
        assertEquals("Guilherme", pessoa.getNome());
        assertEquals(LocalDate.of(1998, 8, 18), pessoa.getDataNascimento());
        assertEquals(List.of(address1), pessoa.getAddress());
        Pessoa pessoaMock = mock(Pessoa.class);
    }
}
