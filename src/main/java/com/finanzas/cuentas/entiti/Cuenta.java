package com.finanzas.cuentas.entiti;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cuenta")
public class Cuenta {
	@Id	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipoCuenta",nullable=false)
	private Long tipoCuenta;
	
	@Column(name="numeroCuenta",nullable=false,unique = true)
	private Long numeroCuenta;
	
	@Column(name="estado",nullable=false)
	private Long estado;
	
	@Column(name="saldo",nullable=false)
	private double saldo;
	
	@Column(name="exentaGMF",nullable=false)
	private String exentaGMF;
	
	@Column(name="fechCreacion",nullable=false)
	private LocalDateTime fechCreacion;
	
	@Column(name="fechModificacion",nullable=false)
	private LocalDateTime fechModificacion;
	
	@Column(name="ClienteId",nullable=false)
	private Long ClienteId;
	
	public Cuenta() {
		
	}

	public Cuenta(Long id, Long tipoCuenta, Long numeroCuenta, Long estado, double saldo, String exentaGMF,
			LocalDateTime fechCreacion, LocalDateTime fechModificacion, Long clienteId) {
		super();
		this.id = id;
		this.tipoCuenta = tipoCuenta;
		this.numeroCuenta = numeroCuenta;
		this.estado = estado;
		this.saldo = saldo;
		this.exentaGMF = exentaGMF;
		this.fechCreacion = fechCreacion;
		this.fechModificacion = fechModificacion;
		this.ClienteId = clienteId;
	}
	
	public Cuenta( Long tipoCuenta, Long numeroCuenta, Long estado, double saldo, String exentaGMF,
			LocalDateTime fechCreacion, LocalDateTime fechModificacion, Long clienteId) {
		super();
		this.tipoCuenta = tipoCuenta;
		this.numeroCuenta = numeroCuenta;
		this.estado = estado;
		this.saldo = saldo;
		this.exentaGMF = exentaGMF;
		this.fechCreacion = fechCreacion;
		this.fechModificacion = fechModificacion;
		this.ClienteId = clienteId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(Long tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getExentaGMF() {
		return exentaGMF;
	}

	public void setExentaGMF(String exentaGMF) {
		this.exentaGMF = exentaGMF;
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

	public Long getClienteId() {
		return ClienteId;
	}

	public void setClienteId(Long clienteId) {
		this.ClienteId = clienteId;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", tipoCuenta=" + tipoCuenta + ", numeroCuenta=" + numeroCuenta + ", estado="
				+ estado + ", saldo=" + saldo + ", exentaGMF=" + exentaGMF + ", fechCreacion=" + fechCreacion
				+ ", fechModificacion=" + fechModificacion + ", ClienteId=" + ClienteId + "]";
	}
	
	
}
