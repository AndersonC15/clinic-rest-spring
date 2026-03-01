package com.anderson.api.domain.consulta;

import com.anderson.api.domain.ValidacionException;
import com.anderson.api.domain.consulta.validaciones.cancelamiento.ValidadorCancelamientoDeConsulta;
import com.anderson.api.domain.consulta.validaciones.reserva.ValidadorDeConsultas;
import com.anderson.api.domain.medico.Medico;
import com.anderson.api.domain.medico.MedicoRepository;
import com.anderson.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaDeConsultas {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private List<ValidadorDeConsultas> validadores;

    @Autowired
    private List<ValidadorCancelamientoDeConsulta> validadoresCancelamiento;

    public DatosDetalleConsulta reservar(DatosReservaConsulta datos){


        if(!pacienteRepository.existsById(datos.idPaciente())){
            throw new ValidacionException("No existe un paciente con este ID");
        }

        if(datos.idMedico() == null &&!medicoRepository.existsById(datos.idMedico())){
            throw new ValidacionException("No existe un médico con este ID");
        }

        //Validaciones
        validadores.forEach(v->v.validar(datos));
        //con esta interfaz estamos encapsulando todas las validaciones de la carpeta validaciones, en una interfaz, la implementamos en cada clase a la interfaz

        var medico = elegirMedico(datos);

        if(medico==null){
            throw new ValidacionException("No existe un medico disponible en ese horario");
        }
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();

        var consulta= new Consulta(null, medico, paciente, datos.fecha(),null);

        consultaRepository.save(consulta);

        return new DatosDetalleConsulta(consulta);
    }

    private Medico elegirMedico(DatosReservaConsulta datos) {
        if(datos.idMedico() != null){
            return medicoRepository.getReferenceById(datos.idMedico());
        }

        if(datos.especialidad() == null){
            throw new ValidacionException("Es necesario poner la especialidad cuando no se ingresa el medico");
        }

        return medicoRepository.elegirMedicoAleatorioDisponibleEnLaFecha(datos.especialidad(), datos.fecha());
    }

    public void cancelar(DatosCancelamientoConsulta datos) {
        if (!consultaRepository.existsById(datos.idConsulta())) {
            throw new ValidacionException("¡El Id informado de la consulta no existe!");
        }

        validadoresCancelamiento.forEach(v -> v.validar(datos));

        var consulta = consultaRepository.getReferenceById(datos.idConsulta());
        consulta.cancelar(datos.motivo());
    }
}
