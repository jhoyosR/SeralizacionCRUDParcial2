package infraestructure;

import domain.Inmobiliaria;
import interfaces.InmobiliariaRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class InmobiliariaRepositoryImpl implements InmobiliariaRepository {
        private static final String FILE_NAME = "inmobiliarias.dat";

        @Override
        public List<Inmobiliaria> findAll() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                return (ArrayList<Inmobiliaria>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                return new ArrayList<>();
            }
        }
        @Override
        public Inmobiliaria findById(int id) {
            return findAll().stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .orElse(null);
        }
        @Override
        public void save(Inmobiliaria inmobiliaria) {
            List<Inmobiliaria> inmobiliarias = findAll();
            inmobiliarias.add(inmobiliaria);
            saveAll(inmobiliarias);
        }

        @Override
        public void update(Inmobiliaria inmobiliaria) {
            List<Inmobiliaria> inmobiliarias = findAll();
            inmobiliarias = inmobiliarias.stream()
                    .map(p -> p.getId() == inmobiliaria.getId() ? inmobiliaria : p)
                    .collect(Collectors.toList());
            saveAll(inmobiliarias);
        }

        @Override
        public void delete(int id) {
            List<Inmobiliaria> inmobiliarias = findAll();
            inmobiliarias = inmobiliarias.stream()
                    .filter(p -> p.getId() != id)
                    .collect(Collectors.toList());
            saveAll(inmobiliarias);
        }

        private void saveAll(List<Inmobiliaria> inmobiliarias) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                oos.writeObject(inmobiliarias);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
