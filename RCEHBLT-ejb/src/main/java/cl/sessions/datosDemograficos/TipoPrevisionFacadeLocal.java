/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sessions.datosDemograficos;

import cl.entities.datosDemograficos.TipoPrevision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface TipoPrevisionFacadeLocal {

    void create(TipoPrevision tipoPrevision);

    void edit(TipoPrevision tipoPrevision);

    void remove(TipoPrevision tipoPrevision);

    TipoPrevision find(Object id);

    List<TipoPrevision> findAll();
    
    List<TipoPrevision> findAll2(String dato);

    List<TipoPrevision> findRange(int[] range);

    int count();
    
}
