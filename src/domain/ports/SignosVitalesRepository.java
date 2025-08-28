package domain.ports;

import domain.model.SignosVitales;
import java.util.List;

public interface SignosVitalesRepository {
    void guardar(SignosVitales signos);
    List<SignosVitales> buscarPorPaciente(String cedulaPaciente);
}
