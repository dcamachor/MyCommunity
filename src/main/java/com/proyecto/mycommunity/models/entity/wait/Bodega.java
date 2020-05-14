package com.proyecto.mycommunity.models.entity.wait;

public class Bodega {

    private int idBodega;
    private String nBodega;
    private float m2;
    private String descripcion;

    public Bodega() {
    }

    public Bodega(int idBodega, String nBodega, float m2, String descripcion) {
        this.idBodega = idBodega;
        this.nBodega = nBodega;
        this.m2 = m2;
        this.descripcion = descripcion;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    public String getnBodega() {
        return nBodega;
    }

    public void setnBodega(String nBodega) {
        this.nBodega = nBodega;
    }

    public float getM2() {
        return m2;
    }

    public void setM2(float m2) {
        this.m2 = m2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
