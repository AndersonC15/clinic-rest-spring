package com.anderson.api.domain.consulta.validaciones.reserva;

import com.anderson.api.domain.ValidacionException;
import com.anderson.api.domain.consulta.ConsultaRepository;
import com.anderson.api.domain.consulta.DatosReservaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteSinOtraConsultaEnElMismoDia implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosReservaConsulta datos){
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);
        var pacienteTieneOtraConsulta = repository.existsByPacienteIdAndFechaBetween(datos.idPaciente(), primerHorario, ultimoHorario);

        if(pacienteTieneOtraConsulta){
            throw new ValidacionException("Paciente ya tiene una consulta reservada para ese dia.");
        }

    }

}
