package com.anderson.api.domain.medico;

import com.anderson.api.domain.direccion.DatosDireccion;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroMedico(
        @NotBlank String nombre,
        @NotBlank @Email String email,
        @NotBlank
        @JsonAlias({"Telefono"}) String telefono,
        @NotBlank @Pattern(regexp = "\\d{10}") String documento,
        @NotNull
        @JsonAlias({"Especialidad"}) Especialidad especialidad,
        @NotNull @Valid DatosDireccion direccion) {

}
