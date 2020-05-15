package com.proyecto.mycommunity.models.entity.wait;

import com.proyecto.mycommunity.models.entity.Usuario;

public class AdmComunidad {

    private int idAdmComunidad;
    private String estado;
    private Usuario idUsuario;
    private PersonalServicio idPersonaServicio;


    public AdmComunidad() {
    }

    public AdmComunidad(int idAdmComunidad, String estado, Usuario idUsuario, PersonalServicio idPersonaServicio) {
        this.idAdmComunidad = idAdmComunidad;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.idPersonaServicio = idPersonaServicio;
    }

    public int getIdAdmComunidad() {
        return idAdmComunidad;
    }

    public void setIdAdmComunidad(int idAdmComunidad) {
        this.idAdmComunidad = idAdmComunidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public PersonalServicio getIdPersonaServicio() {
        return idPersonaServicio;
    }

    public void setIdPersonaServicio(PersonalServicio idPersonaServicio) {
        this.idPersonaServicio = idPersonaServicio;
    }
}
