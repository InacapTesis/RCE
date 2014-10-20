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
@Table(name = "tipo_prevision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPrevision.findAll", query = "SELECT t FROM TipoPrevision t"),
    @NamedQuery(name = "TipoPrevision.findByTprevisionCodigo", query = "SELECT t FROM TipoPrevision t WHERE t.tprevisionCodigo = :tprevisionCodigo"),
    @NamedQuery(name = "TipoPrevision.findByTprevisionDescripcion", query = "SELECT t FROM TipoPrevision t WHERE t.tprevisionDescripcion = :tprevisionDescripcion")})
public class TipoPrevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "Table_gen", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT" , pkColumnValue = "TIPPREV_SEQ", initialValue = 1 ,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Table_gen")
    @Basic(optional = false)
    @NotNull
    @Column(name = "tprevision_codigo")
    private Integer tprevisionCodigo;
    @Size(max = 20)
    @Column(name = "tprevision_descripcion")
    private String tprevisionDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tprevisionCodigo")
    private List<Prevision> previsionList;

    public TipoPrevision() {
    }

    public TipoPrevision(Integer tprevisionCodigo) {
        this.tprevisionCodigo = tprevisionCodigo;
    }

    public Integer getTprevisionCodigo() {
        return tprevisionCodigo;
    }

    public void setTprevisionCodigo(Integer tprevisionCodigo) {
        this.tprevisionCodigo = tprevisionCodigo;
    }

    public String getTprevisionDescripcion() {
        return tprevisionDescripcion;
    }

    public void setTprevisionDescripcion(String tprevisionDescripcion) {
        this.tprevisionDescripcion = tprevisionDescripcion;
    }

    @XmlTransient
    public List<Prevision> getPrevisionList() {
        return previsionList;
    }

    public void setPrevisionList(List<Prevision> previsionList) {
        this.previsionList = previsionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tprevisionCodigo != null ? tprevisionCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPrevision)) {
            return false;
        }
        TipoPrevision other = (TipoPrevision) object;
        if ((this.tprevisionCodigo == null && other.tprevisionCodigo != null) || (this.tprevisionCodigo != null && !this.tprevisionCodigo.equals(other.tprevisionCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entities.datosDemograficos.TipoPrevision[ tprevisionCodigo=" + tprevisionCodigo + " ]";
    }
    
}
