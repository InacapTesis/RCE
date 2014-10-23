/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.RCE.CoverterPackage;

import cl.entities.datosDemograficos.TipoPrevision;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author AndresEduardo
 */
@FacesConverter(value = "tipoPrevisionConverter", forClass = TipoPrevision.class)
public class TipoPrevisionesConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent arg1, String arg2) throws ConverterException {
        if (arg2.trim().equals("")) {
            return null;
        } else {
            return new TipoPrevision(Integer.parseInt(arg2));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent arg1, Object arg2) throws ConverterException{
        if (arg2 == null || arg2.equals("")) {
            return "";
        } else {
            return String.valueOf(((TipoPrevision) arg2).getTprevisionCodigo());
        }
    }
    
}
