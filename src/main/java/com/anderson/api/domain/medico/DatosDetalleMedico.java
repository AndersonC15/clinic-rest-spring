package com.anderson.api.domain.medico;

import com.anderson.api.domain.direccion.Direccion;

public record DatosDetalleMedico(
        Long id,
        String nombre,
        String email,
        String documento,
        String telefono,
        Especialidad especialidad,
        Direccion direccion
) {
    public DatosDetalleMedico(Medico medico){
        this(   medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEmail(),
                medico.getEspecialidad(),
                medico.getDireccion()
        );


    }

}
