/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.RCE.datosDemograficosBeans;

import cl.entities.datosDemograficos.NivelEducacional;
import cl.sessions.datosDemograficos.NivelEducacionalFacade;
import cl.sessions.datosDemograficos.NivelEducacionalFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@RequestScoped
public class NivelEducacionalBean {
    @EJB
    private NivelEducacionalFacadeLocal nivelEducacionalFacade;
    private NivelEducacional nivelEducacional;
    private NivelEducacional selectedNivelEducacional;
    private List<NivelEducacional> nivelesEducacionales;
    private List<NivelEducacional> filterNivelesEducacionales;
    private boolean botones;
    
    
    
    public NivelEducacionalBean() {
        nivelEducacionalFacade = new NivelEducacionalFacade();
        nivelEducacional = new NivelEducacional();
        selectedNivelEducacional = new NivelEducacional();
        botones = true;
    }
    //PostConstruct
    @PostConstruct
    public void myInitMethod(){
        nivelesEducacionales = nivelEducacionalFacade.findAll2("educCodigo");
    }
    
    //Metodos
    public void onRowSelected(){
        nivelEducacional = selectedNivelEducacional;
        botones = false;
    }
    
    public void createNivelEducacional(){
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        if(nivelEducacional.getEducDescripcion().equalsIgnoreCase("") || 
                nivelEducacional.getEducDescripcion().isEmpty()){
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion del Nivel Educacional",null));
        }else{
            nivelEducacionalFacade.create(nivelEducacional);
            nivelesEducacionales = nivelEducacionalFacade.findAll2("educCodigo");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha Creado el Nivel Educacional",null));
            creado = true;
            formulario = "formNewNivelEducacional";
            dialog = "dlg1";
        }
        nivelEducacional = new NivelEducacional();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }
     
    public void updateNivelEducacional(){
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        if(nivelEducacional.getEducDescripcion().equalsIgnoreCase("") || 
                nivelEducacional.getEducDescripcion().isEmpty()){
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe Ingresar Datos En Descripcion del Nivel Educacional",null));
        }else{
            nivelEducacionalFacade.edit(nivelEducacional);
            nivelesEducacionales = nivelEducacionalFacade.findAll2("educCodigo");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha Editado el Nivel Educacional",null));
            creado = true;
            formulario = "formNewNivelEducacional";
            dialog = "dlg1";
        }
        nivelEducacional = new NivelEducacional();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }
    
    
    
    //Get and Set
    public NivelEducacionalFacadeLocal getNivelEducacionalFacade() {
        return nivelEducacionalFacade;
    }

    public void setNivelEducacionalFacade(NivelEducacionalFacadeLocal nivelEducacionalFacade) {
        this.nivelEducacionalFacade = nivelEducacionalFacade;
    }

    public NivelEducacional getNivelEducacional() {
        return nivelEducacional;
    }

    public void setNivelEducacional(NivelEducacional nivelEducacional) {
        this.nivelEducacional = nivelEducacional;
    }

    public NivelEducacional getSelectedNivelEducacional() {
        return selectedNivelEducacional;
    }

    public void setSelectedNivelEducacional(NivelEducacional selectedNivelEducacional) {
        this.selectedNivelEducacional = selectedNivelEducacional;
    }

    public List<NivelEducacional> getNivelesEducacionales() {
        return nivelesEducacionales;
    }

    public void setNivelesEducacionales(List<NivelEducacional> nivelesEducacionales) {
        this.nivelesEducacionales = nivelesEducacionales;
    }

    public List<NivelEducacional> getFilterNivelesEducacionales() {
        return filterNivelesEducacionales;
    }

    public void setFilterNivelesEducacionales(List<NivelEducacional> filterNivelesEducacionales) {
        this.filterNivelesEducacionales = filterNivelesEducacionales;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }
    
    
    
}
