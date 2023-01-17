package com.example.Empleado.repository;

import com.example.Empleado.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpaledoRepository extends JpaRepository<Empleado, Integer> {
    Optional<Empleado> findByNombre(String nombre);
    Optional<Empleado> findByApellido(String nombre);
}
