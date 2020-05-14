package com.proyecto.mycommunity.models.entity.wait;

import java.util.Date;

public class IngresosFondo {

    private int idIngresoFondo;
    private String detalleIngreso;
    private int monto;
    private Date fecha;

    public IngresosFondo() {
    }

    public IngresosFondo(int idIngresoFondo, String detalleIngreso, int monto, Date fecha) {
        this.idIngresoFondo = idIngresoFondo;
        this.detalleIngreso = detalleIngreso;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getIdIngresoFondo() {
        return idIngresoFondo;
    }

    public void setIdIngresoFondo(int idIngresoFondo) {
        this.idIngresoFondo = idIngresoFondo;
    }

    public String getDetalleIngreso() {
        return detalleIngreso;
    }

    public void setDetalleIngreso(String detalleIngreso) {
        this.detalleIngreso = detalleIngreso;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
