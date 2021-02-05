package com.abmaelbandeira.cartorios.service;

import com.abmaelbandeira.cartorios.model.Cartorio;

import java.util.List;

public interface CartorioService {
    List<Cartorio> getAllCartorios();
    void saveCartorio(Cartorio cartorio);
    Cartorio getCartorioById(long id);
    void deleteCartorioById(long id);
}
