package ar.edu.unlam.diit.scaw.daos;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface UsuarioDao {
	
	public Usuario login(String nickname, String contraseña);
	
	public List<Usuario> getListaDeUsuarios();
	
	
	
	
}
