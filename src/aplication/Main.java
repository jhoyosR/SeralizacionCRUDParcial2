package aplication;

import aplication.service.InmobiliariaService;
import aplication.service.InmobiliariaServiceImpl;
import domain.Inmobiliaria;
import infraestructure.InmobiliariaRepositoryImpl;
import interfaces.InmobiliariaRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InmobiliariaService inmobiliariaService;

    static {
        InmobiliariaRepository inmobiliariaRepository = new InmobiliariaRepositoryImpl();
        inmobiliariaService = new InmobiliariaServiceImpl(inmobiliariaRepository);
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Registrar Inmobiliaria");
            System.out.println("2. Actualizar Mueble Registrado");
            System.out.println("3. Eliminar mueble");
            System.out.println("4. Consultar muebles");
            System.out.println("0. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registrarInmobiliaria();
                    break;
                case 2:
                    actualizarMuebleRegistrado();
                    break;
                case 3:
                    eliminarMueble();
                    break;
                case 4:
                    consultarMuebles();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion inválida");
            }
        }
    }

    private static void registrarInmobiliaria(){

        System.out.println("Inserte el tipo de mueble: ");
        String tipo = scanner.nextLine();
        System.out.println("Inserte la dirección de entrega ");
        String direccion = scanner.nextLine();
        System.out.println("Inserte el precio del mueble: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        List<Inmobiliaria> inmobiliarias = inmobiliariaService.findAll();
        Inmobiliaria inmobiliaria = new Inmobiliaria(inmobiliarias.size(), tipo, direccion, precio);

        try {
            inmobiliariaService.save(inmobiliaria);
            System.out.println("Mueble registrado exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void actualizarMuebleRegistrado(){
        System.out.println("Ingrese el id del mueble que desea actualizar");
        int id = scanner.nextInt();
        scanner.nextLine();

        Inmobiliaria inmobiliaria = inmobiliariaService.findById(id);
        if (inmobiliaria == null) {
            System.out.println("No se encontró un mueble con ese id");
            return;
        }

        System.out.println("Ingrese el nuevo tipo de mueble (Deje en blanco si no quiere cambiar): ");
        String tipo = scanner.nextLine();
        if (!tipo.isEmpty()) {
            inmobiliaria.setTipo(tipo);
        }

        System.out.println("Ingrese la nueva direccion para el mueble (Deje en blanco si no quiere cambiar): ");
        String direccion = scanner.nextLine();
        if (!direccion.isEmpty()) {
            inmobiliaria.setDireccion(direccion);
        }

        System.out.println("Ingrese el nuevo precio del mueble: ");
        double precio = scanner.nextDouble();
        inmobiliaria.setPrecioV(precio);

        try {
        inmobiliariaService.update(inmobiliaria);
            System.out.println("Mueble actualizado exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void eliminarMueble(){
        System.out.println("Ingrese el id del mueble que desea eliminar ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Inmobiliaria inmobiliaria = inmobiliariaService.findById(id);
        if (inmobiliaria == null) {
            System.out.println("Mueble no encontrado con el id: " + id);
            return;
        }

        inmobiliariaService.delete(id);
        System.out.println("Mueble eliminado exitosamente");
    }

    private static void consultarMuebles() {
        List<Inmobiliaria> inmobiliarias = inmobiliariaService.findAll();
        if (inmobiliarias.isEmpty()) {
            System.out.println("No hay muebles registrados");
        } else {
            System.out.println("Muebles Registrados: ");
            for (Inmobiliaria inmobiliaria : inmobiliarias) {
                System.out.println(inmobiliaria);
            }
        }
    }
}

