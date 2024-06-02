package com.finanzas.cuentas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finanzas.cuentas.entiti.Cliente;

@Repository
public interface  ClienteRepository extends JpaRepository<Cliente, Long>{

	
	
}
