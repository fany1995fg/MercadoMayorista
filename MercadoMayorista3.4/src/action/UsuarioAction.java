package action;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.component.api.UIData;
import org.primefaces.model.UploadedFile;

import model.UsuarioModel;
 
import entidades.Usuario;

 
@ManagedBean
public class UsuarioAction {

	private  Usuario Usuario;
	private List<Usuario> listaUsuario;
	private UIData dttUsuarios;	
	
	

	public UsuarioAction(){
		
		Usuario= new Usuario();
		
	}

	
	public String insertaUsuario() {
		UsuarioModel model = new UsuarioModel();
		model.inserUsuario(Usuario);
		return "/ui/listaUsuario.jsf";
	}
	
	
	public String eliminaUsuario() {
		Usuario = (Usuario) dttUsuarios.getRowData();

		UsuarioModel model = new UsuarioModel();
		model.eliminaUsuario(Usuario);
		return "/ui/listaUsuario.jsf";
	}
	
	public String buscaUsuario() {
		Usuario = (Usuario) dttUsuarios.getRowData();
		return "/ui/modificaUsuario.jsf";
	}

	public String modificaUsuario() {
		UsuarioModel model = new UsuarioModel();
		model.actualiza(Usuario);
		return "/ui/listaUsuario.jsf";
	}
	


	public Usuario getUsuario() {
		return Usuario;
	}



	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}



	
	
	public List<Usuario> getListaUsuario() {
		UsuarioModel model = new UsuarioModel();
		listaUsuario = model.listaUsuario();
		return listaUsuario;
	}


	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	
	public UIData getDttUsuarios() {
		return dttUsuarios;
	}	
	
 

	public void setDttUsuarios(UIData dttUsuarios) {
		this.dttUsuarios = dttUsuarios;
	}
	
	
}
