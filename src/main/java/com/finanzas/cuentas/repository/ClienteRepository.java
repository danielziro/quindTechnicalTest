package com.finanzas.cuentas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finanzas.cuentas.entiti.Cliente;



@Repository
public interface  ClienteRepository extends JpaRepository<Cliente, Long >{
	@Query("SELECT c FROM Cliente c WHERE documento = :documento")
	public Cliente seleteByDocument(long documento );
	

	
}
