package ar.edu.unlam.diit.scaw.daos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.object.UpdatableSqlQuery;

import ar.edu.unlam.diit.scaw.daos.UsuarioDao;
import ar.edu.unlam.diit.scaw.daos.impl.TareaDaoImpl.TareaMapper;
import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.entities.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{

	@Autowired
	 NamedParameterJdbcTemplate jdbcTemplate;
	
	
	
	 public UsuarioDaoImpl() {
		super();
	}
	
	 
//	//obtengo los participantes de una tarea
//		public List<Usuario> getListaDeParticipantesDeUnaTareaPorIdTarea(Integer idTarea) {
//			Map<String, Object> params = new HashMap<String, Object>();
//			String sql = "SELECT USUARIO.ID, USUARIO.NOMBRE ,USUARIO.APELLIDO,USUARIO.CONTRASENA ,USUARIO.TIPO,USUARIO.ESTAAPROBADO ,USUARIO.NICKNAME FROM (TAREA JOIN ACCEDETAREA  ON TAREA.ID = ACCEDETAREA .IDTAREA) JOIN USUARIO ON ACCEDETAREA.IDUSUARIO = USUARIO.ID  WHERE TAREA.ID = ' " +  " " + idTarea.toString() + " '";
//			
//			List<Usuario> lista = jdbcTemplate.query(sql, params, new UsuarioMapper());
//			return lista;
//			
//			
//			
//			
//		};
	

	 public Usuario login(String nickname, String contraseña) {/* si sale bien devuelve un user si no null*/
		
		 Map<String, Object> params = new HashMap<String, Object>();
		 String sql = "SELECT * FROM USUARIO WHERE NICKNAME =  '"  + nickname+ "'";
		 System.out.println(sql);
		 List<Usuario> lista =  jdbcTemplate.query(sql,params, new UsuarioMapper());
		 System.out.println(lista.size() + "size");
		 Usuario usuarioBuscado = null;
		 for(Usuario e : lista)
		 {
			 if(e.getNickName().equals(nickname))
			 {
				 usuarioBuscado.setContrasena(e.getContrasena());
				 usuarioBuscado.setNickName(e.getNickName());
			 }
		 }
		 
		 if( usuarioBuscado!=null)
		 {
			 if(!usuarioBuscado.getContrasena().equals(contraseña) )
			 {
				  return null;
			 }
		 }
		 else
		 {
			  return null;
		 }
		return usuarioBuscado;
		 
	 };
	 
	 @Override
	public List<Usuario> getListaDeUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}
	

	//geters
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private static final class UsuarioMapper implements RowMapper<Usuario>{
		
		//@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario= new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNombre(rs.getString("nombre"));
			usuario.setApellido(rs.getString("apellido"));
			usuario.setContrasena(rs.getString("contrasena"));
			usuario.setTipo(rs.getString("tipo"));
			usuario.setEstaAprobado(rs.getInt("estaAprobado"));
			usuario.setNickName(rs.getString("nickName"));
			return usuario;
		}
		
		
	}

	
	
	
	
	
	
	
}
