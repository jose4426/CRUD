package com.example.Empleado.mapper.impl;

import com.example.Empleado.dto.request.EmpleadoRequest;
import com.example.Empleado.dto.response.EmpleadoResponse;
import com.example.Empleado.entity.Empleado;
import com.example.Empleado.mapper.EmpleadoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
@Component
public class EmpleadoMapperImpl implements EmpleadoMapper {

    private ModelMapper modelMapper;
    @Override
    public EmpleadoResponse entityToDto(Empleado empleado) {

            if(ObjectUtils.isEmpty(empleado)){
                try {
                    throw  new RuntimeException("El empleado no existe");
                } catch (RuntimeException e) {
                    throw new RuntimeException(e);
                }
            }

            return EmpleadoResponse
                    .builder()

                    .email(empleado.getEmail())
                    .nombre(empleado.getNombre())
                    .apellido(empleado.getApellido())
                   /* .id(!ObjectUtils.isEmpty(producto.getId())?producto.getId():null)
                    .codProduct(producto.getCodProduct())
                    .descrip(producto.getDescrip())
                    .name(producto.getName())*/
                    .build();
    }

    @Override
    public Empleado dtoToEntity(EmpleadoResponse response) throws Exception {
        Empleado entity = new Empleado();
        if(ObjectUtils.isEmpty(response)){
            try {
                throw  new Exception("El empleado no existe");
            } catch (Exception e) {
                throw  new Exception("El empleado no existe");
            }
        }
        this.modelMapper.map(response,entity);
        return entity;

    }

    @Override
    public Empleado dtoRequestToEntity(EmpleadoRequest request) throws Exception {
        if(ObjectUtils.isEmpty(request)){
            try {
                throw  new Exception("El empleado no existe");
            } catch (Exception e) {
                throw  new Exception("El empleado no existe");
            }
        }

        return Empleado
                .builder()
                .id(!ObjectUtils.isEmpty(request.getId())? request.getId() : null)
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .email(request.getEmail())

                /*.id(!ObjectUtils.isEmpty(request.getId())? request.getId() : null)
                .codProduct(request.getCodProduct())
                .descrip(request.getDescrip())
                .name(request.getName().trim().toUpperCase())*/
                .build();

    }
}
