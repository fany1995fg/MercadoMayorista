package entidades;

import java.io.FileOutputStream;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.persistence.*;
import javax.servlet.ServletContext;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the socio database table.
 * 
 */
@Entity
public class Socio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsocio;

	private String nombres;
	
	private String apellido;

	private String correo;
	
	
	private String soc_sexo;
	private String soc_estadocivil;
	
	private String soc_conyuge;
	
	private int dni;
	
	
	public String getSoc_conyuge() {
		return soc_conyuge;
	}

	public void setSoc_conyuge(String soc_conyuge) {
		this.soc_conyuge = soc_conyuge;
	}

	public String getSoc_estadocivil() {
		return soc_estadocivil;
	}

	public void setSoc_estadocivil(String soc_estadocivil) {
		this.soc_estadocivil = soc_estadocivil;
	}

	public String getSoc_sexo() {
		return soc_sexo;
	}

	public void setSoc_sexo(String soc_sexo) {
		this.soc_sexo = soc_sexo;
	}
	

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@Column(length=100000)
	private byte[] foto;
	
	@Transient
	private String imagen;
	
	
	@Column(length=100000)
	private byte[] firma;
	
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getImagen() {
		
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String realPath=(String) servletContext.getRealPath("/"); 
		 
		try {
			String rutaFile = realPath+"\\"+ idsocio +".jpg";
			imagen= idsocio +".jpg";
			FileOutputStream fileOuputStream = new FileOutputStream(rutaFile);
			fileOuputStream.write(foto);
			fileOuputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return imagen;
	}

 
	@Transient
	private String imagenFirma;


	public String getImagenFirma() {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String realPath=(String) servletContext.getRealPath("/"); 
		 
		try {
			String rutaFile = realPath+"\\"+ dni +".jpg";
			imagenFirma= dni +".jpg";
			FileOutputStream fileOuputStream = new FileOutputStream(rutaFile);
			fileOuputStream.write(firma);
			fileOuputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return imagenFirma;
	}

	public void setImagenFirma(String imagenFirma) {
		this.imagenFirma = imagenFirma;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public byte[] getFirma() {
		return firma;
	}

	public void setFirma(byte[] firma) {
		this.firma = firma;
	}

	public Socio() {
	}

	public int getIdsocio() {
		return idsocio;
	}

	public void setIdsocio(int idsocio) {
		this.idsocio = idsocio;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



}