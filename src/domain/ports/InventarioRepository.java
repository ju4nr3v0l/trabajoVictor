package domain.ports;

import domain.model.*;
import java.util.Optional;

public interface InventarioRepository {
    void guardarMedicamento(Medicamento medicamento);
    void guardarProcedimiento(Procedimiento procedimiento);
    void guardarAyudaDiagnostica(AyudaDiagnostica ayuda);
    Optional<Medicamento> buscarMedicamento(String id);
    Optional<Procedimiento> buscarProcedimiento(String id);
    Optional<AyudaDiagnostica> buscarAyudaDiagnostica(String id);
}
