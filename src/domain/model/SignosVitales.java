package domain.model;

public class SignosVitales {
    private final String cedulaPaciente;
    private final String fecha;
    private final String presionArterial;
    private final double temperatura;
    private final int pulso;
    private final double nivelOxigeno;

    public SignosVitales(String cedulaPaciente, String fecha, String presionArterial,
                        double temperatura, int pulso, double nivelOxigeno) {
        this.cedulaPaciente = cedulaPaciente;
        this.fecha = fecha;
        this.presionArterial = presionArterial;
        this.temperatura = temperatura;
        this.pulso = pulso;
        this.nivelOxigeno = nivelOxigeno;
    }

    public String getCedulaPaciente() { return cedulaPaciente; }
    public String getFecha() { return fecha; }
    public String getPresionArterial() { return presionArterial; }
    public double getTemperatura() { return temperatura; }
    public int getPulso() { return pulso; }
    public double getNivelOxigeno() { return nivelOxigeno; }
}
