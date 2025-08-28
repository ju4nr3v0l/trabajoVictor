package domain.model;

public class OrdenAyudaDiagnostica {
    private final String numeroOrden;
    private final int numeroItem;
    private final String nombreAyudaDiagnostica;
    private final int cantidad;
    private final double costo;
    private final boolean requiereEspecialista;
    private final String idEspecialidad;

    public OrdenAyudaDiagnostica(String numeroOrden, int numeroItem, String nombreAyudaDiagnostica,
                                int cantidad, double costo, boolean requiereEspecialista, String idEspecialidad) {
        this.numeroOrden = numeroOrden;
        this.numeroItem = numeroItem;
        this.nombreAyudaDiagnostica = nombreAyudaDiagnostica;
        this.cantidad = cantidad;
        this.costo = costo;
        this.requiereEspecialista = requiereEspecialista;
        this.idEspecialidad = idEspecialidad;
    }

    public String getNumeroOrden() { return numeroOrden; }
    public int getNumeroItem() { return numeroItem; }
    public String getNombreAyudaDiagnostica() { return nombreAyudaDiagnostica; }
    public int getCantidad() { return cantidad; }
    public double getCosto() { return costo; }
    public boolean isRequiereEspecialista() { return requiereEspecialista; }
    public String getIdEspecialidad() { return idEspecialidad; }
}
