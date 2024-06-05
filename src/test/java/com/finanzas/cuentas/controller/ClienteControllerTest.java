package com.finanzas.cuentas.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.finanzas.cuentas.entiti.Cliente;
import com.finanzas.cuentas.service.ClienteServicio;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteServicio clienteService;

    @Test
    void ListarClientes() {
  
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente());
        clientes.add(new Cliente());
        when(clienteService.listarAllClientes()).thenReturn(clientes);
        clienteController.ListarClientes();

    
       
    }

    @Test
    void createCliente() throws ParseException {
        Cliente cliente = new Cliente();
        cliente.setNombres("Juan");
        cliente.setApellido("Pérez");

        when(clienteService.createCliente(cliente)).thenReturn(cliente);

  
        clienteController.createCliente(cliente);

    }

    @Test
    void UpdateClient() {
        long id = 1L;
        Cliente cliente = new Cliente();
        cliente.setNombres("Juan");
        cliente.setApellido("Pérez");
        when(clienteService.updateCliente(id, cliente)).thenReturn(cliente);
        clienteController.UpdateClient(id, cliente);
       
    }

    @Test
    void DeleteClient() {
        long documento = 1L;
        clienteController.DeleteClient(documento);
    }
}