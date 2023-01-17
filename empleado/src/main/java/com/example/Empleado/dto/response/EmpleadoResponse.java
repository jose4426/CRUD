package com.example.Empleado.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpleadoResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
}

