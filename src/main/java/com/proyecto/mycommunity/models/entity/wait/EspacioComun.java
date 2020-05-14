package com.proyecto.mycommunity.models.entity.wait;

public class EspacioComun {

    private int idEspacioComun;
    private String nombre;
    private String descripcion;

    public EspacioComun() {
    }

    public EspacioComun(int idEspacioComun, String nombre, String descripcion) {
        this.idEspacioComun = idEspacioComun;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdEspacioComun() {
        return idEspacioComun;
    }

    public void setIdEspacioComun(int idEspacioComun) {
        this.idEspacioComun = idEspacioComun;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
