package domain.model;

public class OrdenMedicamento {
    private final String numeroOrden;
    private final int numeroItem;
    private final String nombreMedicamento;
    private final String dosis;
    private final String duracionTratamiento;
    private final double costo;

    public OrdenMedicamento(String numeroOrden, int numeroItem, String nombreMedicamento,
                           String dosis, String duracionTratamiento, double costo) {
        this.numeroOrden = numeroOrden;
        this.numeroItem = numeroItem;
        this.nombreMedicamento = nombreMedicamento;
        this.dosis = dosis;
        this.duracionTratamiento = duracionTratamiento;
        this.costo = costo;
    }

    public String getNumeroOrden() { return numeroOrden; }
    public int getNumeroItem() { return numeroItem; }
    public String getNombreMedicamento() { return nombreMedicamento; }
    public String getDosis() { return dosis; }
    public String getDuracionTratamiento() { return duracionTratamiento; }
    public double getCosto() { return costo; }
}
