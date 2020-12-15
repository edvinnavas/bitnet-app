package bitnet;

import java.io.Serializable;
import javax.faces.annotation.FacesConfig;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "Index")
@ViewScoped
@FacesConfig(version = javax.faces.annotation.FacesConfig.Version.JSF_2_3)
public class Index implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Long id_usuario;
    private String nombre_usuario;
    private String pagina_seleccionada;
    
    public Index() {
        this.id_usuario = new Long(0);
        this.nombre_usuario = "No autenticado";
        this.pagina_seleccionada = "inicio";
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPagina_seleccionada() {
        return pagina_seleccionada + ".xhtml";
    }

    public void setPagina_seleccionada(String pagina_seleccionada) {
        this.pagina_seleccionada = pagina_seleccionada;
    }
    
}
