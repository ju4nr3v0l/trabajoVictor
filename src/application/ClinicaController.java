package application;

import domain.model.*;
import domain.usecases.GestionarUsuarios;
import domain.usecases.GestionarPacientes;

public class ClinicaController {
    private final GestionarUsuarios gestionarUsuarios;
    private final GestionarPacientes gestionarPacientes;

    public ClinicaController(GestionarUsuarios gestionarUsuarios, GestionarPacientes gestionarPacientes) {
        this.gestionarUsuarios = gestionarUsuarios;
        this.gestionarPacientes = gestionarPacientes;
    }

    public void crearUsuario(String cedula, String nombreCompleto, String fechaNacimiento,
                           String direccion, Rol rol, String telefono, String correo,
                           String nombreUsuario, String contrasena, Rol rolSolicitante) {
        try {
            gestionarUsuarios.crearUsuario(cedula, nombreCompleto, fechaNacimiento, direccion,
                                         rol, telefono, correo, nombreUsuario, contrasena, rolSolicitante);
            System.out.println("Usuario creado exitosamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void registrarPaciente(String cedula, String nombreCompleto, String fechaNacimiento,
                                String genero, String direccion, String telefono, String correo,
                                ContactoEmergencia contactoEmergencia, SeguroMedico seguroMedico,
                                Rol rolSolicitante) {
        try {
            gestionarPacientes.registrarPaciente(cedula, nombreCompleto, fechaNacimiento, genero,
                                               direccion, telefono, correo, contactoEmergencia,
                                               seguroMedico, rolSolicitante);
            System.out.println("Paciente registrado exitosamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
