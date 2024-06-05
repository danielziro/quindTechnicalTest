package com.finanzas.cuentas.service;

import java.util.List;

import com.finanzas.cuentas.entiti.Transaccion;

public interface TransaccionServicio {
	
	public List<Transaccion> listarAllCtransacciones();
	
	public Transaccion crearTransaccion(Transaccion transaccion);

}
