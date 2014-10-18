/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sessions.datosDemograficos;

import cl.entities.datosDemograficos.Comuna;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface ComunaFacadeLocal {

    void create(Comuna comuna);

    void edit(Comuna comuna);

    void remove(Comuna comuna);

    Comuna find(Object id);

    List<Comuna> findAll();
    
    List<Comuna> findAll2(String dato);

    List<Comuna> findRange(int[] range);

    int count();
    
}
