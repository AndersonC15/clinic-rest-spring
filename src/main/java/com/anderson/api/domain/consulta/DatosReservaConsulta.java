package com.anderson.api.domain.consulta;

import com.anderson.api.domain.medico.Especialidad;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DatosReservaConsulta(
        @JsonAlias({"id-Medico", "IdMedico", "id_Medico"}) Long idMedico,
        @NotNull
        @JsonAlias({"id-paciente", "IdPaciente", "id_Paciente"}) Long idPaciente,
        @NotNull
        @Future //Significa que no puede ser una fecha anterior a la actual
        @JsonAlias({"Fecha", "tiempo"}) LocalDateTime fecha,
        Especialidad especialidad
        ) {
}
