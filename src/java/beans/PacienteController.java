package beans;

import modelo.Paciente;
import controllers.PacienteFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Inject;
import javax.faces.view.ViewScoped;

@Named(value = "pacienteController")
@ViewScoped
public class PacienteController extends AbstractController<Paciente> implements Serializable {

    @Inject
    private PacienteFacade ejbFacade;
    
    private List<String> especialidades;

    public PacienteController() {
        super(Paciente.class);
        especialidades = new ArrayList<>();
        especialidades.add("ortopédica");
        especialidades.add("traumatológica");
        especialidades.add("pediátrica");
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidade(List<String> especialidade) {
        this.especialidades = especialidade;
    }
    
    
}
