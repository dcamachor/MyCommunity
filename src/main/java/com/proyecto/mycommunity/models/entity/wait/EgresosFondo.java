package com.proyecto.mycommunity.models.entity.wait;

import java.util.Date;

public class EgresosFondo {

    private int idEgresoFondo;
    private String detalleEgreso;
    private int monto;
    private Date fecha;

    public EgresosFondo() {
    }

    public EgresosFondo(int idEgresoFondo, String detalleEgreso, int monto, Date fecha) {
        this.idEgresoFondo = idEgresoFondo;
        this.detalleEgreso = detalleEgreso;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getIdEgresoFondo() {
        return idEgresoFondo;
    }

    public void setIdEgresoFondo(int idEgresoFondo) {
        this.idEgresoFondo = idEgresoFondo;
    }

    public String getDetalleEgreso() {
        return detalleEgreso;
    }

    public void setDetalleEgreso(String detalleEgreso) {
        this.detalleEgreso = detalleEgreso;
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
