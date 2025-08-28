package infrastructure.adapters;

import domain.model.Paciente;
import domain.ports.PacienteRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PacienteRepositoryMemoria implements PacienteRepository {
    private final Map<String, Paciente> pacientes = new HashMap<>();

    @Override
    public void guardar(Paciente paciente) {
        pacientes.put(paciente.getCedula(), paciente);
    }

    @Override
    public Optional<Paciente> buscarPorCedula(String cedula) {
        return Optional.ofNullable(pacientes.get(cedula));
    }
}
