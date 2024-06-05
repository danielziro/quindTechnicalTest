package com.finanzas.cuentas.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.finanzas.cuentas.entiti.Cuenta;
import com.finanzas.cuentas.service.CuentaServicio;

@ExtendWith(MockitoExtension.class)
public class CuentaControllerTest {

    @InjectMocks
    private CuentaController cuentaController;

    @Mock
    private CuentaServicio cuentaServicio;

    @Test
    void listCuentas() {
        List<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(new Cuenta());
        cuentas.add(new Cuenta());
        when(cuentaServicio.listAllCounts()).thenReturn(cuentas);
        cuentaController.listCuentas();
    }

    @Test
    void createCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(123456789L);
        cuenta.setTipoCuenta(1L);

        when(cuentaServicio.creaCuenta(cuenta)).thenReturn(cuenta);
       cuentaController.createCuenta(cuenta);
    }

    @Test
    void UpdateCuenta() {
        long id = 1L;
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(123456789L);
        cuenta.setTipoCuenta(1L);
        when(cuentaServicio.updateCuenta(id, cuenta)).thenReturn(cuenta);
        cuentaController.UpdateClient(id, cuenta);
        
    }
}