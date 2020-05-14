package com.proyecto.mycommunity.models.entity;

import java.util.Date;

public class Usuario extends Persona {

    private int idUsuario;
    private String contraseña;
    private String estado;
    private Date fechaCreacion;
    private String imagen;
    private Persona rut;

    public Usuario() {
    }


}
