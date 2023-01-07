package com.example.demo.pessoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    @Autowired

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> getPessoas(){
                return pessoaRepository.findAll();
    }

    public void addNovaPessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);

    }

    public void deletaPessoa(Long pessoaId) {
       Boolean exists = pessoaRepository.existsById(pessoaId);
       if (!exists){
           throw new IllegalStateException("Pessoa do id " + pessoaId + "Não existe");
       }
       pessoaRepository.deleteById(pessoaId);
    }

    public Pessoa getPessoaById(Long pessoaId) {
        return pessoaRepository.findById(pessoaId).orElseThrow(
                () -> new IllegalStateException("Pessoa do id " + pessoaId + " não encontrada"));

    }

    public void updatePessoas(Long pessoaId, Pessoa pessoa) {
        Boolean exists = pessoaRepository.existsById(pessoaId);
        if(!exists){
            throw new IllegalStateException("Pessoa do id " + pessoaId + " não encontrada");
        }
        pessoa.setId(pessoaId);
        pessoaRepository.save(pessoa);

    }

    public List<Address> listaEnderecos(Long pessoaId) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        if (pessoa.isPresent()) {
            return pessoa.get().getAddress();
        }
        return new ArrayList<>();
    }
}
