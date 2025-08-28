package infrastructure.adapters;

import domain.model.*;
import domain.ports.OrdenRepository;
import java.util.*;
import java.util.stream.Collectors;

public class OrdenRepositoryMemoria implements OrdenRepository {
    private final Map<String, Orden> ordenes = new HashMap<>();
    private final List<OrdenMedicamento> medicamentos = new ArrayList<>();
    private final List<OrdenProcedimiento> procedimientos = new ArrayList<>();
    private final List<OrdenAyudaDiagnostica> ayudas = new ArrayList<>();

    @Override
    public void guardarOrden(Orden orden) {
        ordenes.put(orden.getNumeroOrden(), orden);
    }

    @Override
    public void guardarOrdenMedicamento(OrdenMedicamento ordenMedicamento) {
        medicamentos.add(ordenMedicamento);
    }

    @Override
    public void guardarOrdenProcedimiento(OrdenProcedimiento ordenProcedimiento) {
        procedimientos.add(ordenProcedimiento);
    }

    @Override
    public void guardarOrdenAyudaDiagnostica(OrdenAyudaDiagnostica ordenAyuda) {
        ayudas.add(ordenAyuda);
    }

    @Override
    public List<OrdenMedicamento> buscarMedicamentosPorOrden(String numeroOrden) {
        return medicamentos.stream()
                .filter(m -> m.getNumeroOrden().equals(numeroOrden))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrdenProcedimiento> buscarProcedimientosPorOrden(String numeroOrden) {
        return procedimientos.stream()
                .filter(p -> p.getNumeroOrden().equals(numeroOrden))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrdenAyudaDiagnostica> buscarAyudasPorOrden(String numeroOrden) {
        return ayudas.stream()
                .filter(a -> a.getNumeroOrden().equals(numeroOrden))
                .collect(Collectors.toList());
    }

    @Override
    public boolean existeOrden(String numeroOrden) {
        return ordenes.containsKey(numeroOrden);
    }
}
