package com.finanzas.cuentas.entiti;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movimientos")
public class Transaccion {

	@Id	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipTransaccion",nullable=false)
	private Long tipTransaccion;
	

	@Column(name="origen",nullable=false)
	private Long origen;
	
	@Column(name="tipoCuentaOrigen",nullable=false)
	private Long tipoCuentaOrigen;
	
	
	@Column(name="destino")
	private Long destino;
	
	@Column(name="tipoCuentaDestino")
	private Long tipoCuentaDestino;
	
	
	@Column(name="monto")
	private double monto;
	
	@Column(name="saldoAnteriorOrigen")
	private double saldoAnteriorOrigen;
	
	@Column(name="saldoAnteriorDestino")
	private double saldoAnteriorDestino;
	
	@Column(name="NuevoSaldoOrigen")
	private double NuevoSaldoOrigen;
	
	@Column(name="NuevoSaldoDestino")
	private double NuevoSaldoDestino;
	
	@Column(name="fechaTransaccion")
	private LocalDateTime fechaTransaccion;
	
	public Transaccion() {
		
	}

	public Transaccion(Long id, Long tipTransaccion, Long origen, Long tipoCuentaOrigen, Long destino,
			Long tipoCuentaDestino, double monto, double saldoAnteriorOrigen, double saldoAnteriorDestino,
			double nuevoSaldoOrigen, double nuevoSaldoDestino, LocalDateTime fechaTransaccion) {
		super();
		this.id = id;
		this.tipTransaccion = tipTransaccion;
		this.origen = origen;
		this.tipoCuentaOrigen = tipoCuentaOrigen;
		this.destino = destino;
		this.tipoCuentaDestino = tipoCuentaDestino;
		this.monto = monto;
		this.saldoAnteriorOrigen = saldoAnteriorOrigen;
		this.saldoAnteriorDestino = saldoAnteriorDestino;
		NuevoSaldoOrigen = nuevoSaldoOrigen;
		NuevoSaldoDestino = nuevoSaldoDestino;
		this.fechaTransaccion = fechaTransaccion;
	}

	public Transaccion( Long tipTransaccion, Long origen, Long tipoCuentaOrigen, Long destino,
			Long tipoCuentaDestino, double monto, double saldoAnteriorOrigen, double saldoAnteriorDestino,
			double nuevoSaldoOrigen, double nuevoSaldoDestino, LocalDateTime fechaTransaccion) {
		super();
		this.tipTransaccion = tipTransaccion;
		this.origen = origen;
		this.tipoCuentaOrigen = tipoCuentaOrigen;
		this.destino = destino;
		this.tipoCuentaDestino = tipoCuentaDestino;
		this.monto = monto;
		this.saldoAnteriorOrigen = saldoAnteriorOrigen;
		this.saldoAnteriorDestino = saldoAnteriorDestino;
		this.NuevoSaldoOrigen = nuevoSaldoOrigen;
		this.NuevoSaldoDestino = nuevoSaldoDestino;
		this.fechaTransaccion = fechaTransaccion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTipTransaccion() {
		return tipTransaccion;
	}

	public void setTipTransaccion(Long tipTransaccion) {
		this.tipTransaccion = tipTransaccion;
	}

	public Long getOrigen() {
		return origen;
	}

	public void setOrigen(Long origen) {
		this.origen = origen;
	}

	public Long getTipoCuentaOrigen() {
		return tipoCuentaOrigen;
	}

	public void setTipoCuentaOrigen(Long tipoCuentaOrigen) {
		this.tipoCuentaOrigen = tipoCuentaOrigen;
	}

	public Long getDestino() {
		return destino;
	}

	public void setDestino(Long destino) {
		this.destino = destino;
	}

	public Long getTipoCuentaDestino() {
		return tipoCuentaDestino;
	}

	public void setTipoCuentaDestino(Long tipoCuentaDestino) {
		this.tipoCuentaDestino = tipoCuentaDestino;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getSaldoAnteriorOrigen() {
		return saldoAnteriorOrigen;
	}

	public void setSaldoAnteriorOrigen(double saldoAnteriorOrigen) {
		this.saldoAnteriorOrigen = saldoAnteriorOrigen;
	}

	public double getSaldoAnteriorDestino() {
		return saldoAnteriorDestino;
	}

	public void setSaldoAnteriorDestino(double saldoAnteriorDestino) {
		this.saldoAnteriorDestino = saldoAnteriorDestino;
	}

	public double getNuevoSaldoOrigen() {
		return NuevoSaldoOrigen;
	}

	public void setNuevoSaldoOrigen(double nuevoSaldoOrigen) {
		NuevoSaldoOrigen = nuevoSaldoOrigen;
	}

	public double getNuevoSaldoDestino() {
		return NuevoSaldoDestino;
	}

	public void setNuevoSaldoDestino(double nuevoSaldoDestino) {
		NuevoSaldoDestino = nuevoSaldoDestino;
	}

	public LocalDateTime getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDateTime fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", tipTransaccion=" + tipTransaccion + ", origen=" + origen
				+ ", tipoCuentaOrigen=" + tipoCuentaOrigen + ", destino=" + destino + ", tipoCuentaDestino="
				+ tipoCuentaDestino + ", monto=" + monto + ", saldoAnteriorOrigen=" + saldoAnteriorOrigen
				+ ", saldoAnteriorDestino=" + saldoAnteriorDestino + ", NuevoSaldoOrigen=" + NuevoSaldoOrigen
				+ ", NuevoSaldoDestino=" + NuevoSaldoDestino + ", fechaTransaccion=" + fechaTransaccion + "]";
	}
	

	
	
}
