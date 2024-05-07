package interfaces;

import domain.Inmobiliaria;

import java.util.List;

public interface InmobiliariaRepository {
    List<Inmobiliaria> findAll();
    Inmobiliaria findById(int id);
    void save(Inmobiliaria inmobiliaria);
    void update(Inmobiliaria inmobiliaria);
    void delete(int id);
}
