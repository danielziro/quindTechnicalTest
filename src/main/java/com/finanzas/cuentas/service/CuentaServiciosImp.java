package com.finanzas.cuentas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.cuentas.entiti.Cuenta;
import com.finanzas.cuentas.repository.CuentaRepository;

@Service
public class CuentaServiciosImp implements CuentaServicio{

	@Autowired
	private CuentaRepository cuentaRepository;
	
	
	
	@Override
	public List<Cuenta> listAllCounts() {
		List<Cuenta> listaCuenta = cuentaRepository.findAll();
		return listaCuenta;
	}
	
	@Override
	public Cuenta creaCuenta(Cuenta cuenta) {
		Cuenta cuentaCreada = new Cuenta();
		String cuentaN = new String();
		
			Long nCuenta= (long) (Math.random() * 90000);
			if(cuenta.getTipoCuenta()==1) {
				cuentaN = "53000";
			}else if(cuenta.getTipoCuenta()==2) {
				cuentaN ="33000";
			}
			

			String numbAcount= cuentaN;
			long numeroCuenta = Long.parseLong(numbAcount);
			
			if(cuenta.getClienteId()!=0||cuenta.getClienteId()!=null) {
				LocalDateTime horaCreacion = LocalDateTime.now();
				cuenta.setFechCreacion(horaCreacion);
				cuenta.setFechModificacion(horaCreacion);
				cuenta.setNumeroCuenta(numeroCuenta+nCuenta);
				cuentaCreada = cuentaRepository.save(cuenta);
			}else {
				throw new RuntimeException("Error la cuenta 0 y no es valida");
			};
			
		return cuentaCreada;
	}
	
	@Override
	public Cuenta ListarCuenta(long id) {
		Cuenta cuentaExiste = cuentaRepository.findById(id).get();
		return cuentaExiste;
	}

	@Override
	public Cuenta updateCuenta(long id, Cuenta cuenta) {
		Cuenta cuentaExistente = ListarCuenta(id);
		LocalDateTime ahoraActualizacion = LocalDateTime.now();
		cuentaExistente.setEstado(cuenta.getEstado());
		cuentaExistente.setExentaGMF(cuenta.getExentaGMF());
		cuentaExistente.setFechModificacion(ahoraActualizacion);
		return cuentaRepository.save(cuentaExistente);
	}

	
	@Override
	public void deleteCuenta(long id) {
		
		
	}

	

	

}
