package com.finanzas.cuentas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.finanzas.cuentas.entiti.Cuenta;
import com.finanzas.cuentas.entiti.Transaccion;
import com.finanzas.cuentas.repository.CuentaRepository;
import com.finanzas.cuentas.repository.TransaccionRepository;


@ExtendWith(MockitoExtension.class)
class TransaccionServiciosImpTest {

	@InjectMocks
    private TransaccionServiciosImp transaccionServiciosImp;

    @Mock
    private TransaccionRepository transaccionRepository;

    @Mock
    private CuentaRepository cuentaRepository;

    @Test
    void crearTransaccion() {
        // Configuración de mocks
        Transaccion transaccion = new Transaccion();
        transaccion.setTipTransaccion(3L);
        transaccion.setOrigen(1L);
        transaccion.setDestino(2L);
        transaccion.setMonto(100.0);
        transaccion.setTipoCuentaOrigen(1L);
        transaccion.setTipoCuentaDestino(2L);

        Cuenta cuentaOrigen = new Cuenta();
        cuentaOrigen.setId(1L);
        cuentaOrigen.setSaldo(1000.0);
        cuentaOrigen.setEstado(1L);

        Cuenta cuentaDestino = new Cuenta();
        cuentaDestino.setId(2L);
        cuentaDestino.setSaldo(500.0);
        cuentaDestino.setEstado(1L);

        when(cuentaRepository.findAllNotCancell(1L)).thenReturn(cuentaOrigen);
        when(cuentaRepository.findAllNotCancell(2L)).thenReturn(cuentaDestino);

 
        transaccionServiciosImp.crearTransaccion(transaccion);
    }

    @Test
    void listarAllCtransacciones() {
        // Configuración de mocks
        List<Transaccion> transacciones = new ArrayList<>();
        transacciones.add(new Transaccion());
        transacciones.add(new Transaccion());

        when(transaccionRepository.findAll()).thenReturn(transacciones);

        // Ejecución del método
        List<Transaccion> transaccionesResult = transaccionServiciosImp.listarAllCtransacciones();

        // Verificaciones
        assertNotNull(transaccionesResult);
        assertEquals(2, transaccionesResult.size());
    }
}
