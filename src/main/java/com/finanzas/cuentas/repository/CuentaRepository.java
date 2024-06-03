package com.finanzas.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.finanzas.cuentas.entiti.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{

}
