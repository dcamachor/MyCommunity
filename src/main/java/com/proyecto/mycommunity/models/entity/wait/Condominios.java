package com.proyecto.mycommunity.models.entity.wait;

public class Condominios {

    private int idCondominio;
    private String nombreCondominio;
    private int run;
    private String email;
    private int telefono;
    private AdmComunidad admcomunidad;

    public Condominios() {
    }

    public Condominios(int idCondominio, String nombreCondominio, int run, String email, int telefono) {
        this.idCondominio = idCondominio;
        this.nombreCondominio = nombreCondominio;
        this.run = run;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdCondominio() {
        return idCondominio;
    }

    public void setIdCondominio(int idCondominio) {
        this.idCondominio = idCondominio;
    }

    public String getNombreCondominio() {
        return nombreCondominio;
    }

    public void setNombreCondominio(String nombreCondominio) {
        this.nombreCondominio = nombreCondominio;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

	public AdmComunidad getAdmcomunidad() {
		return admcomunidad;
	}

	public void setAdmcomunidad(AdmComunidad admcomunidad) {
		this.admcomunidad = admcomunidad;
	}
    
    
}
