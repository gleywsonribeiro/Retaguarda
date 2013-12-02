package beans;

import modelo.Usuario;
import controllers.UsuarioFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Inject;
import javax.faces.view.ViewScoped;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> implements Serializable {

    @Inject
    private UsuarioFacade ejbFacade;

    public UsuarioController() {
        super(Usuario.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

}
