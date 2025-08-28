package domain.usecases;

import domain.model.*;
import domain.ports.SignosVitalesRepository;

public class GestionarSignosVitales {
    private final SignosVitalesRepository signosRepository;

    public GestionarSignosVitales(SignosVitalesRepository signosRepository) {
        this.signosRepository = signosRepository;
    }

    public void registrarSignosVitales(String cedulaPaciente, String fecha, String presionArterial,
                                     double temperatura, int pulso, double nivelOxigeno,
                                     Rol rolSolicitante) {
        if (rolSolicitante != Rol.ENFERMERA) {
            throw new IllegalArgumentException("Solo enfermeras pueden registrar signos vitales");
        }

        SignosVitales signos = new SignosVitales(cedulaPaciente, fecha, presionArterial,
                                               temperatura, pulso, nivelOxigeno);
        signosRepository.guardar(signos);
    }
}
