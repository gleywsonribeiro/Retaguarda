/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Leito;

/**
 *
 * @author Gleywson
 */
@Stateless
public class LeitoFacade extends AbstractFacade<Leito> {
    @PersistenceContext(unitName = "TestePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

//    public List<Leito> getLeitosVagos() {
//        return getEntityManager().createQuery("SELECT leito FROM Leito leito WHERE LEITO.ocupado = :false").getResultList();
//    }
//    
    public LeitoFacade() {
        super(Leito.class);
    }
    
}
