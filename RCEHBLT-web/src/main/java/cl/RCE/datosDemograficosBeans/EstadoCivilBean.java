/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.RCE.datosDemograficosBeans;

import cl.entities.datosDemograficos.EstadoCivil;
import cl.sessions.datosDemograficos.BussinessFacade;
import cl.sessions.datosDemograficos.BussinessFacadeLocal;
import cl.sessions.datosDemograficos.EstadoCivilFacade;
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
public class EstadoCivilBean {

    @EJB
    private final BussinessFacadeLocal bussinessFacade;
    @EJB
    private final cl.sessions.datosDemograficos.EstadoCivilFacadeLocal estadoCivilFacade;
    private EstadoCivil estadoCivil;
    private List<EstadoCivil> estadosCiviles;
    private List<EstadoCivil> filterEstadosCiviles;
    private EstadoCivil selectedEstadoCivil;
    private boolean btnModificar;

    //Contructores
    public EstadoCivilBean() {
        bussinessFacade = new BussinessFacade();
        estadoCivilFacade = new EstadoCivilFacade();
        selectedEstadoCivil = new EstadoCivil();
        estadoCivil = new EstadoCivil();
        btnModificar = true;
    }

    @PostConstruct
    public void myInit() {
        estadosCiviles = estadoCivilFacade.findAll2("estadoCivilCodigo");
    }
// Metodos

    public void createEstadoCivil(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        estadoCivil.setEstadoCivilDescripcion(estadoCivil.getEstadoCivilDescripcion().toUpperCase());
        if (estadoCivil.getEstadoCivilDescripcion().isEmpty()
                || estadoCivil.getEstadoCivilDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion del Estado Civil", null));
        } else {
            if (bussinessFacade.findEstadoCivilDesc(estadoCivil.getEstadoCivilDescripcion())) {
                estadoCivilFacade.create(estadoCivil);
                estadosCiviles = estadoCivilFacade.findAll2("estadoCivilCodigo");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado Civil Creado", null));
                formulario = "FormCreateEstadoCivil";
                dialog = "dlg1";
                creado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Estado Civil ya Ingresado", null));
            }
        }
        estadoCivil = new EstadoCivil();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    public void updateEstadoCivil(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean editado = false;
        String formulario = "";
        String dialog = "";
        estadoCivil.setEstadoCivilDescripcion(estadoCivil.getEstadoCivilDescripcion().toUpperCase());
        if (estadoCivil.getEstadoCivilDescripcion().isEmpty()
                || estadoCivil.getEstadoCivilDescripcion().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion del Estado Civil", null));
        } else {
            if (bussinessFacade.findEstadoCivilDesc(estadoCivil.getEstadoCivilDescripcion())) {
                estadoCivilFacade.edit(estadoCivil);
                estadosCiviles = estadoCivilFacade.findAll2("estadoCivilCodigo");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado Civil Editado", null));
                formulario = "FormCreateEstadoCivil";
                dialog = "dlg2";
                editado = true;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Estado Civil ya Ingresado", null));
            }
        }
        estadoCivil = new EstadoCivil();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", editado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    public void limpiarDatos(ActionEvent event) {
        estadoCivil = new EstadoCivil();
    }

    public void onRowSelect() {
        estadoCivil = selectedEstadoCivil;
        btnModificar = false;
    }

//Getter an Setter
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<EstadoCivil> getEstadosCiviles() {
        return estadosCiviles;
    }

    public void setEstadosCiviles(List<EstadoCivil> estadosCiviles) {
        this.estadosCiviles = estadosCiviles;
    }

    public List<EstadoCivil> getFilterEstadosCiviles() {
        return filterEstadosCiviles;
    }

    public void setFilterEstadosCiviles(List<EstadoCivil> filterEstadosCiviles) {
        this.filterEstadosCiviles = filterEstadosCiviles;
    }

    public EstadoCivil getSelectedEstadoCivil() {
        return selectedEstadoCivil;
    }

    public void setSelectedEstadoCivil(EstadoCivil selectedEstadoCivil) {
        this.selectedEstadoCivil = selectedEstadoCivil;
    }

    public boolean isBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(boolean btnModificar) {
        this.btnModificar = btnModificar;
    }

}
