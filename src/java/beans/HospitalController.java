package beans;

import modelo.Hospital;
import controllers.HospitalFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Inject;
import javax.faces.view.ViewScoped;

@Named(value = "hospitalController")
@ViewScoped
public class HospitalController extends AbstractController<Hospital> implements Serializable {

    @Inject
    private HospitalFacade ejbFacade;

    public HospitalController() {
        super(Hospital.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

}
