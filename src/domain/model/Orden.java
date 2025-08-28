package domain.model;

public class Orden {
    private final String numeroOrden;
    private final String cedulaPaciente;
    private final String cedulaMedico;
    private final String fechaCreacion;

    public Orden(String numeroOrden, String cedulaPaciente, String cedulaMedico, String fechaCreacion) {
        if (numeroOrden.length() > 6) {
            throw new IllegalArgumentException("Número de orden debe tener máximo 6 dígitos");
        }
        this.numeroOrden = numeroOrden;
        this.cedulaPaciente = cedulaPaciente;
        this.cedulaMedico = cedulaMedico;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNumeroOrden() { return numeroOrden; }
    public String getCedulaPaciente() { return cedulaPaciente; }
    public String getCedulaMedico() { return cedulaMedico; }
    public String getFechaCreacion() { return fechaCreacion; }
}
