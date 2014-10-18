/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.RCE.applicationPackage;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author AndresEduardo
 */
@ManagedBean
@ApplicationScoped
public class applicationBean {

    /**
     * Creates a new instance of applicationBean
     */
    public applicationBean() {
    }
     public String getBaseUrl() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String requestServer = request.getServerName();
        String requestScheme = request.getScheme();
        int serverPort = request.getServerPort();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String serverContextPath = servletContext.getContextPath();
        String logoutUrl = requestScheme + "://" + requestServer + ":" + Integer.toString(serverPort) + serverContextPath;
        return logoutUrl;
    }
    
}
