package action;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class GeneralAction {

	public String salir() {
		return "/ui/principal.jsf";
	}

}
