package domain.model;

public class Paciente {
    private final String cedula;
    private final String nombreCompleto;
    private final String fechaNacimiento;
    private final String genero;
    private final String direccion;
    private final String telefono;
    private final String correo;
    private final ContactoEmergencia contactoEmergencia;
    private final SeguroMedico seguroMedico;

    public Paciente(String cedula, String nombreCompleto, String fechaNacimiento,
                    String genero, String direccion, String telefono, String correo,
                    ContactoEmergencia contactoEmergencia, SeguroMedico seguroMedico) {
        validarCedula(cedula);
        validarTelefono(telefono);
        
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.contactoEmergencia = contactoEmergencia;
        this.seguroMedico = seguroMedico;
    }

    private void validarCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("Cédula es requerida");
        }
    }

    private void validarTelefono(String telefono) {
        if (telefono != null && telefono.length() != 10) {
            throw new IllegalArgumentException("Teléfono debe tener 10 dígitos");
        }
    }

    public String getCedula() { return cedula; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public SeguroMedico getSeguroMedico() { return seguroMedico; }
}
