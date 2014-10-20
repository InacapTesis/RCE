/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entities.datosDemograficos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "grupo_sanguineo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoSanguineo.findAll", query = "SELECT g FROM GrupoSanguineo g"),
    @NamedQuery(name = "GrupoSanguineo.findByGsanguineoCodigo", query = "SELECT g FROM GrupoSanguineo g WHERE g.gsanguineoCodigo = :gsanguineoCodigo"),
    @NamedQuery(name = "GrupoSanguineo.findByGsanguineoDescripcion", query = "SELECT g FROM GrupoSanguineo g WHERE g.gsanguineoDescripcion = :gsanguineoDescripcion")})
public class GrupoSanguineo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "Table_gen", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT" , pkColumnValue = "GRUSAN_SEQ", initialValue = 1 ,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Table_gen")
    @Basic(optional = false)
    @NotNull
    @Column(name = "gsanguineo_codigo")
    private Integer gsanguineoCodigo;
    @Size(max = 20)
    @Column(name = "gsanguineo_descripcion")
    private String gsanguineoDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gsanguineoCodigo")
    private List<DatosPaciente> datosPacienteList;

    public GrupoSanguineo() {
    }

    public GrupoSanguineo(Integer gsanguineoCodigo) {
        this.gsanguineoCodigo = gsanguineoCodigo;
    }

    public Integer getGsanguineoCodigo() {
        return gsanguineoCodigo;
    }

    public void setGsanguineoCodigo(Integer gsanguineoCodigo) {
        this.gsanguineoCodigo = gsanguineoCodigo;
    }

    public String getGsanguineoDescripcion() {
        return gsanguineoDescripcion;
    }

    public void setGsanguineoDescripcion(String gsanguineoDescripcion) {
        this.gsanguineoDescripcion = gsanguineoDescripcion;
    }

    @XmlTransient
    public List<DatosPaciente> getDatosPacienteList() {
        return datosPacienteList;
    }

    public void setDatosPacienteList(List<DatosPaciente> datosPacienteList) {
        this.datosPacienteList = datosPacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gsanguineoCodigo != null ? gsanguineoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoSanguineo)) {
            return false;
        }
        GrupoSanguineo other = (GrupoSanguineo) object;
        if ((this.gsanguineoCodigo == null && other.gsanguineoCodigo != null) || (this.gsanguineoCodigo != null && !this.gsanguineoCodigo.equals(other.gsanguineoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entities.datosDemograficos.GrupoSanguineo[ gsanguineoCodigo=" + gsanguineoCodigo + " ]";
    }
    
}
