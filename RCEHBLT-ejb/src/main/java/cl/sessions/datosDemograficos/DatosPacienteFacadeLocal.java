/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sessions.datosDemograficos;

import cl.entities.datosDemograficos.DatosPaciente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface DatosPacienteFacadeLocal {

    void create(DatosPaciente datosPaciente);

    void edit(DatosPaciente datosPaciente);

    void remove(DatosPaciente datosPaciente);

    DatosPaciente find(Object id);

    List<DatosPaciente> findAll();

    List<DatosPaciente> findRange(int[] range);

    int count();
    
}
