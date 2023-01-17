package com.example.Empleado.mapper;

import com.example.Empleado.dto.request.EmpleadoRequest;
import com.example.Empleado.dto.response.EmpleadoResponse;
import com.example.Empleado.entity.Empleado;

public interface EmpleadoMapper {
    EmpleadoResponse entityToDto(Empleado empleado);
    Empleado dtoToEntity (EmpleadoResponse response) throws Exception;
    Empleado dtoRequestToEntity(EmpleadoRequest request) throws Exception;

}
