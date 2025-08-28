package domain.ports;

import domain.model.HistoriaClinica;
import domain.model.RegistroMedico;
import java.util.Optional;

public interface HistoriaClinicaRepository {
    void guardar(HistoriaClinica historia);
    Optional<HistoriaClinica> buscarPorCedula(String cedulaPaciente);
    void agregarRegistro(String cedulaPaciente, String fecha, RegistroMedico registro);
}
