package com.finanzas.cuentas.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.finanzas.cuentas.entiti.Transaccion;
import com.finanzas.cuentas.service.TransaccionServicio;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private TransaccionServicio transaccionServicio;

    @Test
    void ListarTransaccion() {
        List<Transaccion> transacciones = new ArrayList<>();
        transacciones.add(new Transaccion());
        transacciones.add(new Transaccion());
        when(transaccionServicio.listarAllCtransacciones()).thenReturn(transacciones);
       transactionController.ListarTransaccion();
    }

    @Test
    void crearTransaccion() {
        Transaccion transaccion = new Transaccion();
        transaccion.setTipTransaccion(3L);
        transaccion.setOrigen(1L);
        transaccion.setDestino(2L);
        transaccion.setMonto(100.0);
        transaccion.setTipoCuentaOrigen(1L);
        transaccion.setTipoCuentaDestino(2L);

        Transaccion transaccionValida = new Transaccion();
        transaccionValida.setNuevoSaldoOrigen(900.0);
        transaccionValida.setSaldoAnteriorOrigen(1000.0);
        transaccionValida.setTipTransaccion(transaccion.getTipTransaccion());
        transaccionValida.setOrigen(transaccion.getOrigen());
        transaccionValida.setFechaTransaccion(null);
        transaccionValida.setMonto(transaccion.getMonto());
        transaccionValida.setTipoCuentaOrigen(transaccion.getTipoCuentaOrigen());
        when(transaccionServicio.crearTransaccion(transaccion)).thenReturn(transaccionValida);
        transactionController.crearTransaccion(transaccion);
    }
}