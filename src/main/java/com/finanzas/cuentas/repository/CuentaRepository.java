package com.finanzas.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.finanzas.cuentas.entiti.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
	
	@Query("SELECT c FROM Cuenta c WHERE c.ClienteId = :id and c.estado <> 3")
	public Cuenta findAllNotCancell(long id);
;
}
