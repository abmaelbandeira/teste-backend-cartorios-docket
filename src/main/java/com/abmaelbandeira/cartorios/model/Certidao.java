package com.abmaelbandeira.cartorios.model;

import javax.persistence.*;

@Entity
public class Certidao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCertidao;
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cartorio cartorio;

    public long getIdCertidao() {
        return idCertidao;
    }

    public void setIdCertidao(long id) {
        this.idCertidao = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cartorio getCartorio() {
        return cartorio;
    }

    public void setCartorio(Cartorio cartorio) {
        this.cartorio = cartorio;
    }
}
