/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.RCE.datosDemograficosBeans;

import cl.entities.datosDemograficos.Prevision;
import cl.sessions.datosDemograficos.BussinessFacade;
import cl.sessions.datosDemograficos.BussinessFacadeLocal;
import cl.sessions.datosDemograficos.PrevisionFacade;
import cl.sessions.datosDemograficos.PrevisionFacadeLocal;
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
public class previsionBean {

    @EJB
    private final PrevisionFacadeLocal previsionFacade;
    @EJB
    private final BussinessFacadeLocal bussinessFacade;
    private Prevision prevision;
    private Prevision selectedPrevision;
    private List<Prevision> previsiones;
    private List<Prevision> filterPrevisiones;
    private boolean botones;

    public previsionBean() {
        previsionFacade = new PrevisionFacade();
        bussinessFacade = new BussinessFacade();
    }

    @PostConstruct
    public void myInitMethod() {
        previsiones = previsionFacade.findAll2("previsionCodigo");
        botones = true;
        prevision = new Prevision();
    }

    //metodos
    public void onRowSelect() {
        botones = false;
        prevision = selectedPrevision;
    }

    public void createPrevision(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        prevision.setPrevisionDescripcion(prevision.getPrevisionDescripcion().toUpperCase());
        if (prevision.getPrevisionDescripcion().isEmpty()
                || prevision.getPrevisionDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion del Tipo de Prevision", null));
        } else {
            if (bussinessFacade.findTipoPrevision(prevision.getPrevisionDescripcion())) {
                previsionFacade.create(prevision);
                previsiones = previsionFacade.findAll2("previsionCodigo");
                formulario = "formCreatePrevision";
                dialog = "dlg1";
                creado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Tipo de Prevision ya Ingresada", null));
            }
        }
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    public void editPrevision(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        prevision.setPrevisionDescripcion(prevision.getPrevisionDescripcion().toUpperCase());
        if (prevision.getPrevisionDescripcion().isEmpty()
                || prevision.getPrevisionDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion del Tipo de Prevision", null));
        } else {
            if (bussinessFacade.findTipoPrevision(prevision.getPrevisionDescripcion())) {
                previsionFacade.edit(prevision);
                previsiones = previsionFacade.findAll2("previsionCodigo");
                formulario = "formCreatePrevision";
                dialog = "dlg2";
                creado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Tipo de Prevision ya Ingresada", null));
            }
        }
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    //get and set
    public Prevision getPrevision() {
        return prevision;
    }

    public void setPrevision(Prevision prevision) {
        this.prevision = prevision;
    }

    public Prevision getSelectedPrevision() {
        return selectedPrevision;
    }

    public void setSelectedPrevision(Prevision selectedPrevision) {
        this.selectedPrevision = selectedPrevision;
    }

    public List<Prevision> getPrevisiones() {
        return previsiones;
    }

    public void setPrevisiones(List<Prevision> previsiones) {
        this.previsiones = previsiones;
    }

    public List<Prevision> getFilterPrevisiones() {
        return filterPrevisiones;
    }

    public void setFilterPrevisiones(List<Prevision> filterPrevisiones) {
        this.filterPrevisiones = filterPrevisiones;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }

}
