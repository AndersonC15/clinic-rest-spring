package com.anderson.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public record DatosCancelamientoConsulta(
        @NotNull
        @JsonAlias({"id_Consulta", "id-consulta"}) Long idConsulta,
        @NotNull

        @JsonAlias({"Motivo_Cancelamiento"}) MotivoCancelamiento motivo) {
}