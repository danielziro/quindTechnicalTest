package com.finanzas.cuentas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.finanzas.cuentas.entiti.Cliente;
import com.finanzas.cuentas.repository.ClienteRepository;
import com.finanzas.cuentas.repository.CuentaRepository;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImpTest {

	@Mock
    private ClienteRepository clienteRepository;

    @Mock
    private CuentaRepository cuentaRepository;
  

    @InjectMocks
    private ClienteServiciosImp clienteServiciosImp;
    
    
    @Test
    public void listarAllClientes() {

        List<Cliente> clientes = List.of(new Cliente(), new Cliente());
        when(clienteRepository.findAll()).thenReturn(clientes);
        List<Cliente> result = clienteServiciosImp.listarAllClientes();
        assertEquals(clientes, result);
        verify(clienteRepository).findAll();
    }
    
    @Test
   public void createCliente_MayorDeEdad() throws ParseException {
        Cliente cliente = new Cliente();
        cliente.setFechNacimiento("1990-01-01");
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteServiciosImp.createCliente(cliente);

        assertNotNull(result);
        assertEquals(cliente, result);
        verify(clienteRepository).save(cliente);
    }
    
    @Test
   public void ListarCliente() {
        long id = 1L;
        Cliente cliente = new Cliente();
        when(clienteRepository.findById(id)).thenReturn(java.util.Optional.of(cliente));
        Cliente result = clienteServiciosImp.ListarCliente(id);
        assertNotNull(result);
        assertEquals(cliente, result);
        verify(clienteRepository).findById(id);
    }
    
    @Test
    void updateCliente_ClienteFound() {
        // Given
        long id = 1L;
        Cliente cliente = new Cliente();
        cliente.setCorreo("new.correo@example.com");
        Cliente clienteExistente = new Cliente();
        clienteExistente.setId(id);
        clienteExistente.setCorreo("old.correo@example.com");

        when(clienteRepository.findById(id)).thenReturn(Optional.of(clienteExistente));

        // When
       clienteServiciosImp.updateCliente(id, cliente);

        // Then
        verify(clienteRepository).save(clienteExistente);
    }

    @Test
    void deletCliente_ClienteFoundAndNoCuenta() {
        long documento = 1L;
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        when(clienteRepository.seleteByDocument(documento)).thenReturn(cliente);
        when(cuentaRepository.findAllNotCancell(cliente.getId())).thenReturn(null);
        clienteServiciosImp.deletCliente(documento);
        verify(clienteRepository).deleteById(cliente.getId());
    }

}
