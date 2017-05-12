package ar.edu.unlam.diit.scaw.services;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface UsuarioService {
	
	
	public Usuario login(String nickname, String contraseña);
	
	public List<Usuario> getListaDeUsuarios();

	
}
