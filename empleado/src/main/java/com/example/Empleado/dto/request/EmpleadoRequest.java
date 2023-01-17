package com.example.Empleado.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpleadoRequest {
    private long id;
    private String nombre;
    private String apellido;
    private String email;
}
