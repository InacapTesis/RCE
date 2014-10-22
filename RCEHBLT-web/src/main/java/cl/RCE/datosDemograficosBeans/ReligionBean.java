/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.RCE.datosDemograficosBeans;

import cl.entities.datosDemograficos.Religion;
import cl.sessions.datosDemograficos.BussinessFacade;
import cl.sessions.datosDemograficos.BussinessFacadeLocal;
import cl.sessions.datosDemograficos.ReligionFacade;
import cl.sessions.datosDemograficos.ReligionFacadeLocal;
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
public class ReligionBean {

    @EJB
    private final ReligionFacadeLocal religionFacade;
    @EJB
    private final BussinessFacadeLocal bussinessFacade;
    private Religion religion;
    private Religion selectedReligion;
    private List<Religion> religiones;
    private List<Religion> filterReligiones;
    boolean botones;

    //constructor
    public ReligionBean() {
        bussinessFacade = new BussinessFacade();
        religionFacade = new ReligionFacade();
    }

//postconstuct
    @PostConstruct
    public void myInitMethod() {
        religion = new Religion();
        religiones = religionFacade.findAll2("religionCodigo");
        botones = true;
    }
//metodos

    public void onRowSelect() {
        religion = selectedReligion;
        botones = false;
    }

    public void createReligion(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        religion.setReligionDescripcion(religion.getReligionDescripcion().toUpperCase());
        if (religion.getReligionDescripcion().isEmpty() || religion.getReligionDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion de la Religion", null));
        } else {
            if (bussinessFacade.findRegionDesc(religion.getReligionDescripcion())) {
                religionFacade.create(religion);
                religiones = religionFacade.findAll2("religionCodigo");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Religion Creada", null));
                formulario = "formCreateReligion";
                dialog = "dlg1";
                creado = true;
            }else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Religion ya Ingresada", null));
            }
        }
        religion = new Religion();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    public void updateReligion(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        religion.setReligionDescripcion(religion.getReligionDescripcion().toUpperCase());
        if (religion.getReligionDescripcion().isEmpty() || religion.getReligionDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion de la Religion", null));
        } else {
            if (bussinessFacade.findRegionDesc(religion.getReligionDescripcion())) {
                religionFacade.edit(religion);
                religiones = religionFacade.findAll2("religionCodigo");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Religion Creada", null));
                formulario = "formCreateReligion";
                dialog = "dlg1";
                creado = true;
            }else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Religion ya Ingresada", null));
            }
        }
        religion = new Religion();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }
//get and set
    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Religion getSelectedReligion() {
        return selectedReligion;
    }

    public void setSelectedReligion(Religion selectedReligion) {
        this.selectedReligion = selectedReligion;
    }

    public List<Religion> getReligiones() {
        return religiones;
    }

    public void setReligiones(List<Religion> religiones) {
        this.religiones = religiones;
    }

    public List<Religion> getFilterReligiones() {
        return filterReligiones;
    }

    public void setFilterReligiones(List<Religion> filterReligiones) {
        this.filterReligiones = filterReligiones;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }

}
