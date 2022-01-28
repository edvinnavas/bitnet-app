package bitnet;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.primefaces.PrimeFaces;

@ManagedBean(name = "Index")
@ViewScoped
public class Index implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id_usuario;
    private String nombre_usuario;
    private String contrasena;
    private String pagina_seleccionada;
    
    public Index() {
        try {
            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc_mysql");
            Connection conn = ds.getConnection();
            
            // InitialContext ctx = new InitialContext();
            // Context env = (Context) ctx.lookup("java:comp/env");
            // DataSource ds = (DataSource) env.lookup("jdbc_mysql");
            // Connection conn = ds.getConnection();
            
            String cadenasql = "SELECT u.id_usuario, u.nombre_completo FROM usuario u WHERE u.id_usuario=1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cadenasql);
            while(rs.next()) {
                this.id_usuario = rs.getLong(1);
                this.nombre_usuario = rs.getString(2);
            }
            rs.close();
            stmt.close();
            
            conn.close();
            
            this.contrasena = "No Password";
            this.pagina_seleccionada = "inicio";
        } catch(Exception ex) {
            System.out.println("ERROR: (" + this.getClass().getName() + ")(" + ex.toString() + ")");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje de apliación", ex.toString()));
        }
    }
    
    public void mostrar_dialog_login() {
        try {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje de apliación", "Autenticación de usuario."));
            PrimeFaces.current().executeScript("PF('dialogLoginVar').show();");
        } catch(Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje de apliación", ex.toString()));
        }
    }
    
    public void login() {
        try {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje de apliación", "Autenticación de usuario."));
            PrimeFaces.current().executeScript("PF('dialogLoginVar').hide();");
        } catch(Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje de apliación", ex.toString()));
        }
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
