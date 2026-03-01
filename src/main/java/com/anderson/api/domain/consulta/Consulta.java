package com.anderson.api.domain.consulta;


import com.anderson.api.domain.medico.Medico;
import com.anderson.api.domain.paciente.Paciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name= "consultas")
@Entity(name= "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "paciente_id")
    private Paciente paciente;

    private LocalDateTime fecha;

    @Column(name = "motivo_cancelamiento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamiento motivoCancelamiento;

    public void cancelar(MotivoCancelamiento motivo) {
        this.motivoCancelamiento = motivo;
    }


}
