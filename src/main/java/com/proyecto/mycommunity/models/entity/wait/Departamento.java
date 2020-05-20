package com.proyecto.mycommunity.models.entity.wait;

public class Departamento {

    private int idDepartamento;
    private String numDepto;
    private double m2;
    private String descripcion;

    public Departamento() {
    }

    public Departamento(int idDepartamento, String numDepto, double m2, String descripcion) {
        this.idDepartamento = idDepartamento;
        this.numDepto = numDepto;
        this.m2 = m2;
        this.descripcion = descripcion;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNumDepto() {
        return numDepto;
    }

    public void setNumDepto(String numDepto) {
        this.numDepto = numDepto;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
