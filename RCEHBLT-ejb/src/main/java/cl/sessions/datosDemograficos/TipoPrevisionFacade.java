/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sessions.datosDemograficos;

import cl.entities.datosDemograficos.TipoPrevision;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AndresEduardo
 */
@Stateless
public class TipoPrevisionFacade extends AbstractFacade<TipoPrevision> implements TipoPrevisionFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPrevisionFacade() {
        super(TipoPrevision.class);
    }
    
}
