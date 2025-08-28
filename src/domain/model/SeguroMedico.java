package domain.model;

public class SeguroMedico {
    private final String nombreCompania;
    private final String numeroPoliza;
    private final boolean activa;
    private final String fechaVencimiento;

    public SeguroMedico(String nombreCompania, String numeroPoliza, boolean activa, String fechaVencimiento) {
        this.nombreCompania = nombreCompania;
        this.numeroPoliza = numeroPoliza;
        this.activa = activa;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNombreCompania() { return nombreCompania; }
    public String getNumeroPoliza() { return numeroPoliza; }
    public boolean isActiva() { return activa; }
    public String getFechaVencimiento() { return fechaVencimiento; }
}
