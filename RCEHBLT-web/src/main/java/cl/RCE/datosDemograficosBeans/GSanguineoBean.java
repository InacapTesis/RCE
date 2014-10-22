/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.RCE.datosDemograficosBeans;

import cl.entities.datosDemograficos.GrupoSanguineo;
import cl.sessions.datosDemograficos.BussinessFacade;
import cl.sessions.datosDemograficos.BussinessFacadeLocal;
import cl.sessions.datosDemograficos.GrupoSanguineoFacade;
import cl.sessions.datosDemograficos.GrupoSanguineoFacadeLocal;
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
public class GSanguineoBean {

    @EJB
    private final BussinessFacadeLocal bussinessFacade;
    @EJB
    private final GrupoSanguineoFacadeLocal grupoSanguineoFacade;
    private GrupoSanguineo grupoSanguineo;
    private GrupoSanguineo selectedGrupoSanguineo;
    private List<GrupoSanguineo> gruposSanguineos;
    private List<GrupoSanguineo> filterGruposanguineo;
    private boolean botones;

    public GSanguineoBean() {
        bussinessFacade = new BussinessFacade();
        grupoSanguineoFacade = new GrupoSanguineoFacade();
    }

    //postconstuct
    @PostConstruct
    public void myInitMethod() {
        gruposSanguineos = grupoSanguineoFacade.findAll2("gsanguineoCodigo");
        botones = true;
        grupoSanguineo = new GrupoSanguineo();
    }
    //metodos

    public void onRowSelect() {
        botones = false;
        grupoSanguineo = selectedGrupoSanguineo;
    }

    public void createGrupoSanguineo(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        grupoSanguineo.setGsanguineoDescripcion(grupoSanguineo.getGsanguineoDescripcion().toUpperCase());
        if (grupoSanguineo.getGsanguineoDescripcion().isEmpty()
                || grupoSanguineo.getGsanguineoDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion del Grupo Sanguineo", null));
        } else {
            if (bussinessFacade.findGrupoSanguineo(grupoSanguineo.getGsanguineoDescripcion())) {
                grupoSanguineoFacade.create(grupoSanguineo);
                gruposSanguineos = grupoSanguineoFacade.findAll2("gsanguineoCodigo");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado Civil Creado", null));
                formulario = "formCreateGrupoSanguineo";
                dialog = "dlg1";
                creado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Grupo Sanguineo ya Ingresado", null));
            }
        }
        grupoSanguineo = new GrupoSanguineo();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }
    
    public void updateGrupoSanguineo(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        grupoSanguineo.setGsanguineoDescripcion(grupoSanguineo.getGsanguineoDescripcion().toUpperCase());
        if (grupoSanguineo.getGsanguineoDescripcion().isEmpty()
                || grupoSanguineo.getGsanguineoDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion del Grupo Sanguineo", null));
        } else {
            if (bussinessFacade.findGrupoSanguineo(grupoSanguineo.getGsanguineoDescripcion())) {
                grupoSanguineoFacade.edit(grupoSanguineo);
                gruposSanguineos = grupoSanguineoFacade.findAll2("gsanguineoCodigo");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado Civil Creado", null));
                formulario = "formCreateGrupoSanguineo";
                dialog = "dlg1";
                creado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Grupo Sanguineo ya Ingresado", null));
            }
        }
        grupoSanguineo = new GrupoSanguineo();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    //get y set
    public GrupoSanguineo getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(GrupoSanguineo grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public GrupoSanguineo getSelectedGrupoSanguineo() {
        return selectedGrupoSanguineo;
    }

    public void setSelectedGrupoSanguineo(GrupoSanguineo selectedGrupoSanguineo) {
        this.selectedGrupoSanguineo = selectedGrupoSanguineo;
    }

    public List<GrupoSanguineo> getGruposSanguineos() {
        return gruposSanguineos;
    }

    public void setGruposSanguineos(List<GrupoSanguineo> gruposSanguineos) {
        this.gruposSanguineos = gruposSanguineos;
    }

    public List<GrupoSanguineo> getFilterGruposanguineo() {
        return filterGruposanguineo;
    }

    public void setFilterGruposanguineo(List<GrupoSanguineo> filterGruposanguineo) {
        this.filterGruposanguineo = filterGruposanguineo;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }

}
