package com.finanzas.cuentas.service;

import java.util.List;

import com.finanzas.cuentas.entiti.Cuenta;

public interface CuentaServicio {
	
	public List<Cuenta> listAllCounts();
	
	public Cuenta creaCuenta(Cuenta cuenta);
	
	public Cuenta ListarCuenta(long id);
	
	public Cuenta updateCuenta(long id, Cuenta cuenta);
	
	public void deleteCuenta(long id);
	
	

}
