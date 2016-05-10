package action;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.component.api.UIData;
import org.primefaces.model.UploadedFile;



import model.SocioModel;
 
import entidades.Socio;
import entidades.Socio;

 
@ManagedBean
public class SocioAction {

	private  Socio socio;
	private List<Socio> listaSocio;
	private UIData dttSocios;	
	private UploadedFile foto;
	private UploadedFile firma;
	
	private int dni;
	
	
	public UploadedFile getFirma() {
		return firma;
	}


	public void setFirma(UploadedFile firma) {
		this.firma = firma;
	}
	
	
	
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
		socio.setFirma(firma.getContents());
		model.insertaSocio(socio);
		return "/ui/listaSocio.jsf";
	}
	
	
	public String eliminaSocio() {
		socio = (Socio) dttSocios.getRowData();
		SocioModel model = new SocioModel();
		model.elimina(socio);
		listaSocio = model.consulta(dni);
		return "/ui/listaSocio.jsf";
	}
	
	public String consultaSocio(){
		SocioModel m = new SocioModel();
		listaSocio =  m.consulta(dni);		
		return "/ui/consulta.jsf";
	}

	public String modificaSocio() {
		SocioModel model = new SocioModel();
		socio.setFoto(foto.getContents());
		socio.setFirma(firma.getContents());
		model.actualiza(socio);
		return "/ui/listaSocio.jsf";
	}
	
	public String buscaSocio() {
		socio = (Socio) dttSocios.getRowData();
		return "/ui/modificaSocio.jsf";
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
