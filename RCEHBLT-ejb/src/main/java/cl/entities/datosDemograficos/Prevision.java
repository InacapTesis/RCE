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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "prevision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prevision.findAll", query = "SELECT p FROM Prevision p"),
    @NamedQuery(name = "Prevision.findByPrevisionCodigo", query = "SELECT p FROM Prevision p WHERE p.previsionCodigo = :previsionCodigo"),
    @NamedQuery(name = "Prevision.findByPrevisionDescripcion", query = "SELECT p FROM Prevision p WHERE p.previsionDescripcion = :previsionDescripcion")})
public class Prevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "Table_gen", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT" , pkColumnValue = "PREVIS_SEQ", initialValue = 1 ,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Table_gen")
    @Basic(optional = false)
    @NotNull
    @Column(name = "prevision_codigo")
    private Integer previsionCodigo;
    @Size(max = 20)
    @Column(name = "prevision_descripcion")
    private String previsionDescripcion;
    @JoinColumn(name = "tprevision_codigo", referencedColumnName = "tprevision_codigo")
    @ManyToOne(optional = false)
    private TipoPrevision tprevisionCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "previsionCodigo")
    private List<DatosPaciente> datosPacienteList;

    public Prevision() {
    }

    public Prevision(Integer previsionCodigo) {
        this.previsionCodigo = previsionCodigo;
    }

    public Integer getPrevisionCodigo() {
        return previsionCodigo;
    }

    public void setPrevisionCodigo(Integer previsionCodigo) {
        this.previsionCodigo = previsionCodigo;
    }

    public String getPrevisionDescripcion() {
        return previsionDescripcion;
    }

    public void setPrevisionDescripcion(String previsionDescripcion) {
        this.previsionDescripcion = previsionDescripcion;
    }

    public TipoPrevision getTprevisionCodigo() {
        return tprevisionCodigo;
    }

    public void setTprevisionCodigo(TipoPrevision tprevisionCodigo) {
        this.tprevisionCodigo = tprevisionCodigo;
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
        hash += (previsionCodigo != null ? previsionCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prevision)) {
            return false;
        }
        Prevision other = (Prevision) object;
        if ((this.previsionCodigo == null && other.previsionCodigo != null) || (this.previsionCodigo != null && !this.previsionCodigo.equals(other.previsionCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entities.datosDemograficos.Prevision[ previsionCodigo=" + previsionCodigo + " ]";
    }
    
}
