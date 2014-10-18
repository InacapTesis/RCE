/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sessions.datosDemograficos;

import cl.entities.datosDemograficos.SequenceTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface SequenceTableFacadeLocal {

    void create(SequenceTable sequenceTable);

    void edit(SequenceTable sequenceTable);

    void remove(SequenceTable sequenceTable);

    SequenceTable find(Object id);

    List<SequenceTable> findAll();

    List<SequenceTable> findRange(int[] range);

    int count();
    
}
