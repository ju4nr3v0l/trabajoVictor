package domain.model;

public class Medicamento {
    private final String id;
    private final String nombre;
    private final double costo;

    public Medicamento(String id, String nombre, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getCosto() { return costo; }
}
