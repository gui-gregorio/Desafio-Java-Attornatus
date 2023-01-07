package com.example.demo.pessoas;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Pessoa")
@NamedQueries({
        @NamedQuery(name = "Pessoa.findAll", query = "select p from Pessoa p")
})

public class Pessoa {
    @Id
    @SequenceGenerator(
            name = "pessoa_sequence",
            sequenceName = "pessoa_sequence",
            allocationSize = 1
    )

    @GeneratedValue(strategy=GenerationType.SEQUENCE,
    generator = "pessoa_sequence")
    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Address> address;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, LocalDate dataNascimento, List<Address> address) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.address = address;
    }

    public Pessoa(String nome, LocalDate dataNascimento, List<Address> address) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", address ='" + address + '\'' +
                '}';
    }
}