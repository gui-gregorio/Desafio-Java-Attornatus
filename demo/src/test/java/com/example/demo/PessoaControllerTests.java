package com.example.demo;
import com.example.demo.pessoas.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
class PessoaControllerTests {
    @Mock
    private PessoaRepository pessoaRepository;
    @InjectMocks
    private PessoaService pessoaService;

    @Test
    public void testGetPessoas() {
        PessoaService mockPessoaService = new PessoaService(pessoaRepository) {
            public List<Pessoa> getPessoas() {
                List<Pessoa> pessoas = new ArrayList<>();
                Address address1 = new Address("Rua 1", "0000-000", "1",
                        "Cidade1", Boolean.TRUE);
                Address address2 = new Address("Rua 2", "1111-111", "2", "Cidade2",
                        Boolean.FALSE);
                pessoas.add(new Pessoa("Pessoa 1", LocalDate.now(), List.of(address1, address2)));
                pessoas.add(new Pessoa("Pessoa 2", LocalDate.now(), List.of(address1, address2)));
                return pessoas;

            }
        };
        PessoaController controller = new PessoaController(mockPessoaService);

        List<Pessoa> pessoas = controller.getPessoas();
        assertEquals(2, pessoas.size());
        assertEquals("Pessoa 1", pessoas.get(0).getNome());
    }

    @Test
    public void testGetPessoasById() {
        PessoaService mockPessoaService = new PessoaService(pessoaRepository) {
            public Pessoa getPessoaById(Long pessoaId) {
                Address address1 = new Address("Rua 1", "0000-000", "1",
                        "Cidade1", Boolean.TRUE);
                Address address2 = new Address("Rua 2", "1111-111", "2", "Cidade2",
                        Boolean.FALSE);
                return new Pessoa(1L, "Pessoa 1", LocalDate.now(), List.of(address1, address2));
            }
        };
        PessoaController controller = new PessoaController(mockPessoaService);

        Pessoa pessoa = controller.getPessoasById(1L);
        assertEquals("Pessoa 1", pessoa.getNome());
    }


    @Test
    public void testCriarPessoas(){
        PessoaService mockPessoaService = mock(PessoaService.class);
        PessoaController controller = new PessoaController(mockPessoaService);
        Address address1 = new Address("Rua 1", "0000-000", "1",
                "Cidade1", Boolean.TRUE);
        Pessoa pessoa = new Pessoa("Pessoa 1", LocalDate.now(), List.of(address1));
        controller.criarPessoas(pessoa);
        verify(mockPessoaService).addNovaPessoa(pessoa);
    }

    @Test
    public void testUpdatePessoas() {
        PessoaService mockPessoaService = mock(PessoaService.class);
        PessoaController controller = new PessoaController(mockPessoaService);
        Address address1 = new Address("Rua 1", "0000-000", "1", "Cidade1", Boolean.TRUE);
        Pessoa pessoa = new Pessoa(1L, "Pessoa 1", LocalDate.now(), List.of(address1));
        controller.updatePessoas(1L, pessoa);
        verify(mockPessoaService).updatePessoas(1L, pessoa);
    }

    @Test
    public void testListaEnderecos(){
        PessoaService mockPessoaService = mock(PessoaService.class);
        PessoaController controller = new PessoaController(mockPessoaService);
        Address address1 = new Address("Rua 1", "0000-000", "1", "Cidade1", Boolean.TRUE);
        Pessoa pessoa = new Pessoa(1L, "Pessoa 1", LocalDate.now(), List.of(address1));
        controller.listaEnderecos(1L);
        verify(mockPessoaService).listaEnderecos(1L);

    }
    @Test
    public void testDeletePessoa(){
        PessoaService mockPessoaService = mock(PessoaService.class);
        PessoaController controller = new PessoaController(mockPessoaService);
        Address address1 = new Address("Rua 1", "0000-000", "1", "Cidade1", Boolean.TRUE);
        Pessoa pessoa = new Pessoa(1L, "Pessoa 1", LocalDate.now(), List.of(address1));
        controller.deletePessoa(1L);
        verify(mockPessoaService).deletaPessoa(1L);

    }



}

