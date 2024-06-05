package com.finanzas.cuentas.entiti;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	@Id	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="documento",nullable=false,unique = true)
	private Long documento;
	
	@Column(name="tipoDocumento",nullable=false)
	private Long tipoDocumento;
	
	@Column(name="nombres",nullable=false)
	private String nombres;
	
	@Column(name="apellidos",nullable=false)
	private String apellido;
	
	@Column(name="correo",nullable=false)
	private String correo;
	
	@Column(name="fechNacimiento",nullable=false)
	private String fechNacimiento;
	
	@Column(name="fechCreacion",nullable=false)
	private LocalDateTime fechCreacion;
	
	@Column(name="fechModificacion",nullable=false)
	private LocalDateTime fechModificacion;
	
	public Cliente() {
		
	}

	public Cliente(Long id, Long documento, Long tipoDocumento, String nombres, String apellido, String correo,
			String fechNacimiento, LocalDateTime fechCreacion, LocalDateTime fechModificacion) {
		super();
		this.id = id;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.nombres = nombres;
		this.apellido = apellido;
		this.correo = correo;
		this.fechNacimiento = fechNacimiento;
		this.fechCreacion = fechCreacion;
		this.fechModificacion = fechModificacion;
	}
	
	public Cliente(Long documento, Long tipoDocumento, String nombres, String apellido, String correo,
			String fechNacimiento, LocalDateTime fechCreacion, LocalDateTime fechModificacion) {
		super();
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.nombres = nombres;
		this.apellido = apellido;
		this.correo = correo;
		this.fechNacimiento = fechNacimiento;
		this.fechCreacion = fechCreacion;
		this.fechModificacion = fechModificacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public Long getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechNacimiento() {
		return fechNacimiento;
	}

	public void setFechNacimiento(String fechNacimiento) {
		this.fechNacimiento = fechNacimiento;
	}

	public LocalDateTime getFechCreacion() {
		return fechCreacion;
	}

	public void setFechCreacion(LocalDateTime fechCreacion) {
		this.fechCreacion = fechCreacion;
	}

	public LocalDateTime getFechModificacion() {
		return fechModificacion;
	}

	public void setFechModificacion(LocalDateTime fechModificacion) {
		this.fechModificacion = fechModificacion;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", documento=" + documento + ", tipoDocumento=" + tipoDocumento + ", nombres="
				+ nombres + ", apellido=" + apellido + ", correo=" + correo + ", fechNacimiento=" + fechNacimiento
				+ ", fechCreacion=" + fechCreacion + ", fechModificación=" + fechModificacion + "]";
	}


}
