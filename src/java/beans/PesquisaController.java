/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Paciente;

/**
 *
 * @author gleywson
 */
@ManagedBean(name = "pesquisa")
@RequestScoped
public class PesquisaController {

    @PersistenceContext(unitName = "TestePU")
    private EntityManager em;
    
    public PesquisaController() {
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
 
    List<Paciente> buscaPacientes(String nome) {
        Query query = getEntityManager().createQuery(nome);
        return query.getResultList();
    }
}
