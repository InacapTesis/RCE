/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.RCE.datosDemograficosBeans;

import cl.entities.datosDemograficos.Ciudad;
import cl.entities.datosDemograficos.Region;
import cl.sessions.datosDemograficos.CiudadFacade;
import cl.sessions.datosDemograficos.CiudadFacadeLocal;
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
public class CiudadesBean {

    @EJB
    private final RegionFacadeLocal regionFacade;
    @EJB
    private final CiudadFacadeLocal ciudadFacade;
    private Ciudad ciudad;
    private Ciudad selectedCiudad;
    private List<Ciudad> ciudades;
    private List<Ciudad> filterCiudades;
    private boolean botones;
    private List<Region> regiones;
    private Region region;
    private Integer idRegion;

    //Constructor Clase
    public CiudadesBean() {
        ciudadFacade = new CiudadFacade();
        regionFacade = new RegionFacade();

    }

    //PostConstuct
    @PostConstruct
    public void myInit() {
        ciudades = ciudadFacade.findAll2("ciudadCodigo");
        regiones = regionFacade.findAll2("regionCodigo");
        ciudad = new Ciudad();
        ciudad.setRegionCodigo(new Region());
        region = new Region();
        botones = true;
    }

    //Metodos
    public void onRowSelect() {
        botones = false;
        ciudad = selectedCiudad;
        regiones = regionFacade.findAll2("regionCodigo");
        System.out.println("Ciudad: " + ciudad.getCiudadNombre()+ " codigo: "+ciudad.getCiudadCodigo());
        System.out.println("Region: " + ciudad.getRegionCodigo().getRegionDescripcion()+ " codigo " +ciudad.getRegionCodigo().getRegionCodigo() );
    }
    
    public void createCiudad(ActionEvent event) {
        System.out.println("Entro al Create");
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        if (ciudad.getCiudadNombre().isEmpty()
                || ciudad.getCiudadNombre().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion del Estado Civil", null));
            System.out.println("campos erroneos");
        } else {
            System.out.println("entro al else");
            System.out.println("Ciudad: " + ciudad.getCiudadNombre());
            System.out.println("Region: " + ciudad.getRegionCodigo().getRegionDescripcion());
            ciudadFacade.create(ciudad);
            ciudades = ciudadFacade.findAll2("ciudadCodigo");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ciudad Creada", null));
            formulario = "formCreateCiudad";
            dialog = "dlg1";
            creado = true;
        }
        ciudad = new Ciudad();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }

    public void updateCiudad(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        RequestContext reqContext = RequestContext.getCurrentInstance();
        System.out.println("Ciudad: " + ciudad.getCiudadNombre());
        System.out.println("Region: " + ciudad.getRegionCodigo().getRegionDescripcion());
        boolean creado = false;
        String formulario = "";
        String dialog = "";
        if (ciudad.getCiudadNombre().isEmpty()
                || ciudad.getCiudadNombre().equalsIgnoreCase("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe Ingresar Datos En Descripcion del Estado Civil", null));
        } else {
            System.out.println("entro al else");
            System.out.println("Ciudad: " + ciudad.getCiudadNombre());
            System.out.println("Region: " + ciudad.getRegionCodigo().getRegionDescripcion());
            region = regionFacade.find(idRegion);
            ciudad.setRegionCodigo(region);
            ciudadFacade.edit(ciudad);
            ciudades = ciudadFacade.findAll2("ciudadCodigo");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ciudad Editada", null));
            formulario = "formCreateCiudad";
            dialog = "dlg2";
            creado = true;
        }
        ciudad = new Ciudad();
        reqContext.addCallbackParam("formulario", formulario);
        reqContext.addCallbackParam("creado", creado);
        reqContext.addCallbackParam("dialog", dialog);
    }
    

    //Get And Set
    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getSelectedCiudad() {
        return selectedCiudad;
    }

    public void setSelectedCiudad(Ciudad selectedCiudad) {
        this.selectedCiudad = selectedCiudad;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public List<Ciudad> getFilterCiudades() {
        return filterCiudades;
    }

    public void setFilterCiudades(List<Ciudad> filterCiudades) {
        this.filterCiudades = filterCiudades;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }

    public List<Region> getRegiones() {
        return regiones;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }
    
    
}
