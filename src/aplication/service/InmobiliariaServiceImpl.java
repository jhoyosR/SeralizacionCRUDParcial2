package aplication.service;

import domain.Inmobiliaria;
import interfaces.InmobiliariaRepository;

import java.util.List;

public class InmobiliariaServiceImpl implements InmobiliariaService{
    private final InmobiliariaRepository inmobiliariaRepository;

    public InmobiliariaServiceImpl(InmobiliariaRepository inmobiliariaRepository){
        this.inmobiliariaRepository = inmobiliariaRepository;
    }


    @Override
    public List<Inmobiliaria> findAll() {
        return inmobiliariaRepository.findAll();
    }

    @Override
    public Inmobiliaria findById(int id) {
        return inmobiliariaRepository.findById(id);
    }

    @Override
    public void save(Inmobiliaria inmobiliaria) {
        inmobiliariaRepository.save(inmobiliaria);
    }

    @Override
    public void update(Inmobiliaria inmobiliaria) {
        inmobiliariaRepository.update(inmobiliaria);
    }

    @Override
    public void delete(int id) {
        inmobiliariaRepository.delete(id);
    }
}
