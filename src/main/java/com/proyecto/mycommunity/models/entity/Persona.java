package com.proyecto.mycommunity.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {

	@Id
	private int rut;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotNull
	private int telefono;
	@NotEmpty
	@Email
	private String email;
	@NotNull
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date createAt;
	//@NotEmpty
	//private Direccion idDireccion;

	@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Factura> facturas;

	private static final long serialVersionUID = 1L;

	public Persona() {
		facturas = new ArrayList<Factura>();
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	/*public Direccion getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Direccion idDireccion) {
		this.idDireccion = idDireccion;
	}*/

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
