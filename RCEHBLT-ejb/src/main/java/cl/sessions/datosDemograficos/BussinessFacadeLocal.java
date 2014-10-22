/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.sessions.datosDemograficos;

import javax.ejb.Local;

/**
 *
 * @author AndresEduardo
 */
@Local
public interface BussinessFacadeLocal {
    
    //Metodos de Busqueda para no repetir los datos
    
    public boolean findRegionDesc(String regAux);
    public boolean findCiudadDesc(String Aux);
    public boolean findComunaDesc(String Aux);
    public boolean findNivelEduDesc(String Aux);
    public boolean findEstadoCivilDesc(String Aux);
    public boolean findGrupoSanguineo(String Aux);
    public boolean findNacionalidad(String Aux);
    public boolean findTipoPrevision(String Aux);
    public boolean findPrevision(String Aux);
}
