package domain.model;

public class RegistroMedico {
    private final String fecha;
    private final String cedulaMedico;
    private final String motivoConsulta;
    private final String sintomatologia;
    private final String diagnostico;

    public RegistroMedico(String fecha, String cedulaMedico, String motivoConsulta, 
                         String sintomatologia, String diagnostico) {
        this.fecha = fecha;
        this.cedulaMedico = cedulaMedico;
        this.motivoConsulta = motivoConsulta;
        this.sintomatologia = sintomatologia;
        this.diagnostico = diagnostico;
    }

    public String getFecha() { return fecha; }
    public String getCedulaMedico() { return cedulaMedico; }
    public String getMotivoConsulta() { return motivoConsulta; }
    public String getSintomatologia() { return sintomatologia; }
    public String getDiagnostico() { return diagnostico; }
}
