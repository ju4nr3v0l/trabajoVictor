package domain.usecases;

import domain.model.*;
import domain.ports.HistoriaClinicaRepository;

public class GestionarHistoriaClinica {
    private final HistoriaClinicaRepository historiaRepository;

    public GestionarHistoriaClinica(HistoriaClinicaRepository historiaRepository) {
        this.historiaRepository = historiaRepository;
    }

    public void crearRegistroMedico(String cedulaPaciente, String fecha, String cedulaMedico,
                                   String motivoConsulta, String sintomatologia, String diagnostico,
                                   Rol rolSolicitante) {
        if (rolSolicitante != Rol.MEDICO) {
            throw new IllegalArgumentException("Solo médicos pueden crear registros médicos");
        }

        RegistroMedico registro = new RegistroMedico(fecha, cedulaMedico, motivoConsulta, 
                                                   sintomatologia, diagnostico);
        
        historiaRepository.agregarRegistro(cedulaPaciente, fecha, registro);
    }
}
