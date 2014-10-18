/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sessions.datosDemograficos;

import cl.entities.datosDemograficos.Religion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface ReligionFacadeLocal {

    void create(Religion religion);

    void edit(Religion religion);

    void remove(Religion religion);

    Religion find(Object id);

    List<Religion> findAll();

    List<Religion> findRange(int[] range);

    int count();
    
}
