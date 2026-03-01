package com.anderson.api.domain.consulta;

import com.anderson.api.domain.ValidacionException;
import com.anderson.api.domain.medico.Medico;
import com.anderson.api.domain.medico.MedicoRepository;
import com.anderson.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaDeConsultas {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    public void reservar(DatosReservaConsulta datos){

        if(!pacienteRepository.existsById(datos.idPaciente())){
            throw new ValidacionException("No existe un paciente con este ID");
        }

        if(datos.idMedico() == null &&!medicoRepository.existsById(datos.idMedico())){
            throw new ValidacionException("No existe un médico con este ID");
        }
        var medico = elegirMedico(datos);
        var paciente = pacienteRepository.findById(datos.idPaciente()).get();

        var consulta= new Consulta(null, medico, paciente, datos.fecha(),null);

        consultaRepository.save(consulta);
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
            throw new ValidacionException("Id de la consulta informado no existe!");
        }
        var consulta = consultaRepository.getReferenceById(datos.idConsulta());
        consulta.cancelar(datos.motivo());
    }
}
