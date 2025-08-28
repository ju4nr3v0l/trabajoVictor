package domain.usecases;

import domain.model.*;
import domain.ports.PacienteRepository;

public class GestionarPacientes {
    private final PacienteRepository pacienteRepository;

    public GestionarPacientes(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void registrarPaciente(String cedula, String nombreCompleto, String fechaNacimiento,
                                String genero, String direccion, String telefono, String correo,
                                ContactoEmergencia contactoEmergencia, SeguroMedico seguroMedico,
                                Rol rolSolicitante) {
        
        if (rolSolicitante != Rol.PERSONAL_ADMINISTRATIVO) {
            throw new IllegalArgumentException("Solo Personal Administrativo puede registrar pacientes");
        }

        Paciente paciente = new Paciente(cedula, nombreCompleto, fechaNacimiento, genero,
                                       direccion, telefono, correo, contactoEmergencia, seguroMedico);
        pacienteRepository.guardar(paciente);
    }
}
