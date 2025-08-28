package application;

import domain.model.*;
import domain.usecases.*;
import java.util.List;

public class ClinicaController {
    private final GestionarUsuarios gestionarUsuarios;
    private final GestionarPacientes gestionarPacientes;
    private final GestionarHistoriaClinica gestionarHistoria;
    private final GestionarOrdenes gestionarOrdenes;
    private final GestionarInventario gestionarInventario;
    private final GestionarSignosVitales gestionarSignos;
    private final GestionarFacturacion gestionarFacturacion;

    public ClinicaController(GestionarUsuarios gestionarUsuarios, GestionarPacientes gestionarPacientes,
                           GestionarHistoriaClinica gestionarHistoria, GestionarOrdenes gestionarOrdenes,
                           GestionarInventario gestionarInventario, GestionarSignosVitales gestionarSignos,
                           GestionarFacturacion gestionarFacturacion) {
        this.gestionarUsuarios = gestionarUsuarios;
        this.gestionarPacientes = gestionarPacientes;
        this.gestionarHistoria = gestionarHistoria;
        this.gestionarOrdenes = gestionarOrdenes;
        this.gestionarInventario = gestionarInventario;
        this.gestionarSignos = gestionarSignos;
        this.gestionarFacturacion = gestionarFacturacion;
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

    public void crearRegistroMedico(String cedulaPaciente, String fecha, String cedulaMedico,
                                   String motivoConsulta, String sintomatologia, String diagnostico,
                                   Rol rolSolicitante) {
        try {
            gestionarHistoria.crearRegistroMedico(cedulaPaciente, fecha, cedulaMedico,
                                                motivoConsulta, sintomatologia, diagnostico, rolSolicitante);
            System.out.println("Registro médico creado exitosamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void crearOrdenMedicamentos(String numeroOrden, String cedulaPaciente, String cedulaMedico,
                                     String fechaCreacion, List<OrdenMedicamento> medicamentos,
                                     Rol rolSolicitante) {
        try {
            gestionarOrdenes.crearOrdenMedicamentos(numeroOrden, cedulaPaciente, cedulaMedico,
                                                  fechaCreacion, medicamentos, rolSolicitante);
            System.out.println("Orden de medicamentos creada exitosamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void agregarMedicamento(String id, String nombre, double costo, Rol rolSolicitante) {
        try {
            gestionarInventario.agregarMedicamento(id, nombre, costo, rolSolicitante);
            System.out.println("Medicamento agregado al inventario exitosamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void registrarSignosVitales(String cedulaPaciente, String fecha, String presionArterial,
                                     double temperatura, int pulso, double nivelOxigeno,
                                     Rol rolSolicitante) {
        try {
            gestionarSignos.registrarSignosVitales(cedulaPaciente, fecha, presionArterial,
                                                 temperatura, pulso, nivelOxigeno, rolSolicitante);
            System.out.println("Signos vitales registrados exitosamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void generarFactura(String numeroOrden, String cedulaMedico, double copagoAcumuladoAnual,
                             Rol rolSolicitante) {
        try {
            Factura factura = gestionarFacturacion.generarFactura(numeroOrden, cedulaMedico,
                                                                copagoAcumuladoAnual, rolSolicitante);
            factura.imprimir();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
