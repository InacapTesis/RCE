/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sessions.datosDemograficos;

import cl.entities.datosDemograficos.GrupoSanguineo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface GrupoSanguineoFacadeLocal {

    void create(GrupoSanguineo grupoSanguineo);

    void edit(GrupoSanguineo grupoSanguineo);

    void remove(GrupoSanguineo grupoSanguineo);

    GrupoSanguineo find(Object id);

    List<GrupoSanguineo> findAll();
    
    List<GrupoSanguineo> findAll2(String dato);

    List<GrupoSanguineo> findRange(int[] range);

    int count();
    
}
