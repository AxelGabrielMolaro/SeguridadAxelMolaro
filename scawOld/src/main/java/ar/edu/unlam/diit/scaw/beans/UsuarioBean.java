package ar.edu.unlam.diit.scaw.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.jsf.FacesContextUtils;

import ar.edu.unlam.diit.scaw.entities.TareaYAccede;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.PersonService;
import ar.edu.unlam.diit.scaw.services.UsuarioService;
import ar.edu.unlam.diit.scaw.services.impl.UsuarioServiceImpl;

@ManagedBean(name = "usuarioBean", eager = true)
@SessionScoped
public class UsuarioBean implements Serializable {

	// BAJA Y MODI
	private Integer idUsuarioABM;

	private static final long serialVersionUID = 1L;
	private Integer id  ;
	private String nombre ;
	private String apellido;
	private String contraseña ;
	private String tipo ;
	private Integer estaAprobado;
	private String nickName ;

	// Spring Inject

	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });
	UsuarioService usuarioService = (UsuarioService) context.getBean("usuarioService");

	// UsuarioServiceImpl usuarioService= new UsuarioServiceImpl();

	public UsuarioBean() {
		super();
		this.nombre = null;
		this.apellido = null;
		this.contraseña = null;
		this.tipo = null;
		this.estaAprobado = null;
		this.nickName = null;
	}

	/**************************/
	public void resetearElBean()
	{
		this.nombre = null;
		this.apellido = null;
		this.contraseña = null;
		this.tipo = null;
		this.estaAprobado = null;
		this.nickName = null;
	}
	
	public String login() {
		
		System.out.println("nickname + contra " +this.nickName + this.contraseña);
		Usuario usuarioBuscado = usuarioService.login(this.nickName, this.contraseña) ;
		
		
		if (usuarioBuscado == null) {
			System.out.println("1");
			resetearElBean();
			return "index";

			
		} else if(usuarioBuscado.getEstaAprobado()==0) {
			resetearElBean();
			System.out.println("12");
			return "index";
		}
		else if (usuarioBuscado.getTipo()=="normal")
		{
			System.out.println("13");
			this.id = usuarioBuscado.getId();
			this.nickName = usuarioBuscado.getNickName();
			this.nombre = usuarioBuscado.getNombre();
			this.apellido = usuarioBuscado.getApellido();
			this.tipo = usuarioBuscado.getTipo();
			this.estaAprobado = usuarioBuscado.getEstaAprobado();
			
			return "NormalHome";
		}
		else
		{
			System.out.println("341");
			this.id = usuarioBuscado.getId();
			this.nickName = usuarioBuscado.getNickName();
			this.nombre = usuarioBuscado.getNombre();
			this.apellido = usuarioBuscado.getApellido();
			this.tipo = usuarioBuscado.getTipo();
			this.estaAprobado = usuarioBuscado.getEstaAprobado();
			
			return "AdministradorHome";
			
		}
			

	}

	/***********************/

	public Integer getIdUsuarioABM() {
		return idUsuarioABM;
	}

	public void setIdUsuarioABM(Integer idUsuarioABM) {
		this.idUsuarioABM = idUsuarioABM;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getEstaAprobado() {
		return estaAprobado;
	}

	public void setEstaAprobado(Integer estaAprobado) {
		this.estaAprobado = estaAprobado;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
