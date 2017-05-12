package ar.edu.unlam.diit.scaw.beans;

import java.io.Console;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hsqldb.lib.HashSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.unlam.diit.scaw.entities.AccedeTarea;
import ar.edu.unlam.diit.scaw.entities.Tarea;
import ar.edu.unlam.diit.scaw.entities.TareaYAccede;
import ar.edu.unlam.diit.scaw.entities.Usuario;
import ar.edu.unlam.diit.scaw.services.TareaService;
import ar.edu.unlam.diit.scaw.services.UsuarioService;


@ManagedBean(name="tareaBean",eager=true)
@SessionScoped
public class TareaBean extends UsuarioBean implements Serializable  {
	
	private static final long serialVersionUID = 10L;
	

	//participante 
	private String participanteNombre;
	private List<Usuario> listaDeParticipantes;
	java.util.HashSet<Usuario> listaDeParticipantesBuscados;
	private String modo;

	
	//logueo
	private Integer idUsuario;
	private String nickNameUsuario;
	private String contrasenaUsuario;
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String acceso;
	private String estado;
	
	private Map listaAcceso ;// no lo use sacar si no sirve
	//Spring Inject
	
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		TareaService tareaService = (TareaService) context.getBean("tareaService");
		UsuarioService usuarioService = (UsuarioService) context.getBean("usuarioService");
	
	
		
	public TareaBean() {
		super();
		
		this.nombre = null;
		this.descripcion = null;
		this.acceso =  null;
		this.estado = null;
		
	}
	
	public Tarea crearTareaEnBean()
	{
		Tarea t= new Tarea();
		t.setAcceso(this.acceso);
		t.setDescripcion(this.descripcion);
		t.setNombre(this.nombre);
		return t;
	}
	
	
	
	
}
