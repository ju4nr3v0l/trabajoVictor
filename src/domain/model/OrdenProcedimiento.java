package domain.model;

public class OrdenProcedimiento {
    private final String numeroOrden;
    private final int numeroItem;
    private final String nombreProcedimiento;
    private final int numeroVeces;
    private final String frecuencia;
    private final double costo;
    private final boolean requiereEspecialista;
    private final String idEspecialidad;

    public OrdenProcedimiento(String numeroOrden, int numeroItem, String nombreProcedimiento,
                             int numeroVeces, String frecuencia, double costo,
                             boolean requiereEspecialista, String idEspecialidad) {
        this.numeroOrden = numeroOrden;
        this.numeroItem = numeroItem;
        this.nombreProcedimiento = nombreProcedimiento;
        this.numeroVeces = numeroVeces;
        this.frecuencia = frecuencia;
        this.costo = costo;
        this.requiereEspecialista = requiereEspecialista;
        this.idEspecialidad = idEspecialidad;
    }

    public String getNumeroOrden() { return numeroOrden; }
    public int getNumeroItem() { return numeroItem; }
    public String getNombreProcedimiento() { return nombreProcedimiento; }
    public int getNumeroVeces() { return numeroVeces; }
    public String getFrecuencia() { return frecuencia; }
    public double getCosto() { return costo; }
    public boolean isRequiereEspecialista() { return requiereEspecialista; }
    public String getIdEspecialidad() { return idEspecialidad; }
}
