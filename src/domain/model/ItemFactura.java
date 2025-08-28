package domain.model;

public class ItemFactura {
    private final String descripcion;
    private final double costo;

    public ItemFactura(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getDescripcion() { return descripcion; }
    public double getCosto() { return costo; }
}
