package com.anderson.api.domain.consulta.validaciones.reserva;

import com.anderson.api.domain.ValidacionException;
import com.anderson.api.domain.consulta.DatosReservaConsulta;
import com.anderson.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteActivo implements ValidadorDeConsultas{

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar (DatosReservaConsulta datos){
        var pacienteEstaActivo = pacienteRepository.findActivoById(datos.idPaciente());

        if(!pacienteEstaActivo){
            throw new ValidacionException("Consulta no puede ser reservada con un paciente inactivo");
        }
    }
}
