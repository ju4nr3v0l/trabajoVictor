import application.ClinicaController;
import domain.model.*;
import domain.usecases.GestionarUsuarios;
import domain.usecases.GestionarPacientes;
import infrastructure.adapters.UsuarioRepositoryMemoria;
import infrastructure.adapters.PacienteRepositoryMemoria;

public class Main {
    public static void main(String[] args) {
        // Configuración de la arquitectura hexagonal
        UsuarioRepositoryMemoria usuarioRepo = new UsuarioRepositoryMemoria();
        PacienteRepositoryMemoria pacienteRepo = new PacienteRepositoryMemoria();
        
        GestionarUsuarios gestionarUsuarios = new GestionarUsuarios(usuarioRepo);
        GestionarPacientes gestionarPacientes = new GestionarPacientes(pacienteRepo);
        
        ClinicaController controller = new ClinicaController(gestionarUsuarios, gestionarPacientes);

        System.out.println("=== Sistema de Gestión de Clínica ===");
        
        // Demostración del sistema
        System.out.println("\n1. Creando usuario de Recursos Humanos...");
        controller.crearUsuario("1234567890", "Ana García", "15/05/1985", "Calle 123",
                              Rol.RECURSOS_HUMANOS, "3001234567", "ana@clinica.com",
                              "anagarcia", "Password123!", Rol.RECURSOS_HUMANOS);

        System.out.println("\n2. Creando usuario Personal Administrativo...");
        controller.crearUsuario("0987654321", "Carlos López", "20/03/1990", "Carrera 45",
                              Rol.PERSONAL_ADMINISTRATIVO, "3009876543", "carlos@clinica.com",
                              "carloslopez", "Admin456#", Rol.RECURSOS_HUMANOS);

        System.out.println("\n3. Registrando paciente...");
        ContactoEmergencia contacto = new ContactoEmergencia("María Pérez", "Madre", "3001111111");
        SeguroMedico seguro = new SeguroMedico("EPS Salud", "POL123456", true, "31/12/2024");
        
        controller.registrarPaciente("1122334455", "Juan Rodríguez", "10/08/1995", "Masculino",
                                   "Avenida 67", "3002222222", "juan@email.com",
                                   contacto, seguro, Rol.PERSONAL_ADMINISTRATIVO);

        System.out.println("\n4. Intentando crear usuario sin permisos...");
        controller.crearUsuario("5555555555", "Pedro Sánchez", "01/01/1980", "Calle 789",
                              Rol.MEDICO, "3005555555", "pedro@clinica.com",
                              "pedrosanchez", "Doctor789$", Rol.MEDICO);

        System.out.println("\n=== Demostración completada ===");
    }
}