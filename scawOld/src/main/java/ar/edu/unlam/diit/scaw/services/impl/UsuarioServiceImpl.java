package ar.edu.unlam.diit.scaw.services.impl;

import java.util.List;

import javax.enterprise.inject.New;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unlam.diit.scaw.daos.PersonDao;
import ar.edu.unlam.diit.scaw.daos.UsuarioDao;
import ar.edu.unlam.diit.scaw.daos.impl.UsuarioDaoImpl;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.UsuarioService;
import junit.framework.Assert;

public class UsuarioServiceImpl implements UsuarioService {

	
	@Autowired
	UsuarioDao usuarioDao;
	
	//UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
	
	@Override
	public Usuario login(String nickname, String contraseña) {
		return usuarioDao.login(nickname, contraseña);
	}
	
	@Override
	public List<Usuario> getListaDeUsuarios() {
		// TODO Auto-generated method stub
		return usuarioDao.getListaDeUsuarios();
	}



	

	
}
