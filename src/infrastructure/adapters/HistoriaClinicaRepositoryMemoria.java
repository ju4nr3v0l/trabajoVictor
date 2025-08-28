package infrastructure.adapters;

import domain.model.HistoriaClinica;
import domain.model.RegistroMedico;
import domain.ports.HistoriaClinicaRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HistoriaClinicaRepositoryMemoria implements HistoriaClinicaRepository {
    private final Map<String, HistoriaClinica> historias = new HashMap<>();

    @Override
    public void guardar(HistoriaClinica historia) {
        historias.put(historia.getCedulaPaciente(), historia);
    }

    @Override
    public Optional<HistoriaClinica> buscarPorCedula(String cedulaPaciente) {
        return Optional.ofNullable(historias.get(cedulaPaciente));
    }

    @Override
    public void agregarRegistro(String cedulaPaciente, String fecha, RegistroMedico registro) {
        HistoriaClinica historia = historias.computeIfAbsent(cedulaPaciente, 
                                                           k -> new HistoriaClinica(cedulaPaciente));
        historia.agregarRegistro(fecha, registro);
        historias.put(cedulaPaciente, historia);
    }
}
