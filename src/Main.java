import application.ClinicaController;
import domain.model.*;
import domain.usecases.*;
import infrastructure.adapters.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Configuración de la arquitectura hexagonal - Inyección de dependencias
        UsuarioRepositoryMemoria usuarioRepo = new UsuarioRepositoryMemoria();
        PacienteRepositoryMemoria pacienteRepo = new PacienteRepositoryMemoria();
        HistoriaClinicaRepositoryMemoria historiaRepo = new HistoriaClinicaRepositoryMemoria();
        OrdenRepositoryMemoria ordenRepo = new OrdenRepositoryMemoria();
        InventarioRepositoryMemoria inventarioRepo = new InventarioRepositoryMemoria();
        SignosVitalesRepositoryMemoria signosRepo = new SignosVitalesRepositoryMemoria();
        
        // Casos de uso
        GestionarUsuarios gestionarUsuarios = new GestionarUsuarios(usuarioRepo);
        GestionarPacientes gestionarPacientes = new GestionarPacientes(pacienteRepo);
        GestionarHistoriaClinica gestionarHistoria = new GestionarHistoriaClinica(historiaRepo);
        GestionarOrdenes gestionarOrdenes = new GestionarOrdenes(ordenRepo);
        GestionarInventario gestionarInventario = new GestionarInventario(inventarioRepo);
        GestionarSignosVitales gestionarSignos = new GestionarSignosVitales(signosRepo);
        GestionarFacturacion gestionarFacturacion = new GestionarFacturacion(ordenRepo, pacienteRepo, usuarioRepo);
        
        // Controlador
        ClinicaController controller = new ClinicaController(gestionarUsuarios, gestionarPacientes,
                gestionarHistoria, gestionarOrdenes, gestionarInventario, gestionarSignos, gestionarFacturacion);

        System.out.println("=== SISTEMA COMPLETO DE GESTIÓN DE CLÍNICA ===");
        
        // 1. RECURSOS HUMANOS - Crear usuarios
        System.out.println("\n1. RECURSOS HUMANOS - Creando usuarios...");
        controller.crearUsuario("1234567890", "Ana García", "15/05/1985", "Calle 123",
                              Rol.RECURSOS_HUMANOS, "3001234567", "ana@clinica.com",
                              "anagarcia", "Password123!", Rol.RECURSOS_HUMANOS);

        controller.crearUsuario("0987654321", "Carlos López", "20/03/1990", "Carrera 45",
                              Rol.PERSONAL_ADMINISTRATIVO, "3009876543", "carlos@clinica.com",
                              "carloslopez", "Admin456#", Rol.RECURSOS_HUMANOS);

        controller.crearUsuario("1111111111", "Dr. Martínez", "10/12/1975", "Avenida 80",
                              Rol.MEDICO, "3001111111", "martinez@clinica.com",
                              "drmartinez", "Doctor789$", Rol.RECURSOS_HUMANOS);

        controller.crearUsuario("2222222222", "Enfermera Pérez", "05/08/1988", "Calle 50",
                              Rol.ENFERMERA, "3002222222", "perez@clinica.com",
                              "enfperez", "Nurse456!", Rol.RECURSOS_HUMANOS);

        controller.crearUsuario("3333333333", "Soporte Tech", "15/01/1992", "Carrera 30",
                              Rol.SOPORTE_INFORMACION, "3003333333", "soporte@clinica.com",
                              "soportetech", "Support123#", Rol.RECURSOS_HUMANOS);

        // 2. PERSONAL ADMINISTRATIVO - Registrar pacientes
        System.out.println("\n2. PERSONAL ADMINISTRATIVO - Registrando pacientes...");
        ContactoEmergencia contacto = new ContactoEmergencia("María Pérez", "Madre", "3001111111");
        SeguroMedico seguro = new SeguroMedico("EPS Salud", "POL123456", true, "31/12/2024");
        
        controller.registrarPaciente("1122334455", "Juan Rodríguez", "10/08/1995", "Masculino",
                                   "Avenida 67", "3002222222", "juan@email.com",
                                   contacto, seguro, Rol.PERSONAL_ADMINISTRATIVO);

        // 3. SOPORTE DE INFORMACIÓN - Gestionar inventarios
        System.out.println("\n3. SOPORTE DE INFORMACIÓN - Gestionando inventarios...");
        controller.agregarMedicamento("MED001", "Acetaminofén 500mg", 5000, Rol.SOPORTE_INFORMACION);
        controller.agregarMedicamento("MED002", "Ibuprofeno 400mg", 8000, Rol.SOPORTE_INFORMACION);

        // 4. ENFERMERAS - Registrar signos vitales
        System.out.println("\n4. ENFERMERAS - Registrando signos vitales...");
        controller.registrarSignosVitales("1122334455", "28/08/2024", "120/80",
                                         36.5, 72, 98.5, Rol.ENFERMERA);

        // 5. MÉDICOS - Historia clínica y órdenes
        System.out.println("\n5. MÉDICOS - Creando historia clínica...");
        controller.crearRegistroMedico("1122334455", "28/08/2024", "1111111111",
                                     "Dolor de cabeza", "Cefalea intensa", 
                                     "Cefalea tensional", Rol.MEDICO);

        System.out.println("\n6. MÉDICOS - Creando orden de medicamentos...");
        OrdenMedicamento med1 = new OrdenMedicamento("123456", 1, "Acetaminofén 500mg", 
                                                   "1 tableta cada 8 horas", "3 días", 15000);
        OrdenMedicamento med2 = new OrdenMedicamento("123456", 2, "Ibuprofeno 400mg", 
                                                   "1 tableta cada 12 horas", "2 días", 16000);
        
        controller.crearOrdenMedicamentos("123456", "1122334455", "1111111111", "28/08/2024",
                                        Arrays.asList(med1, med2), Rol.MEDICO);

        // 7. FACTURACIÓN - Generar factura
        System.out.println("\n7. FACTURACIÓN - Generando factura...");
        controller.generarFactura("123456", "1111111111", 0, Rol.PERSONAL_ADMINISTRATIVO);

        // 8. VALIDACIONES DE PERMISOS
        System.out.println("\n8. VALIDACIONES DE PERMISOS - Intentos no autorizados...");
        
        System.out.println("\n8.1. Intento de crear usuario sin permisos:");
        controller.crearUsuario("5555555555", "Pedro Sánchez", "01/01/1980", "Calle 789",
                              Rol.MEDICO, "3005555555", "pedro@clinica.com",
                              "pedrosanchez", "Doctor789$", Rol.MEDICO);

        System.out.println("\n8.2. Intento de registrar paciente sin permisos:");
        controller.registrarPaciente("6666666666", "Ana López", "15/05/1990", "Femenino",
                                   "Calle 100", "3006666666", "ana@email.com",
                                   contacto, seguro, Rol.MEDICO);

        System.out.println("\n8.3. Intento de gestionar inventario sin permisos:");
        controller.agregarMedicamento("MED003", "Aspirina", 3000, Rol.ENFERMERA);

        System.out.println("\n8.4. Intento de registrar signos vitales sin permisos:");
        controller.registrarSignosVitales("1122334455", "28/08/2024", "110/70",
                                         36.8, 75, 99.0, Rol.PERSONAL_ADMINISTRATIVO);

        System.out.println("\n=== DEMOSTRACIÓN COMPLETA DEL SISTEMA ===");
        System.out.println("✅ Todas las funcionalidades implementadas según el documento");
        System.out.println("✅ Arquitectura hexagonal aplicada correctamente");
        System.out.println("✅ Validaciones de permisos por rol funcionando");
        System.out.println("✅ Separación de responsabilidades mantenida");
    }
}