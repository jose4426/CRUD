package com.example.Empleado.serv.impl;

import com.example.Empleado.dto.response.EmpleadoResponse;
import com.example.Empleado.entity.Empleado;
import com.example.Empleado.mapper.EmpleadoMapper;
import com.example.Empleado.repository.EmpaledoRepository;
import com.example.Empleado.serv.EmpleadoServ;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoServImplTest {

    @InjectMocks
    private EmpleadoServImpl empleadoServImpl;
    @Mock
    private EmpleadoServ empleadoServ;
    private List<EmpleadoResponse> empleados = new ArrayList<>();


    private EmpaledoRepository empaledoRepository;
    private EmpleadoMapper empleadoMapper;
  /*  @Test
    void empledosFindAll() throws Exception {
        Mockito.when(this.empaledoRepository.findAll())
                .thenReturn();
        this.empleados = this.empleadoServ.empledosFindAll();
        assertNotNull(empleados);*/



    @Test
    void inserEmpleado() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByNombre() {
    }

    @Test
    void findByApellido() {
    }

    @Test
    void daleteEmpleado() {
    }

    @Test
    void updateEmpleado() {
    }
}