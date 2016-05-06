/*package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
public class Distrito implements Serializable{
	private static final long serialVersionUID =1L;
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddistrito;
	private int idprovincia;
	private int dis_nombre;
	
		
	
	@OneToMany(mappedBy="distrito")
	private List<Socio> socios;
	
	
 
	public List<Socio> getSocios() {
		return socios;
	}
	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}
	
	
	public int getIdprovincia() {
		return idprovincia;
	}
	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}
	public int getDis_nombre() {
		return dis_nombre;
	}
	public void setDis_nombre(int dis_nombre) {
		this.dis_nombre = dis_nombre;
	}
	
	
}
*/