/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sessions.datosDemograficos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AndresEduardo
 */
@Stateless
public class BussinessFacade implements BussinessFacadeLocal{
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public boolean findRegionDesc(String regAux) {
        Query q = em.createQuery("SELECT r FROM Region r WHERE r.regionDescripcion = :regDesc");
        q.setParameter("regDesc", regAux);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean findCiudadDesc(String Aux) {
        Query q = em.createQuery("SELECT c FROM Ciudad c WHERE c.ciudadNombre = :nombre");
        q.setParameter("nombre", Aux);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean findComunaDesc(String Aux) {
        Query q = em.createQuery("SELECT c FROM Comuna c WHERE c.comunaNombre = :nombre");
        q.setParameter("nombre", Aux);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean findNivelEduDesc(String Aux) {
        Query q = em.createQuery("SELECT ne FROM NivelEducacional ne WHERE ne.educDescripcion = :niveldesc");
        q.setParameter("niveldesc", Aux);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean findEstadoCivilDesc(String Aux) {
        Query q = em.createQuery("SELECT ec FROM EstadoCivil ec WHERE ec.estadoCivilDescripcion = :ecDesc");
        q.setParameter("ecDesc", Aux);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean findGrupoSanguineo(String Aux) {
        Query q = em.createQuery("SELECT gs FROM GrupoSanguineo gs WHERE gs.gsanguineoDescripcion = :grupo");
        q.setParameter("grupo", Aux);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean findNacionalidad(String Aux) {
        Query q = em.createQuery("SELECT n FROM Nacionalidad n WHERE n.nacionalidadDescripcion = :nacionalidad");
        q.setParameter("nacionalidad", Aux);
        return q.getResultList().isEmpty();
    }
    
    @Override
    public boolean findTipoPrevision(String Aux){
        Query q = em.createQuery("SELECT tp FROM TipoPrevision tp WHERE tp.tprevisionDescripcion = :tipoPrev");
        q.setParameter("tipoPrev", Aux);
        return q.getResultList().isEmpty();
    }

    @Override
    public boolean findPrevision(String Aux) {
        Query q = em.createQuery("SELECT p FROM Prevision p WHERE p.previsionDescripcion = :Prev");
        q.setParameter("Prev", Aux);
        return q.getResultList().isEmpty();
    }
}
