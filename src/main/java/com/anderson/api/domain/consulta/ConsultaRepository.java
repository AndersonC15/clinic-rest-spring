package com.anderson.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByMedicoIdAndFecha(Long medicoId, LocalDateTime fecha);

    boolean existsByPacienteIdAndFechaBetween(Long pacienteId, LocalDateTime primerHorario, LocalDateTime segundoHorario);
}