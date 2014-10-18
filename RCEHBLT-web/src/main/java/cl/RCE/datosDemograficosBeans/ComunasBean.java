/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.RCE.datosDemograficosBeans;

import cl.entities.datosDemograficos.Ciudad;
import cl.entities.datosDemograficos.Comuna;
import cl.sessions.datosDemograficos.CiudadFacade;
import cl.sessions.datosDemograficos.CiudadFacadeLocal;
import cl.sessions.datosDemograficos.ComunaFacade;
import cl.sessions.datosDemograficos.ComunaFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@RequestScoped
public class ComunasBean {
    @EJB
    private final CiudadFacadeLocal ciudadFacade;
    @EJB
    private final ComunaFacadeLocal comunaFacade;
    private List<Comuna> comunas;
    private List<Ciudad> ciudades;
    private List<Comuna> filterComunas;
    private Comuna comuna;
    private Comuna selectedComuna;
    private boolean botones;
    private Integer idCiudad;
   //Constructor base de la clase 
    public ComunasBean() {
        ciudadFacade = new CiudadFacade();
        comunaFacade = new ComunaFacade();
    }
    
    @PostConstruct
    public void myInitMethod(){
        comuna = new Comuna();
        selectedComuna = new Comuna();
        comunas = comunaFacade.findAll2("comunaCodigo");
        ciudades = ciudadFacade.findAll2("ciudadCodigo");
    }
    
    //get y set
    public List<Comuna> getComunas() {
        return comunas;
    }

    public void setComunas(List<Comuna> comunas) {
        this.comunas = comunas;
    }

    public List<Comuna> getFilterComunas() {
        return filterComunas;
    }

    public void setFilterComunas(List<Comuna> filterComunas) {
        this.filterComunas = filterComunas;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public Comuna getSelectedComuna() {
        return selectedComuna;
    }

    public void setSelectedComuna(Comuna selectedComuna) {
        this.selectedComuna = selectedComuna;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
    
    
    
}
