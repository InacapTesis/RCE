/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.RCE.datosDemograficosBeans;

import cl.entities.datosDemograficos.TipoPrevision;
import cl.sessions.datosDemograficos.BussinessFacade;
import cl.sessions.datosDemograficos.BussinessFacadeLocal;
import cl.sessions.datosDemograficos.TipoPrevisionFacade;
import cl.sessions.datosDemograficos.TipoPrevisionFacadeLocal;
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
public class TipoPrevisionBean {

    @EJB
    private final BussinessFacadeLocal bussinessFacade;
    @EJB
    private final TipoPrevisionFacadeLocal tipoPrevisionFacade;
    
    private TipoPrevision prevision;
    private TipoPrevision selectedPrevision;
    private List<TipoPrevision> previsiones;
    private List<TipoPrevision> filterPrevisiones;
    private boolean botones;

    public TipoPrevisionBean() {
        bussinessFacade = new BussinessFacade();
        tipoPrevisionFacade = new TipoPrevisionFacade();
    }

    @PostConstruct
    public void myInitMethod() {
        prevision = new TipoPrevision();
        previsiones = tipoPrevisionFacade.findAll2("tprevisionCodigo");
        botones = true;
    }

    //Metodos
    public void onRowSelect() {
        prevision = selectedPrevision;
        botones = false;
    }

    public void createTipoPrevision(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        prevision.setTprevisionDescripcion(prevision.getTprevisionDescripcion().toUpperCase());
        if (prevision.getTprevisionDescripcion().isEmpty()
                || prevision.getTprevisionDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion de la Prevision",
                    null));
        } else {
            if (bussinessFacade.findTipoPrevision(prevision.getTprevisionDescripcion())) {
                tipoPrevisionFacade.create(prevision);
                previsiones = tipoPrevisionFacade.findAll2("tprevisionCodigo");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Prevision Editada",null));
                formulario = "formCreatePrevision";
                dialog = "dlg1";
                creado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Prevision ya Ingresada",
                        null));
            }
        }
        prevision = new TipoPrevision();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    public void updateTipoPrevision(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        prevision.setTprevisionDescripcion(prevision.getTprevisionDescripcion().toUpperCase());
        if (prevision.getTprevisionDescripcion().isEmpty()
                || prevision.getTprevisionDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion de la Prevision",
                    null));
        } else {
            if (bussinessFacade.findTipoPrevision(prevision.getTprevisionDescripcion())) {
                tipoPrevisionFacade.edit(prevision);
                previsiones = tipoPrevisionFacade.findAll2("tprevisionCodigo");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Prevision Editada",null));
                formulario = "formCreatePrevision";
                dialog = "dlg2";
                creado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Prevision ya Ingresada",
                        null));
            }
        }
        prevision = new TipoPrevision();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    //get y set
    public TipoPrevision getPrevision() {
        return prevision;
    }

    public void setPrevision(TipoPrevision prevision) {
        this.prevision = prevision;
    }

    public TipoPrevision getSelectedPrevision() {
        return selectedPrevision;
    }

    public void setSelectedPrevision(TipoPrevision selectedPrevision) {
        this.selectedPrevision = selectedPrevision;
    }

    public List<TipoPrevision> getPrevisiones() {
        return previsiones;
    }

    public void setPrevisiones(List<TipoPrevision> previsiones) {
        this.previsiones = previsiones;
    }

    public List<TipoPrevision> getFilterPrevisiones() {
        return filterPrevisiones;
    }

    public void setFilterPrevisiones(List<TipoPrevision> filterPrevisiones) {
        this.filterPrevisiones = filterPrevisiones;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }

}
