/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.RCE.datosDemograficosBeans;

import cl.entities.datosDemograficos.Ciudad;
import cl.entities.datosDemograficos.Comuna;
import cl.entities.datosDemograficos.Region;
import cl.sessions.datosDemograficos.BussinessFacade;
import cl.sessions.datosDemograficos.BussinessFacadeLocal;
import cl.sessions.datosDemograficos.CiudadFacade;
import cl.sessions.datosDemograficos.CiudadFacadeLocal;
import cl.sessions.datosDemograficos.ComunaFacade;
import cl.sessions.datosDemograficos.ComunaFacadeLocal;
import cl.sessions.datosDemograficos.RegionFacade;
import cl.sessions.datosDemograficos.RegionFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@RequestScoped
public class ComunasBean {
    @EJB
    private final RegionFacadeLocal regionFacade;
    @EJB
    private final BussinessFacadeLocal bussinessFacade;
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
    private List<Region> regiones;
    private Integer idRegion;

    //Constructor base de la clase 
    public ComunasBean() {
        ciudadFacade = new CiudadFacade();
        comunaFacade = new ComunaFacade();
        bussinessFacade = new BussinessFacade();
        regionFacade = new RegionFacade();
        botones = true;
    }

    @PostConstruct
    public void myInitMethod() {
        comuna = new Comuna();
        selectedComuna = new Comuna();
        comunas = comunaFacade.findAll2("comunaCodigo");
        ciudades = ciudadFacade.findAll2("ciudadCodigo");
        regiones = regionFacade.findAll2("regionCodigo");
    }
    //metodos

    public void onChangeSelect(){
        ciudades = bussinessFacade.getListCiudadByFK(idRegion);
    }
    
    public void createComuna() {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        comuna.setComunaNombre(comuna.getComunaNombre().toUpperCase());
        if (comuna.getComunaNombre().isEmpty()
                || comuna.getComunaNombre().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion de la Comuna", null));
        } else {
            if (bussinessFacade.findComunaDesc(comuna.getComunaNombre())) {
                comunaFacade.create(comuna);
                comunas = comunaFacade.findAll2("comunaCodigo");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Comuna Creada", null));
                formulario = "formCreateComuna";
                dialog = "dlg1";
                creado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Comuna ya Registrada", null));
            }
        }
        comuna = new Comuna();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    public void updateCiudad(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        comuna.setComunaNombre(comuna.getComunaNombre().toUpperCase());
        if (comuna.getComunaNombre().isEmpty()
                || comuna.getComunaNombre().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion de la  Comuna", null));
        } else {
            if (bussinessFacade.findComunaDesc(comuna.getComunaNombre())) {
                Ciudad ciudad = ciudadFacade.find(idCiudad);
                comuna.setCiudadCodigo(ciudad);
                comunaFacade.edit(comuna);
                comunas = comunaFacade.findAll2("comunaCodigo");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Comuna Editada", null));
                formulario = "formCreateComuna";
                dialog = "dlg2";
                creado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Comuna ya Registrada", null));
            }
        }
        comuna = new Comuna();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    public void onRowSelect() {
        botones = false;
        if (!botones) {
            System.out.println("falso");
        }
        comuna = selectedComuna;
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

    public List<Region> getRegiones() {
        return regiones;
    }

    public void setRegiones(List<Region> regiones) {
        this.regiones = regiones;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }
    
    

}
