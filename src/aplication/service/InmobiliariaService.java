package aplication.service;

import domain.Inmobiliaria;

import java.util.List;

public interface InmobiliariaService {
    List<Inmobiliaria> findAll();
    Inmobiliaria findById(int id);
    void save(Inmobiliaria inmobiliaria);
    void update(Inmobiliaria inmobiliaria);
    void delete(int id);
}
