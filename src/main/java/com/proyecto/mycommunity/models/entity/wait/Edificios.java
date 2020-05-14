package com.proyecto.mycommunity.models.entity.wait;

public class Edificios {

    private int idEdificio;
    private String nombre;
    private int totalDpto;
    private Condominios idCondomino;

    public Edificios() {
    }

    public Edificios(int idEdificio, String nombre, int totalDpto, Condominios idCondomino) {
        this.idEdificio = idEdificio;
        this.nombre = nombre;
        this.totalDpto = totalDpto;
        this.idCondomino = idCondomino;
    }

    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalDpto() {
        return totalDpto;
    }

    public void setTotalDpto(int totalDpto) {
        this.totalDpto = totalDpto;
    }

	public Condominios getIdCondomino() {
		return idCondomino;
	}

	public void setIdCondomino(Condominios idCondomino) {
		this.idCondomino = idCondomino;
	}
    
    
}
