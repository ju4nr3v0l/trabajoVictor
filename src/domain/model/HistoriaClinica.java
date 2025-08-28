package domain.model;

import java.util.HashMap;
import java.util.Map;

public class HistoriaClinica {
    private final String cedulaPaciente;
    private final Map<String, RegistroMedico> registros; // fecha -> registro

    public HistoriaClinica(String cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
        this.registros = new HashMap<>();
    }

    public void agregarRegistro(String fecha, RegistroMedico registro) {
        registros.put(fecha, registro);
    }

    public String getCedulaPaciente() { return cedulaPaciente; }
    public Map<String, RegistroMedico> getRegistros() { return registros; }
}
