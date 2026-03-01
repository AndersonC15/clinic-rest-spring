package com.anderson.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

public record DatosDetalleConsulta(
        Long id,
        @JsonAlias({"id_Medico", "Medico_id", "id-medico", "id-Medico"}) Long idMedico,
        @JsonAlias({"id_Paciente", "Paciente_id", "id-paciente", "id-Paciente"}) Long idPaciente,
        @JsonAlias({"Fecha"}) LocalDateTime fecha
        ) {
}
