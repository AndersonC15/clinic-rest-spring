package com.anderson.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DatosReservaConsulta(
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future //Significa que no puede ser una fecha anterior a la actual
        LocalDateTime fecha
        ) {
}
