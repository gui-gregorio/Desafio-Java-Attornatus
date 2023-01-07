package com.example.demo;


import com.example.demo.pessoas.Address;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AddressTests {
    @Test
    public void addressTests(){
        Address address = new Address();
        address.setId(1L);
        assertEquals(1L, address.getId());
        address.setCep("06182-010");
        assertEquals("06182-010", address.getCep());
        address.setNumero("12");
        assertEquals("12", address.getNumero());
        address.setLogradouro("Rua 1");
        assertEquals("Rua 1", address.getLogradouro());
        address.setCidade("São Paulo");
        assertEquals("São Paulo", address.getCidade());
        address.setPrincipal(TRUE);
        assertEquals(TRUE, address.getPrincipal());
    }
}
