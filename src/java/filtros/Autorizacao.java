/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author Gleywson
 */
public class Autorizacao implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext fc = FacesContext.getCurrentInstance();
        String currentPage = fc.getViewRoot().getViewId();
        
        boolean isLoginPage = (currentPage.lastIndexOf("login.xhtml") > -1);
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
        Usuario currentUser = (Usuario) session.getAttribute("currentUser");
        
        if(!isLoginPage && currentUser == null) {
            NavigationHandler nh = fc.getApplication().getNavigationHandler();
            nh.handleNavigation(fc, null, "loginPage");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
