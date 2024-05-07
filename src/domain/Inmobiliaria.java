package domain;

import java.io.Serializable;

public class Inmobiliaria implements Serializable {
    private int id;
    private String tipo;
    private String direccion;
    private double precioV;

    public Inmobiliaria(int id, String tipo, String direccion, double precioV) {
        this.id = id;
        this.tipo = tipo;
        this.direccion = direccion;
        this.precioV = precioV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double precioV) {
        this.precioV = precioV;
    }

    @Override
    public String toString() {
        return "Inmobiliaria{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", precioV=" + precioV +
                '}';
    }
}
