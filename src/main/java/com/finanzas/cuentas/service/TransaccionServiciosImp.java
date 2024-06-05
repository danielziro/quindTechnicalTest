package com.finanzas.cuentas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.cuentas.entiti.Cuenta;
import com.finanzas.cuentas.entiti.Transaccion;
import com.finanzas.cuentas.repository.CuentaRepository;
import com.finanzas.cuentas.repository.TransaccionRepository;

@Service
public class TransaccionServiciosImp implements TransaccionServicio{

    @Autowired
    private TransaccionRepository transaccionRepository;
    
    @Autowired
    private CuentaRepository cuentaRepository;
    

	@Override
	public Transaccion crearTransaccion(Transaccion transaccion) {
		Transaccion transaccionValida = new Transaccion();
		LocalDateTime horaModCuenta= LocalDateTime.now();
		Cuenta cuentaOrigenActualizar =  new Cuenta();
		
		Cuenta cuentaOrigen = cuentaRepository.findAllNotCancell(transaccion.getOrigen());
		if(transaccion.getTipTransaccion() == 3) {
			
		if(cuentaOrigen.getEstado() != 3 || cuentaOrigen.getEstado()!= 2) {
			
			cuentaOrigenActualizar.setSaldo(cuentaOrigen.getSaldo() - transaccion.getMonto());
			cuentaOrigenActualizar.setId(cuentaOrigen.getId());
			cuentaOrigenActualizar.setFechModificacion(horaModCuenta);
			cuentaOrigenActualizar.setExentaGMF(cuentaOrigen.getExentaGMF());
			cuentaOrigenActualizar.setEstado(cuentaOrigen.getEstado());
			cuentaOrigenActualizar.setNumeroCuenta(cuentaOrigen.getNumeroCuenta());
			cuentaOrigenActualizar.setClienteId(cuentaOrigen.getClienteId());
			cuentaOrigenActualizar.setFechCreacion(cuentaOrigen.getFechCreacion());
			cuentaOrigenActualizar.setTipoCuenta(cuentaOrigen.getTipoCuenta());
			transaccionValida.setNuevoSaldoOrigen(cuentaOrigenActualizar.getSaldo());
			transaccionValida.setSaldoAnteriorOrigen(cuentaOrigen.getSaldo());
			transaccionValida.setTipTransaccion(transaccion.getTipTransaccion());
			transaccionValida.setOrigen(transaccion.getOrigen());
			transaccionValida.setFechaTransaccion(horaModCuenta);
			transaccionValida.setMonto(transaccion.getMonto());
			transaccionValida.setTipoCuentaOrigen(transaccion.getTipoCuentaOrigen());
			cuentaRepository.save(cuentaOrigenActualizar);
		}else {
			System.out.println("La transacción no es efectiva la Cuenta Origen no esta activa o fue cancelada");
		}
		
		Cuenta cuentaDestino = cuentaRepository.findAllNotCancell(transaccion.getDestino());
		Cuenta cuentaDestinoActualizar = new Cuenta();
		if(cuentaDestino.getEstado() != 3 || cuentaDestino.getEstado()!= 2) {	
			cuentaDestinoActualizar.setSaldo(cuentaDestino.getSaldo() + transaccion.getMonto());
			cuentaDestinoActualizar.setFechModificacion(horaModCuenta);
			cuentaDestinoActualizar.setId(cuentaDestino.getId());
			cuentaDestinoActualizar.setExentaGMF(cuentaDestino.getExentaGMF());
			cuentaDestinoActualizar.setEstado(cuentaDestino.getEstado());
			cuentaDestinoActualizar.setNumeroCuenta(cuentaDestino.getNumeroCuenta());
			cuentaDestinoActualizar.setClienteId(cuentaDestino.getClienteId());
			cuentaDestinoActualizar.setFechCreacion(cuentaDestino.getFechCreacion());
			cuentaDestinoActualizar.setTipoCuenta(cuentaDestino.getTipoCuenta());
			transaccionValida.setDestino(transaccion.getDestino());
			transaccionValida.setTipoCuentaDestino(cuentaDestino.getTipoCuenta());
			transaccionValida.setNuevoSaldoDestino(cuentaDestinoActualizar.getSaldo());
			transaccionValida.setSaldoAnteriorDestino(cuentaDestino.getSaldo());
			cuentaRepository.save(cuentaDestinoActualizar);
		}else {
			System.out.println("La transacción no es efectiva la Cuenta Origen no esta activa o fue cancelada");
		}
		}else if(transaccion.getTipTransaccion() == 1) {
			
			if(cuentaOrigen.getEstado() != 3 || cuentaOrigen.getEstado()!= 2) {
				
				cuentaOrigenActualizar.setSaldo(cuentaOrigen.getSaldo() + transaccion.getMonto());
				cuentaOrigenActualizar.setId(cuentaOrigen.getId());
				cuentaOrigenActualizar.setFechModificacion(horaModCuenta);
				cuentaOrigenActualizar.setExentaGMF(cuentaOrigen.getExentaGMF());
				cuentaOrigenActualizar.setEstado(cuentaOrigen.getEstado());
				cuentaOrigenActualizar.setFechCreacion(cuentaOrigen.getFechCreacion());
				cuentaOrigenActualizar.setNumeroCuenta(cuentaOrigen.getNumeroCuenta());
				cuentaOrigenActualizar.setClienteId(cuentaOrigen.getClienteId());
				cuentaOrigenActualizar.setTipoCuenta(cuentaOrigen.getTipoCuenta());
				transaccionValida.setNuevoSaldoOrigen(cuentaOrigenActualizar.getSaldo());
				transaccionValida.setSaldoAnteriorOrigen(cuentaOrigen.getSaldo());
				transaccionValida.setTipTransaccion(transaccion.getTipTransaccion());
				transaccionValida.setOrigen(transaccion.getOrigen());
				transaccionValida.setFechaTransaccion(horaModCuenta);
				transaccionValida.setMonto(transaccion.getMonto());
				transaccionValida.setTipoCuentaOrigen(transaccion.getTipoCuentaOrigen());
				cuentaRepository.save(cuentaOrigenActualizar);
			}
		}else if(transaccion.getTipTransaccion() == 2) {
			if(cuentaOrigen.getEstado() != 3 || cuentaOrigen.getEstado()!= 2) {
				cuentaOrigenActualizar.setSaldo(cuentaOrigen.getSaldo() - transaccion.getMonto());
				cuentaOrigenActualizar.setId(cuentaOrigen.getId());
				cuentaOrigenActualizar.setFechModificacion(horaModCuenta);
				cuentaOrigenActualizar.setExentaGMF(cuentaOrigen.getExentaGMF());
				cuentaOrigenActualizar.setEstado(cuentaOrigen.getEstado());
				cuentaOrigenActualizar.setNumeroCuenta(cuentaOrigen.getNumeroCuenta());
				cuentaOrigenActualizar.setClienteId(cuentaOrigen.getClienteId());
				cuentaOrigenActualizar.setFechCreacion(cuentaOrigen.getFechCreacion());
				cuentaOrigenActualizar.setTipoCuenta(cuentaOrigen.getTipoCuenta());
				transaccionValida.setNuevoSaldoOrigen(cuentaOrigenActualizar.getSaldo());
				transaccionValida.setSaldoAnteriorOrigen(cuentaOrigen.getSaldo());
				transaccionValida.setTipTransaccion(transaccion.getTipTransaccion());
				transaccionValida.setOrigen(transaccion.getOrigen());
				transaccionValida.setFechaTransaccion(horaModCuenta);
				transaccionValida.setMonto(transaccion.getMonto());
				transaccionValida.setTipoCuentaOrigen(transaccion.getTipoCuentaOrigen());
				cuentaRepository.save(cuentaOrigenActualizar);
			}
		}
		;
		return transaccionRepository.save(transaccionValida);
		
	}

	

	@Override
	public List<Transaccion> listarAllCtransacciones() {
		
		return transaccionRepository.findAll();
	}

}
