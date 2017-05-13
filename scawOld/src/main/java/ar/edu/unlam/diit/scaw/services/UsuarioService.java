package ar.edu.unlam.diit.scaw.services;

import java.util.List;

import ar.edu.unlam.diit.scaw.entities.Usuario;

public interface UsuarioService {
	
	
	public Usuario login(String nickname, String contraseña);
	
	public List<Usuario> getListaDeUsuarios();

	
	//aciones del usuario admin 
		public Usuario getUsuarioPorId(Integer id);
		
		public List<Usuario> getListaDeUsuariosMenosElUsuarioActual(Integer idUsuarioActual);
		
		public List<Usuario> getListaDeUsuariosQueNoEstanAprobados();
		
		public void seterElValorDeAprobadoDeUnUsuario(Integer id,Integer valor0o1);
		
		
		public void modificarUnUsuarioPorId(Integer id,String nickname,String nombre,String apellido,String contraseña,String tipo,Integer estaAprobado);
		
		public void eliminarUnUsuarioPorId(Integer id);
		
		//usuario cualquiera
		public void guardarUnUsuarioEnLaBDD(Usuario usuarioAGuardar) throws Exception;

		
}
