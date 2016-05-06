
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.event.CaptureEvent;
import org.primefaces.model.CroppedImage;


@ManagedBean
@ViewScoped
public class PhotoController {

    private CroppedImage imagenRecortada;
    private String foto;
    private String fotoRecortada;
    private String archivoFoto;
    private String archivoFotoRecortada;
    private boolean pantallaImagenCapturada;
    private ServletContext servletContext;

    


    public CroppedImage getImagenRecortada() {
		return imagenRecortada;
	}

	public void setImagenRecortada(CroppedImage imagenRecortada) {
		this.imagenRecortada = imagenRecortada;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFotoRecortada() {
		return fotoRecortada;
	}

	public void setFotoRecortada(String fotoRecortada) {
		this.fotoRecortada = fotoRecortada;
	}

	public String getArchivoFoto() {
		return archivoFoto;
	}

	public void setArchivoFoto(String archivoFoto) {
		this.archivoFoto = archivoFoto;
	}

	public String getArchivoFotoRecortada() {
		return archivoFotoRecortada;
	}

	public void setArchivoFotoRecortada(String archivoFotoRecortada) {
		this.archivoFotoRecortada = archivoFotoRecortada;
	}

	public boolean isPantallaImagenCapturada() {
		return pantallaImagenCapturada;
	}

	public void setPantallaImagenCapturada(boolean pantallaImagenCapturada) {
		this.pantallaImagenCapturada = pantallaImagenCapturada;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	private String getNumeroRandomico() {
        int i = (int) (Math.random() * 10000);
        return String.valueOf(i);
    }

    private void creaArchivo(String archivo, byte[] dados) {
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(archivo));
            imageOutput.write(dados, 0, dados.length);
            imageOutput.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhotoController.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Caminho não encontrado!", "Erro"));
        } catch (IOException ex) {
            Logger.getLogger(PhotoController.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao criar archivo!", "Erro"));
        }
    }

    public void recortar() {
        verificaExistenciaArchivo(archivoFotoRecortada);
        fotoRecortada = "fotoRecortada" + getNumeroRandomico() + ".png";
        archivoFotoRecortada = servletContext.getRealPath(File.separator + "imagenes" + File.separator + "tmp" + File.separator + fotoRecortada);
        creaArchivo(archivoFotoRecortada, imagenRecortada.getBytes());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Foto RECORTADA CON EXITO!", "Información"));
    }

    public void oncapture(CaptureEvent captureEvent) {
        verificaExistenciaArchivo(archivoFoto);
        foto = "foto" + getNumeroRandomico() + ".png";
        archivoFoto = servletContext.getRealPath(File.separator + "imagenes" + File.separator + "tmp" + File.separator + foto);
        creaArchivo(archivoFoto, captureEvent.getData());
        pantallaImagenCapturada = true;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Foto CAPTURADA CON EXITO!", "Información"));
    }

    private void verificaExistenciaArchivo(String archivo) {
        if (archivo != null) {
            File file = new File(archivo);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public PhotoController() {
        pantallaImagenCapturada = false;
        servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    }
}
