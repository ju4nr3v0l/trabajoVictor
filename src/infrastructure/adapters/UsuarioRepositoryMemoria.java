package infrastructure.adapters;

import domain.model.Usuario;
import domain.ports.UsuarioRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UsuarioRepositoryMemoria implements UsuarioRepository {
    private final Map<String, Usuario> usuarios = new HashMap<>();

    @Override
    public void guardar(Usuario usuario) {
        usuarios.put(usuario.getCedula(), usuario);
    }

    @Override
    public Optional<Usuario> buscarPorCedula(String cedula) {
        return Optional.ofNullable(usuarios.get(cedula));
    }

    @Override
    public Optional<Usuario> buscarPorNombreUsuario(String nombreUsuario) {
        return usuarios.values().stream()
                .filter(u -> u.getNombreUsuario().equals(nombreUsuario))
                .findFirst();
    }

    @Override
    public void eliminar(String cedula) {
        usuarios.remove(cedula);
    }

    @Override
    public boolean existeNombreUsuario(String nombreUsuario) {
        return usuarios.values().stream()
                .anyMatch(u -> u.getNombreUsuario().equals(nombreUsuario));
    }
}
