package domain.ports;

import domain.model.*;
import java.util.List;

public interface OrdenRepository {
    void guardarOrden(Orden orden);
    void guardarOrdenMedicamento(OrdenMedicamento ordenMedicamento);
    void guardarOrdenProcedimiento(OrdenProcedimiento ordenProcedimiento);
    void guardarOrdenAyudaDiagnostica(OrdenAyudaDiagnostica ordenAyuda);
    List<OrdenMedicamento> buscarMedicamentosPorOrden(String numeroOrden);
    List<OrdenProcedimiento> buscarProcedimientosPorOrden(String numeroOrden);
    List<OrdenAyudaDiagnostica> buscarAyudasPorOrden(String numeroOrden);
    boolean existeOrden(String numeroOrden);
}
