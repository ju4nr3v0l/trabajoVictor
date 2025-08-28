package domain.model;

public class Usuario {
    private final String cedula;
    private final String nombreCompleto;
    private final String fechaNacimiento;
    private final String direccion;
    private final Rol rol;
    private final String telefono;
    private final String correo;
    private final String nombreUsuario;
    private final String contrasena;

    public Usuario(String cedula, String nombreCompleto, String fechaNacimiento, 
                   String direccion, Rol rol, String telefono, String correo, 
                   String nombreUsuario, String contrasena) {
        validarCedula(cedula);
        validarCorreo(correo);
        validarNombreUsuario(nombreUsuario);
        validarContrasena(contrasena);
        
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.rol = rol;
        this.telefono = telefono;
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    private void validarCedula(String cedula) {
        if (cedula == null || cedula.length() < 1 || cedula.length() > 10) {
            throw new IllegalArgumentException("Cédula debe tener entre 1 y 10 dígitos");
        }
    }

    private void validarCorreo(String correo) {
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("Correo debe ser válido");
        }
    }

    private void validarNombreUsuario(String nombreUsuario) {
        if (nombreUsuario == null || nombreUsuario.length() > 15 || 
            !nombreUsuario.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("Nombre de usuario debe ser único, máximo 15 caracteres, solo letras y números");
        }
    }

    private void validarContrasena(String contrasena) {
        if (contrasena == null || contrasena.length() < 8 || 
            !contrasena.matches(".*[A-Z].*") || 
            !contrasena.matches(".*[0-9].*") || 
            !contrasena.matches(".*[!@#$%^&*()].*")) {
            throw new IllegalArgumentException("Contraseña debe incluir mayúscula, número, carácter especial y mínimo 8 caracteres");
        }
    }

    public String getCedula() { return cedula; }
    public String getNombreCompleto() { return nombreCompleto; }
    public Rol getRol() { return rol; }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getCorreo() { return correo; }
}
