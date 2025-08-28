package infrastructure.adapters;

import domain.model.SignosVitales;
import domain.ports.SignosVitalesRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SignosVitalesRepositoryMemoria implements SignosVitalesRepository {
    private final List<SignosVitales> signos = new ArrayList<>();

    @Override
    public void guardar(SignosVitales signosVitales) {
        signos.add(signosVitales);
    }

    @Override
    public List<SignosVitales> buscarPorPaciente(String cedulaPaciente) {
        return signos.stream()
                .filter(s -> s.getCedulaPaciente().equals(cedulaPaciente))
                .collect(Collectors.toList());
    }
}
