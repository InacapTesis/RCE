/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sessions.datosDemograficos;

import cl.entities.datosDemograficos.NivelEducacional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface NivelEducacionalFacadeLocal {

    void create(NivelEducacional nivelEducacional);

    void edit(NivelEducacional nivelEducacional);

    void remove(NivelEducacional nivelEducacional);

    NivelEducacional find(Object id);

    List<NivelEducacional> findAll();

    List<NivelEducacional> findAll2(String dato);
    
    List<NivelEducacional> findRange(int[] range);

    int count();
    
}
