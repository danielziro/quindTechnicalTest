package com.finanzas.cuentas.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finanzas.cuentas.entiti.Cliente;
import com.finanzas.cuentas.entiti.Cuenta;
import com.finanzas.cuentas.repository.ClienteRepository;
import com.finanzas.cuentas.repository.CuentaRepository;

@Service
public class ClienteServiciosImp implements ClienteServicio{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Override
	public List<Cliente> listarAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente createCliente(Cliente cliente) throws ParseException {
		LocalDateTime ahora = LocalDateTime.now();
		cliente.setFechModificacion(ahora);
		cliente.setFechCreacion(ahora);
		
		 
		LocalDate fechaNacimiento = LocalDate.parse(cliente.getFechNacimiento());
		
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, fechaActual);
		int edad = periodo.getYears();
		if(edad <= 17){
			System.out.println("No es mayor de edad");
		}else if(edad >=18){
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String fechaString = formatter.format(fechaNacimiento);
		
			cliente.setFechNacimiento(fechaString);
			cliente = clienteRepository.save(cliente);
		}
		
		
		return cliente;
	}

	@Override
	public Cliente ListarCliente(long id) {
	   return clienteRepository.findById(id).get();
	}

	@Override
	public Cliente updateCliente(long id , Cliente cliente) {
		Cliente clienteReturn = new Cliente();
		 Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		 Cliente clienteExistente = optionalCliente.get();
		 if (optionalCliente.isPresent()) {
			
		        LocalDateTime ahora = LocalDateTime.now();
		        clienteExistente.setCorreo(cliente.getCorreo());
		        clienteExistente.setFechModificacion(ahora);
		        clienteReturn = clienteRepository.save(clienteExistente);
		 }else {
		        System.err.println("El cliente por id no funciona");
		    }
		return clienteReturn;
		
	
	}

	@Override
	public void deletCliente(long documento) {
		
		Cliente cliente=clienteRepository.seleteByDocument(documento);
		Cuenta cuenta=cuentaRepository.findAllNotCancell(cliente.getId());
		if(cuenta==null) {
			clienteRepository.deleteById(cliente.getId());
		}else {
			System.err.println("Se encontro una cuenta asosiada");
		}
		
	}
	
}
