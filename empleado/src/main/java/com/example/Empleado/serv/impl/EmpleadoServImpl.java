package com.example.Empleado.serv.impl;

import com.example.Empleado.dto.request.EmpleadoRequest;
import com.example.Empleado.dto.response.EmpleadoResponse;
import com.example.Empleado.entity.Empleado;
import com.example.Empleado.exception.ResourceNotFoundException;
import com.example.Empleado.mapper.EmpleadoMapper;
import com.example.Empleado.repository.EmpaledoRepository;
import com.example.Empleado.serv.EmpleadoServ;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
@Transactional
public class EmpleadoServImpl implements EmpleadoServ {

    public static final String COD = "001";
    @Autowired
    EmpaledoRepository repository;
    @Autowired
    EmpleadoMapper empleadoMapper;

    @Override
    public List<EmpleadoResponse> empledosFindAll() throws RuntimeException, ResourceNotFoundException {

        List<Empleado> empleados = repository.findAll();
        if (empleados.isEmpty()) {
            throw new ResourceNotFoundException("Error", COD);
        }
        return validateEmployee(empleados);
    }

    @Nullable
    private List<EmpleadoResponse> validateEmployee(List<Empleado> empleados) {
        return !empleados.isEmpty() ?
                empleados.stream().map(this.empleadoMapper::entityToDto).collect(Collectors.toList()) : null;
    }


    @Override
    public EmpleadoResponse inserEmpleado(EmpleadoRequest request) throws Exception {
        Empleado empleado = this.empleadoMapper.dtoRequestToEntity(request);
        var empleadoResponse = empleadoMapper.entityToDto(this.repository.save(empleado));
        return !ObjectUtils.isEmpty(empleadoResponse) ? empleadoResponse : null;
    }

    @Override
    public EmpleadoResponse findById(int id) throws Exception {
        try {
            Optional<Empleado> search = repository.findById(id);
            EmpleadoResponse empleadoDto = empleadoMapper.entityToDto(search.get());
            log.debug("Leaving finddemoAById [searchedDto]: {}", empleadoDto);

            return empleadoDto;

        } catch (Exception e) {
            throw new Exception("Error");
        }
    }

    @Override
    public Optional<EmpleadoResponse> findByNombre(String nombre) throws Exception {

        EmpleadoResponse response = new EmpleadoResponse();

        if (ObjectUtils.isEmpty(nombre)) {
            throw new Exception("error");
        }
        Optional<Empleado> empleado = repository.findByNombre(nombre);

        if (empleado.isPresent()) {
            response = empleadoMapper.entityToDto(empleado.get());
        }
        return Optional.of(response);
    }

    @Override
    public Optional<EmpleadoResponse> findByApellido(String apellido) throws Exception {
        EmpleadoResponse empleadoResponse = new EmpleadoResponse();

        if (ObjectUtils.isEmpty(apellido)) {
            throw new Exception("error");
        }
        Optional<Empleado> empleadoDto = repository.findByApellido(apellido);
        if (empleadoDto.isPresent()) {
            empleadoResponse = empleadoMapper.entityToDto(empleadoDto.get());
        }
        return Optional.of(empleadoResponse);
    }

    @Override
    public Long daleteEmpleado(int id) throws Exception {
        try {
            log.debug("Entering deleteById [id]: {}", id);

            Empleado empleado = getProductoExistId(id);
            if (!ObjectUtils.isEmpty(empleado)) this.repository.delete(empleado);
            log.debug("Leaving deleteContractProductById [deletedId]: {}", id);

        } catch (Exception e) {
            throw new ResourceNotFoundException("error", COD);
        }
        return (long) id;
    }

    @Override
    public Long updateEmpleado(EmpleadoRequest request) throws Exception {

        if (ObjectUtils.isEmpty(request)) {
            throw new ResourceNotFoundException("error", COD);
        }
        log.debug("Entering updateProduct [id]: {}, [request]: {}", request.getId(), request);

        Long idSaveOrUpdateEmpleado = inserEmpleado(request).getId();

        if (null == idSaveOrUpdateEmpleado & ObjectUtils.isEmpty(idSaveOrUpdateEmpleado)) {
            log.debug("Update Product Fail [id]: {}", request.getId());
        } else {
            log.debug("Update Product  [id]: {}", request.getId());

        }

        log.debug("Leaving updateContractEmpleado");
        return null;
    }

    private Empleado getProductoExistId(int id) {
        return Optional.ofNullable(this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("error"))).get();
    }


}
