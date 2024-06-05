package com.finanzas.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finanzas.cuentas.entiti.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long>{

	
}
