package domain.usecases;

import domain.model.*;
import domain.ports.OrdenRepository;
import java.util.List;

public class GestionarOrdenes {
    private final OrdenRepository ordenRepository;

    public GestionarOrdenes(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public void crearOrdenMedicamentos(String numeroOrden, String cedulaPaciente, String cedulaMedico,
                                     String fechaCreacion, List<OrdenMedicamento> medicamentos,
                                     Rol rolSolicitante) {
        if (rolSolicitante != Rol.MEDICO) {
            throw new IllegalArgumentException("Solo médicos pueden crear órdenes");
        }

        if (ordenRepository.existeOrden(numeroOrden)) {
            throw new IllegalArgumentException("Número de orden ya existe");
        }

        Orden orden = new Orden(numeroOrden, cedulaPaciente, cedulaMedico, fechaCreacion);
        ordenRepository.guardarOrden(orden);

        for (OrdenMedicamento medicamento : medicamentos) {
            ordenRepository.guardarOrdenMedicamento(medicamento);
        }
    }

    public void crearOrdenProcedimientos(String numeroOrden, String cedulaPaciente, String cedulaMedico,
                                       String fechaCreacion, List<OrdenProcedimiento> procedimientos,
                                       Rol rolSolicitante) {
        if (rolSolicitante != Rol.MEDICO) {
            throw new IllegalArgumentException("Solo médicos pueden crear órdenes");
        }

        if (ordenRepository.existeOrden(numeroOrden)) {
            throw new IllegalArgumentException("Número de orden ya existe");
        }

        Orden orden = new Orden(numeroOrden, cedulaPaciente, cedulaMedico, fechaCreacion);
        ordenRepository.guardarOrden(orden);

        for (OrdenProcedimiento procedimiento : procedimientos) {
            ordenRepository.guardarOrdenProcedimiento(procedimiento);
        }
    }

    public void crearOrdenAyudaDiagnostica(String numeroOrden, String cedulaPaciente, String cedulaMedico,
                                         String fechaCreacion, List<OrdenAyudaDiagnostica> ayudas,
                                         Rol rolSolicitante) {
        if (rolSolicitante != Rol.MEDICO) {
            throw new IllegalArgumentException("Solo médicos pueden crear órdenes");
        }

        if (ordenRepository.existeOrden(numeroOrden)) {
            throw new IllegalArgumentException("Número de orden ya existe");
        }

        Orden orden = new Orden(numeroOrden, cedulaPaciente, cedulaMedico, fechaCreacion);
        ordenRepository.guardarOrden(orden);

        for (OrdenAyudaDiagnostica ayuda : ayudas) {
            ordenRepository.guardarOrdenAyudaDiagnostica(ayuda);
        }
    }
}
