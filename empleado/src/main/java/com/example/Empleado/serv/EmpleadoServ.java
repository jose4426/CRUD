package com.example.Empleado.serv;

import com.example.Empleado.dto.request.EmpleadoRequest;
import com.example.Empleado.dto.response.EmpleadoResponse;
import java.util.List;
import java.util.Optional;

public interface EmpleadoServ {
    List<EmpleadoResponse> empledosFindAll() throws Exception ;
    EmpleadoResponse findById(int id) throws Exception;
    EmpleadoResponse inserEmpleado(EmpleadoRequest empleado)throws Exception;
    Long daleteEmpleado ( int id) throws Exception;
    Long updateEmpleado( EmpleadoRequest request) throws Exception ;
    Optional<EmpleadoResponse> findByNombre(String nombre) throws Exception;
    Optional<EmpleadoResponse> findByApellido(String apellido) throws Exception;
}
