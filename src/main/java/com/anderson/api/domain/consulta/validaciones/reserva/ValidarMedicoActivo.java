package com.anderson.api.domain.consulta.validaciones.reserva;

import com.anderson.api.domain.ValidacionException;
import com.anderson.api.domain.consulta.DatosReservaConsulta;
import com.anderson.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoActivo implements ValidadorDeConsultas{

    @Autowired
    private MedicoRepository repositorioMedico;

    public void validar (DatosReservaConsulta datos){
        //eleccion del medico es opcional
        if(datos.idMedico() == null){
            return;
        }

        var medicoEstaActivo = repositorioMedico.findActivoById(datos.idMedico());
        if(!medicoEstaActivo){
            throw new ValidacionException("Consulta no puede ser reservada con un medico inactivo");
        }
    }
}
