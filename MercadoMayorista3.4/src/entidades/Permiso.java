package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the permiso database table.
 * 
 */
@Entity
@Table(name="permiso")
public class Permiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String opcion;

	private int rol;

	private String url;

    public Permiso() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpcion() {
		return this.opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public int getRol() {
		return this.rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}