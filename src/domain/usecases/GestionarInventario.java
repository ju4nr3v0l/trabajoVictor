package domain.usecases;

import domain.model.*;
import domain.ports.InventarioRepository;

public class GestionarInventario {
    private final InventarioRepository inventarioRepository;

    public GestionarInventario(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    public void agregarMedicamento(String id, String nombre, double costo, Rol rolSolicitante) {
        if (rolSolicitante != Rol.SOPORTE_INFORMACION) {
            throw new IllegalArgumentException("Solo Soporte de Información puede gestionar inventarios");
        }

        Medicamento medicamento = new Medicamento(id, nombre, costo);
        inventarioRepository.guardarMedicamento(medicamento);
    }

    public void agregarProcedimiento(String id, String nombre, double costo, Rol rolSolicitante) {
        if (rolSolicitante != Rol.SOPORTE_INFORMACION) {
            throw new IllegalArgumentException("Solo Soporte de Información puede gestionar inventarios");
        }

        Procedimiento procedimiento = new Procedimiento(id, nombre, costo);
        inventarioRepository.guardarProcedimiento(procedimiento);
    }

    public void agregarAyudaDiagnostica(String id, String nombre, double costo, Rol rolSolicitante) {
        if (rolSolicitante != Rol.SOPORTE_INFORMACION) {
            throw new IllegalArgumentException("Solo Soporte de Información puede gestionar inventarios");
        }

        AyudaDiagnostica ayuda = new AyudaDiagnostica(id, nombre, costo);
        inventarioRepository.guardarAyudaDiagnostica(ayuda);
    }
}
