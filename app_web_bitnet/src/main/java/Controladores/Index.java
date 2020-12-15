package Controladores;

import Entidades.RestCredential;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level; 
import java.util.logging.Logger;
import javax.faces.annotation.FacesConfig;

@Named(value = "Index")
@ViewScoped
@FacesConfig(version = javax.faces.annotation.FacesConfig.Version.JSF_2_3)
public class Index implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<RestCredential> lst_rest_credential;
    
    public Index() {
        try {
            EntityManagerFactory entity_manager_factory = Persistence.createEntityManagerFactory("persistencia_web_bitnet");
            EntityManager entity_manager = entity_manager_factory.createEntityManager();
            this.lst_rest_credential = (List<RestCredential>) entity_manager.createQuery("SELECT rc FROM RestCredential rc", RestCredential.class).getResultList();
        } catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.toString());
        }
    }

    public List<RestCredential> getLst_rest_credential() {
        return lst_rest_credential;
    }

    public void setLst_rest_credential(List<RestCredential> lst_rest_credential) {
        this.lst_rest_credential = lst_rest_credential;
    }
    
}
