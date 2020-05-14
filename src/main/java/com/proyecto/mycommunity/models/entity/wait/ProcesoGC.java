package com.proyecto.mycommunity.models.entity.wait;

public class ProcesoGC {

    private int idProcesoGC;
    private String estado;
    private int monto;

    public ProcesoGC() {
    }

    public ProcesoGC(int idProcesoGC, String estado, int monto) {
        this.idProcesoGC = idProcesoGC;
        this.estado = estado;
        this.monto = monto;
    }

    public int getIdProcesoGC() {
        return idProcesoGC;
    }

    public void setIdProcesoGC(int idProcesoGC) {
        this.idProcesoGC = idProcesoGC;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
