package action;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.component.api.UIData;
import org.primefaces.model.UploadedFile;

import model.SocioModel;
 
import entidades.Socio;

 
@ManagedBean
public class SocioAction {

	private  Socio socio;
	private List<Socio> listaSocio;
	private UIData dttSocios;	
	private UploadedFile foto;
	
	
	
	public UploadedFile getFoto() {
		return foto;
	}


	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}


	public SocioAction(){
		
		socio= new Socio();
		
	}

	
	public String insertaSocio() {
		SocioModel model = new SocioModel();
		
		socio.setFoto(foto.getContents());
		model.insertaSocio(socio);
		return "/ui/listaSocio.jsf";
	}
	
	
	public String eliminaSocio() {
		socio = (Socio) dttSocios.getRowData();

		SocioModel model = new SocioModel();
		model.elimina(socio);
		return "/ui/listaSocio.jsf";
	}
	
	public String buscaSocio() {
		socio = (Socio) dttSocios.getRowData();
		return "/ui/modificaSocio.jsf";
	}

	public String modificaSocio() {
		SocioModel model = new SocioModel();
		socio.setFoto(foto.getContents());
		model.actualiza(socio);
		return "/ui/listaSocio.jsf";
	}
	


	public Socio getSocio() {
		return socio;
	}



	public void setSocio(Socio socio) {
		this.socio = socio;
	}



	
	
	public List<Socio> getListaSocio() {
		SocioModel model = new SocioModel();
		listaSocio = model.listaSocio();
		return listaSocio;
	}


	public void setListaSocio(List<Socio> listaSocio) {
		this.listaSocio = listaSocio;
	}
	
	
	public UIData getDttSocios() {
		return dttSocios;
	}	
	
 

	public void setDttSocios(UIData dttSocios) {
		this.dttSocios = dttSocios;
	}
	
	
}
