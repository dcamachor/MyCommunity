package com.proyecto.mycommunity.models.entity.wait;

import java.util.Date;

public class GastoComun {

    private int idGastoComun;
    private Date fecha;
    private String descripcion;

    public GastoComun() {
    }

    public GastoComun(int idGastoComun, Date fecha, String descripcion) {
        this.idGastoComun = idGastoComun;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getIdGastoComun() {
        return idGastoComun;
    }

    public void setIdGastoComun(int idGastoComun) {
        this.idGastoComun = idGastoComun;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
