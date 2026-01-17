package com.anderson.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import com.anderson.api.domain.direccion.DatosDireccion;

public record DatosActualizacionPaciente(
        @NotNull Long id,
        String nombre,
        String telefono,
        @Valid DatosDireccion direccion
) {
}
