package action;

import java.util.List;

import model.DistritoModel;

import entidades.Distrito;

public class ComboAction {
	private List<Distrito> distritos;

	
	
	
	public List<Distrito> getDistrito() {
		DistritoModel model = new DistritoModel();
		distritos = model.listaDistrito();
		return distritos;
	}

	public void setDistrito(List<Distrito> distrito) {
		this.distritos = distrito;
	}
	

}
