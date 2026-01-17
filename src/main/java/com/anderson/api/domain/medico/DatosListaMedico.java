package com.anderson.api.domain.medico;

public record DatosListaMedico(
        Long id,
        String nombre,
        String documento,
        String email,
        Especialidad especialidad
) {
    public DatosListaMedico(Medico medico) {
        this(   medico.getId(),
                medico.getNombre(),
                medico.getDocumento(),
                medico.getEmail(),
                medico.getEspecialidad());
    }
}
