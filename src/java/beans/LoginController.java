/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.util.JsfUtil;
import controllers.UsuarioFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author Gleywson
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController extends AbstractController<Usuario> implements Serializable {

    @Inject
    private UsuarioFacade facade;
    private Usuario usuario;

    public LoginController() {
        super(Usuario.class);
        this.usuario = new Usuario();
    }

    public void init() {
        super.setFacade(facade);
    }

    public String saudacao() {
        Calendar calendario = Calendar.getInstance();

        int hora = calendario.get(Calendar.HOUR_OF_DAY);

        String saida = "Bom dia";
        if (hora > 12) {
            saida = "Boa tarde";
        }
        if (hora > 18) {
            saida = "Boa noite";
        }
        return saida;
    }

    public String login() {
        List<Usuario> lista = facade.findAll();

        for (Usuario user : lista) {

            if (user.getLogin().equals(usuario.getLogin()) && user.getSenha().equals(usuario.getSenha())) {
                FacesContext context = FacesContext.getCurrentInstance();
                HttpSession httpSession = (HttpSession) context.getExternalContext().getSession(false);
                this.usuario = user;
                httpSession.setAttribute("currentUser", usuario);
                return "index";
            }
        }
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bem vindo "+usuario.getLogin()));
        JsfUtil.addErrorMessage("Usuario ou senha inválidos!");
        return "login";

    }

    public void logout() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) fc.getExternalContext().getSession(false);
        httpSession.setAttribute("currentUser", null);
        try {
            fc.getExternalContext().redirect(fc.getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        httpSession.invalidate();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
