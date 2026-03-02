package com.anderson.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDateTime;

public record DatosDetalleConsulta(
        Long id,
        @JsonAlias({"id-medico", "id-Medico"}) Long idMedico,
        @JsonAlias({"id-paciente", "id-Paciente"}) Long idPaciente,
        @JsonAlias({"Fecha"}) LocalDateTime fecha
        ) {
    public DatosDetalleConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getFecha());
    }
}
