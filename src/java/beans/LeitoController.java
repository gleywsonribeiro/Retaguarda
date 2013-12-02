package beans;

import modelo.Leito;
import controllers.LeitoFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Inject;
import javax.faces.view.ViewScoped;

@Named(value = "leitoController")
@ViewScoped
public class LeitoController extends AbstractController<Leito> implements Serializable {

    @Inject
    private LeitoFacade ejbFacade;
    
    private List<String> tipos;

    public LeitoController() {
        super(Leito.class);
        tipos = new ArrayList<>();
        tipos.add("Urgência");
        tipos.add("Emergência");
        tipos.add("Clínico");
        tipos.add("Especial");
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    public LeitoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(LeitoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }
    
}
