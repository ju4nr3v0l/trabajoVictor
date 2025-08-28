package domain.model;

public class ContactoEmergencia {
    private final String nombre;
    private final String relacion;
    private final String telefono;

    public ContactoEmergencia(String nombre, String relacion, String telefono) {
        if (telefono != null && telefono.length() != 10) {
            throw new IllegalArgumentException("Teléfono de emergencia debe tener 10 dígitos");
        }
        
        this.nombre = nombre;
        this.relacion = relacion;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getRelacion() { return relacion; }
    public String getTelefono() { return telefono; }
}
