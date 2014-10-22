/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.RCE.datosDemograficosBeans;

import cl.entities.datosDemograficos.Nacionalidad;
import cl.sessions.datosDemograficos.BussinessFacade;
import cl.sessions.datosDemograficos.BussinessFacadeLocal;
import cl.sessions.datosDemograficos.NacionalidadFacade;
import cl.sessions.datosDemograficos.NacionalidadFacadeLocal;
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
public class NacionalidadesBean {
    
    @EJB
    private final BussinessFacadeLocal bussinessFacade;
    @EJB
    private final NacionalidadFacadeLocal nacionalidadFacade;
    private Nacionalidad nacionalidad;
    private Nacionalidad selectedNacionalidad;
    private List<Nacionalidad> nacionalidades;
    private List<Nacionalidad> filterNacionalidades;
    private boolean botones;
    
    public NacionalidadesBean() {
        nacionalidadFacade = new NacionalidadFacade();
        bussinessFacade = new BussinessFacade();
    }
    
    @PostConstruct
    public void myInitMethod() {
        nacionalidades = nacionalidadFacade.findAll2("nacionalidadCodigo");
        botones = true;
        nacionalidad = new Nacionalidad();
    }

    //metodos
    public void onRowSelect() {
        botones = false;
        nacionalidad = selectedNacionalidad;
    }
    
    public void createNacionalidad(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        nacionalidad.setNacionalidadDescripcion(nacionalidad.getNacionalidadDescripcion().toUpperCase());
        if (nacionalidad.getNacionalidadDescripcion().isEmpty()
                || nacionalidad.getNacionalidadDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion de la Nacionaldiad", null));
        } else {
            if (bussinessFacade.findNacionalidad(nacionalidad.getNacionalidadDescripcion())) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nacionalidad Creada", null));
                nacionalidadFacade.create(nacionalidad);
                nacionalidades = nacionalidadFacade.findAll2("nacionalidadCodigo");
                formulario = "formCreateNacionaldiad";
                dialog = "dlg1";
                creado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Nacionalidad ya Ingresada", null));
            }
        }
        nacionalidad = new Nacionalidad();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    public void updateNacionalidad(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        nacionalidad.setNacionalidadDescripcion(nacionalidad.getNacionalidadDescripcion().toUpperCase());
        if (nacionalidad.getNacionalidadDescripcion().isEmpty()
                || nacionalidad.getNacionalidadDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion de la Nacionaldiad", null));
        } else {
            if (bussinessFacade.findNacionalidad(nacionalidad.getNacionalidadDescripcion())) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nacionalidad Editada", null));
                nacionalidadFacade.edit(nacionalidad);
                nacionalidades = nacionalidadFacade.findAll2("nacionalidadCodigo");
                formulario = "formCreateNacionaldiad";
                dialog = "dlg2";
                creado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Nacionalidad ya Ingresada", null));
            }
        }
        nacionalidad = new Nacionalidad();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }
    //get y set
    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }
    
    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    public Nacionalidad getSelectedNacionalidad() {
        return selectedNacionalidad;
    }
    
    public void setSelectedNacionalidad(Nacionalidad selectedNacionalidad) {
        this.selectedNacionalidad = selectedNacionalidad;
    }
    
    public List<Nacionalidad> getNacionalidades() {
        return nacionalidades;
    }
    
    public void setNacionalidades(List<Nacionalidad> nacionalidades) {
        this.nacionalidades = nacionalidades;
    }
    
    public List<Nacionalidad> getFilterNacionalidades() {
        return filterNacionalidades;
    }
    
    public void setFilterNacionalidades(List<Nacionalidad> filterNacionalidades) {
        this.filterNacionalidades = filterNacionalidades;
    }
    
    public boolean isBotones() {
        return botones;
    }
    
    public void setBotones(boolean botones) {
        this.botones = botones;
    }
    
}
