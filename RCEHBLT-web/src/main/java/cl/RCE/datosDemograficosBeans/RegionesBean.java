/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.RCE.datosDemograficosBeans;

import cl.entities.datosDemograficos.Region;
import cl.sessions.datosDemograficos.RegionFacade;
import cl.sessions.datosDemograficos.RegionFacadeLocal;
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
public class RegionesBean {
    @EJB
    private final RegionFacadeLocal regionFacade;
    
    private Region region;
    private Region selectedRegion;
    private List<Region> regiones;
    private List<Region> filterRegiones;
    private boolean botones;
    
    //Constructo de la Clase
    public RegionesBean() {
        regionFacade  = new RegionFacade();
        region = new Region();
        selectedRegion = new Region();
        botones = true;
    }
    
    //PostConstuct 
    @PostConstruct
    public void myInit(){
        regiones = regionFacade.findAll2("regionCodigo");
    }
    
    //Metodos
    
    public void onRowSelect(){
        region = selectedRegion;
        botones = false;
    }
    
    public void createRegion(){
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean estado = false;
        String formulario ="";
        String dialog = "";
        if(region.getRegionDescripcion().isEmpty() || region.getRegionDescripcion().equalsIgnoreCase("")){
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El Campo de la Descripcion Vacio",null));
        }else{
            regionFacade.create(region);
            regiones = regionFacade.findAll2("regionCodigo");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha Creado la Region",null));
            estado = true;
            formulario = "formNewNivelEducacional";//reseteo de formulario por jvascript del template
            dialog = "dgl1";
        }
        region = new Region();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", estado);
        reqContext.addCallbackParam("dialog", dialog);
        
    }
    
    public void updateRegion(){
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean estado = false;
        String formulario ="";
        String dialog = "";
        if(region.getRegionDescripcion().isEmpty() || region.getRegionDescripcion().equalsIgnoreCase("")){
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El Campo de la Descripcion Vacio",null));
        }else{
            regionFacade.edit(region);
            regiones = regionFacade.findAll2("regionCodigo");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha Editado la Region",null));
            estado = true;
            formulario = "formNewNivelEducacional";//reseteo de formulario por jvascript del template
            dialog = "dgl2";
        }
        region = new Region();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", estado);
        reqContext.addCallbackParam("dialog", dialog);
        
    }
    
    //Get and Set
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Region getSelectedRegion() {
        return selectedRegion;
    }

    public void setSelectedRegion(Region selectedRegion) {
        this.selectedRegion = selectedRegion;
    }

    public List<Region> getRegiones() {
        return regiones;
    }

    public void setRegiones(List<Region> regiones) {
        this.regiones = regiones;
    }

    public List<Region> getFilterRegiones() {
        return filterRegiones;
    }

    public void setFilterRegiones(List<Region> filterRegiones) {
        this.filterRegiones = filterRegiones;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }
    
    
}
