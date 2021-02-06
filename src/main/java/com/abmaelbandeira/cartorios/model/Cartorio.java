package com.abmaelbandeira.cartorios.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cartorios")
public class Cartorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String endereco;

    @OneToMany(mappedBy = "cartorio", cascade = CascadeType.ALL)
    private List<Certidao> certidoes;

    public Cartorio(){}

    public Cartorio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
