package domain.ports;

import domain.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository {
    void guardar(Usuario usuario);
    Optional<Usuario> buscarPorCedula(String cedula);
    Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario);
    void eliminar(String cedula);
    boolean existeNombreUsuario(String nombreUsuario);
}
