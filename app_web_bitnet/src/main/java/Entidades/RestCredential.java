package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rest_credential")
public class RestCredential implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_rest_credential")
    private Long id_rest_credential;
    
    @Column(name = "usuario", length = 50, nullable = false)
    private String usuario;
    
    @Column(name = "contrasena", length = 50, nullable = false)
    private String contrasena;
    
    public RestCredential() {
        
    }

    public RestCredential(Long id_rest_credential, String usuario, String contrasena) {
        this.id_rest_credential = id_rest_credential;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Long getId_rest_credential() {
        return id_rest_credential;
    }

    public void setId_rest_credential(Long id_rest_credential) {
        this.id_rest_credential = id_rest_credential;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    @Override
    public String toString() {
        return "RestCredential{" + "id_rest_credential=" + id_rest_credential + ", usuario=" + usuario + ", contrasena=" + contrasena + '}';
    }
    
}
