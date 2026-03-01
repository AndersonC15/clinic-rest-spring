package com.anderson.api.domain.consulta.validaciones.cancelamiento;

import com.anderson.api.domain.ValidacionException;
import com.anderson.api.domain.consulta.DatosReservaConsulta;
import com.anderson.api.domain.consulta.validaciones.reserva.ValidadorDeConsultas;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidacionConsultaConAnticipacion implements ValidadorDeConsultas {

    public void validar(DatosReservaConsulta datos){
        var fechaConsulta = datos.fecha();
        var ahora = LocalDateTime.now();
        var diferenciaEnMinutos = Duration.between(ahora, fechaConsulta).toMinutes();

        if(diferenciaEnMinutos < 30){
            throw new ValidacionException("Horario seleccionado menor que 30 minutos de anticipacion");
        }


    }
}
