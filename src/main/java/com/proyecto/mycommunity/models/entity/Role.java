package com.proyecto.mycommunity.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"idUsuario", "role"})})
public class Role implements Serializable {

    private static final long serialVErsionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idRol;

    private String role;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
