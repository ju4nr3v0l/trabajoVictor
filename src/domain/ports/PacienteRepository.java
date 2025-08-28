package domain.ports;

import domain.model.Paciente;
import java.util.Optional;

public interface PacienteRepository {
    void guardar(Paciente paciente);
    Optional<Paciente> buscarPorCedula(String cedula);
}
