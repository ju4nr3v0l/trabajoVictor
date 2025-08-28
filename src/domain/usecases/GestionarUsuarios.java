package domain.usecases;

import domain.model.Usuario;
import domain.model.Rol;
import domain.ports.UsuarioRepository;

public class GestionarUsuarios {
    private final UsuarioRepository usuarioRepository;

    public GestionarUsuarios(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void crearUsuario(String cedula, String nombreCompleto, String fechaNacimiento,
                           String direccion, Rol rol, String telefono, String correo,
                           String nombreUsuario, String contrasena, Rol rolSolicitante) {
        
        if (rolSolicitante != Rol.RECURSOS_HUMANOS) {
            throw new IllegalArgumentException("Solo Recursos Humanos puede crear usuarios");
        }

        if (usuarioRepository.existeNombreUsuario(nombreUsuario)) {
            throw new IllegalArgumentException("Nombre de usuario ya existe");
        }

        Usuario usuario = new Usuario(cedula, nombreCompleto, fechaNacimiento, direccion,
                                    rol, telefono, correo, nombreUsuario, contrasena);
        usuarioRepository.guardar(usuario);
    }

    public void eliminarUsuario(String cedula, Rol rolSolicitante) {
        if (rolSolicitante != Rol.RECURSOS_HUMANOS) {
            throw new IllegalArgumentException("Solo Recursos Humanos puede eliminar usuarios");
        }
        usuarioRepository.eliminar(cedula);
    }
}
