package domain.usecases;

import domain.model.*;
import domain.ports.*;
import java.util.ArrayList;
import java.util.List;

public class GestionarFacturacion {
    private final OrdenRepository ordenRepository;
    private final PacienteRepository pacienteRepository;
    private final UsuarioRepository usuarioRepository;
    private static final double COPAGO = 50000.0;
    private static final double LIMITE_COPAGO_ANUAL = 1000000.0;

    public GestionarFacturacion(OrdenRepository ordenRepository, PacienteRepository pacienteRepository,
                               UsuarioRepository usuarioRepository) {
        this.ordenRepository = ordenRepository;
        this.pacienteRepository = pacienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Factura generarFactura(String numeroOrden, String cedulaMedico, double copagoAcumuladoAnual,
                                 Rol rolSolicitante) {
        if (rolSolicitante != Rol.PERSONAL_ADMINISTRATIVO && rolSolicitante != Rol.MEDICO) {
            throw new IllegalArgumentException("Solo Personal Administrativo o Médicos pueden generar facturas");
        }

        // Obtener información de órdenes
        List<OrdenMedicamento> medicamentos = ordenRepository.buscarMedicamentosPorOrden(numeroOrden);
        List<OrdenProcedimiento> procedimientos = ordenRepository.buscarProcedimientosPorOrden(numeroOrden);
        List<OrdenAyudaDiagnostica> ayudas = ordenRepository.buscarAyudasPorOrden(numeroOrden);

        // Calcular total de servicios
        double totalServicios = 0;
        List<ItemFactura> items = new ArrayList<>();

        for (OrdenMedicamento med : medicamentos) {
            totalServicios += med.getCosto();
            items.add(new ItemFactura("Medicamento: " + med.getNombreMedicamento() + 
                                    " (Dosis: " + med.getDosis() + ")", med.getCosto()));
        }

        for (OrdenProcedimiento proc : procedimientos) {
            totalServicios += proc.getCosto();
            items.add(new ItemFactura("Procedimiento: " + proc.getNombreProcedimiento(), proc.getCosto()));
        }

        for (OrdenAyudaDiagnostica ayuda : ayudas) {
            totalServicios += ayuda.getCosto();
            items.add(new ItemFactura("Ayuda Diagnóstica: " + ayuda.getNombreAyudaDiagnostica(), ayuda.getCosto()));
        }

        // Obtener información del paciente (simulado)
        String cedulaPaciente = "1122334455"; // En implementación real se obtendría de la orden
        String nombrePaciente = "Juan Rodríguez";
        int edad = 29;
        String nombreMedico = "Dr. García";
        String nombreCompaniaSeguro = "EPS Salud";
        String numeroPoliza = "POL123456";
        String fechaVencimiento = "31/12/2024";

        // Calcular copago y totales
        double copago = 0;
        double totalPaciente = 0;
        double totalAseguradora = 0;

        // Lógica de facturación según las reglas
        if (copagoAcumuladoAnual >= LIMITE_COPAGO_ANUAL) {
            // No paga copago, aseguradora paga todo
            copago = 0;
            totalPaciente = 0;
            totalAseguradora = totalServicios;
        } else {
            // Paga copago de $50,000
            copago = COPAGO;
            totalPaciente = COPAGO;
            totalAseguradora = totalServicios - COPAGO;
        }

        return new Factura(cedulaPaciente, nombrePaciente, edad, nombreMedico,
                          nombreCompaniaSeguro, numeroPoliza, fechaVencimiento,
                          items, totalServicios, copago, totalPaciente, totalAseguradora);
    }
}
