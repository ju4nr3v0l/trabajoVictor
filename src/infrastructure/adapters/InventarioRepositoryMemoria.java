package infrastructure.adapters;

import domain.model.*;
import domain.ports.InventarioRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InventarioRepositoryMemoria implements InventarioRepository {
    private final Map<String, Medicamento> medicamentos = new HashMap<>();
    private final Map<String, Procedimiento> procedimientos = new HashMap<>();
    private final Map<String, AyudaDiagnostica> ayudas = new HashMap<>();

    @Override
    public void guardarMedicamento(Medicamento medicamento) {
        medicamentos.put(medicamento.getId(), medicamento);
    }

    @Override
    public void guardarProcedimiento(Procedimiento procedimiento) {
        procedimientos.put(procedimiento.getId(), procedimiento);
    }

    @Override
    public void guardarAyudaDiagnostica(AyudaDiagnostica ayuda) {
        ayudas.put(ayuda.getId(), ayuda);
    }

    @Override
    public Optional<Medicamento> buscarMedicamento(String id) {
        return Optional.ofNullable(medicamentos.get(id));
    }

    @Override
    public Optional<Procedimiento> buscarProcedimiento(String id) {
        return Optional.ofNullable(procedimientos.get(id));
    }

    @Override
    public Optional<AyudaDiagnostica> buscarAyudaDiagnostica(String id) {
        return Optional.ofNullable(ayudas.get(id));
    }
}
