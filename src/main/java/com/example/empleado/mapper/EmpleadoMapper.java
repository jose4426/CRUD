package com.example.empleado.mapper;

import com.example.empleado.dto.request.EmpleadoRequest;
import com.example.empleado.dto.response.EmpleadoResponse;
import com.example.empleado.entity.Empleado;

public interface EmpleadoMapper {
    EmpleadoResponse entityToDto(Empleado empleado);
    Empleado dtoToEntity (EmpleadoResponse response) throws Exception;
    Empleado dtoRequestToEntity(EmpleadoRequest request) throws Exception;

}
