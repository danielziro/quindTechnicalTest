package com.finanzas.cuentas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.finanzas.cuentas.entiti.Cuenta;
import com.finanzas.cuentas.repository.CuentaRepository;

@ExtendWith(MockitoExtension.class)
public class CuentaServiciosImpTest {

    @InjectMocks
    private CuentaServiciosImp cuentaServiciosImp;

    @Mock
    private CuentaRepository cuentaRepository;

    @Test
    void listAllCounts() {
        // Configuración de mocks
        List<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(new Cuenta());
        cuentas.add(new Cuenta());

        when(cuentaRepository.findAll()).thenReturn(cuentas);

        // Ejecución del método
        List<Cuenta> cuentasResult = cuentaServiciosImp.listAllCounts();

        // Verificaciones
        assertNotNull(cuentasResult);
        assertEquals(2, cuentasResult.size());
    }

    @Test
    void creaCuenta() {
        // Configuración de mocks
        Cuenta cuenta = new Cuenta();
        cuenta.setTipoCuenta(1L);
        cuenta.setClienteId(1L);

        when(cuentaRepository.save(cuenta)).thenReturn(cuenta);

        // Ejecución del método
        Cuenta cuentaCreada = cuentaServiciosImp.creaCuenta(cuenta);

        // Verificaciones
        assertNotNull(cuentaCreada);
        assertEquals(1L, cuentaCreada.getClienteId());
        assertEquals(1, cuentaCreada.getTipoCuenta());
    }


    @Test
    void ListarCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1L);
        when(cuentaRepository.findById(1L)).thenReturn(Optional.of(cuenta));
        Cuenta cuentaExiste = cuentaServiciosImp.ListarCuenta(1L);
        assertNotNull(cuentaExiste);
        assertEquals(1L, cuentaExiste.getId());
    }

    @Test
    void updateCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1L);
        cuenta.setEstado(1l);
        cuenta.setExentaGMF("Si");

        Cuenta cuentaExistente = new Cuenta();
        cuentaExistente.setId(1L);

        when(cuentaRepository.findById(1L)).thenReturn(Optional.of(cuentaExistente));

        // Ejecución del método
      cuentaServiciosImp.updateCuenta(1L, cuenta);

        // Verificaciones
    }
}
	