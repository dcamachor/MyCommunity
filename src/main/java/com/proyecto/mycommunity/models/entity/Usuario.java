package com.proyecto.mycommunity.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario /*extends Persona*/ implements Serializable {

    private static final long serialVErsionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int idUsuario;

    @Column(unique = true)
    private String password;

    private boolean estado;
    private Date fechaCreacion;
    private String imagen;

    @Column(unique = true)
    @JoinColumn(name = "rut")
    private int rut;

   /* @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rut")
    private Persona persona;
*/
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private List<Role> roles;

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public int getRut() {
        return rut;
    }
    public void setRut(int rut) {
        this.rut = rut;
    }

    /*  public Persona getPersona() {
            return persona;
        }

        public void setPersona(Persona persona) {
            this.persona = persona;
        }
    */
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
