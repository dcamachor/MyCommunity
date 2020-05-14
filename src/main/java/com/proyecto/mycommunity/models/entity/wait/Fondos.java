package com.proyecto.mycommunity.models.entity.wait;

public class Fondos {

    private int idFondos;
    private int fondo;
    private String detalles;

    public Fondos() {
    }

    public Fondos(int idFondos, int fondo, String detalles) {
        this.idFondos = idFondos;
        this.fondo = fondo;
        this.detalles = detalles;
    }

    public int getIdFondos() {
        return idFondos;
    }

    public void setIdFondos(int idFondos) {
        this.idFondos = idFondos;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
