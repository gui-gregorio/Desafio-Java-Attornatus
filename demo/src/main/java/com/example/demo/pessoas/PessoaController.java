package com.example.demo.pessoas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/pessoas/")
public class PessoaController {


    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping()
    public List<Pessoa> getPessoas(){
        return pessoaService.getPessoas();
    }

    @GetMapping("{pessoaId}/")
    public Pessoa getPessoasById(@PathVariable("pessoaId") Long pessoaId){
        return pessoaService.getPessoaById(pessoaId);
    }

    @PostMapping()
    public void criarPessoas(@RequestBody Pessoa pessoa){
        pessoaService.addNovaPessoa(pessoa);

    }


    @PutMapping("{pessoaId}/")
    public void updatePessoas(@PathVariable("pessoaId")Long pessoaId, @RequestBody Pessoa pessoa){
        pessoaService.updatePessoas(pessoaId, pessoa);
    }

    @GetMapping("{pessoaId}/enderecos/")
    public List<Address> listaEnderecos(@PathVariable long pessoaId){
        return pessoaService.listaEnderecos(pessoaId);
    }

    @DeleteMapping("{pessoaId}/")
    public void deletePessoa(@PathVariable("pessoaId") Long pessoaId){

        pessoaService.deletaPessoa(pessoaId);
    }
}

