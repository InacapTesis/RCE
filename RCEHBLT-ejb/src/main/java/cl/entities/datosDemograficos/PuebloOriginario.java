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
@Table(name = "pueblo_originario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PuebloOriginario.findAll", query = "SELECT p FROM PuebloOriginario p"),
    @NamedQuery(name = "PuebloOriginario.findByPoriginarioCodigo", query = "SELECT p FROM PuebloOriginario p WHERE p.poriginarioCodigo = :poriginarioCodigo"),
    @NamedQuery(name = "PuebloOriginario.findByPoriginarioDescripcion", query = "SELECT p FROM PuebloOriginario p WHERE p.poriginarioDescripcion = :poriginarioDescripcion")})
public class PuebloOriginario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "Table_gen", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT" , pkColumnValue = "PUEORI_SEQ", initialValue = 1 ,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Table_gen")
    @Basic(optional = false)
    @NotNull
    @Column(name = "poriginario_codigo")
    private Integer poriginarioCodigo;
    @Size(max = 20)
    @Column(name = "poriginario_descripcion")
    private String poriginarioDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poriginarioCodigo")
    private List<DatosPaciente> datosPacienteList;

    public PuebloOriginario() {
    }

    public PuebloOriginario(Integer poriginarioCodigo) {
        this.poriginarioCodigo = poriginarioCodigo;
    }

    public Integer getPoriginarioCodigo() {
        return poriginarioCodigo;
    }

    public void setPoriginarioCodigo(Integer poriginarioCodigo) {
        this.poriginarioCodigo = poriginarioCodigo;
    }

    public String getPoriginarioDescripcion() {
        return poriginarioDescripcion;
    }

    public void setPoriginarioDescripcion(String poriginarioDescripcion) {
        this.poriginarioDescripcion = poriginarioDescripcion;
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
        hash += (poriginarioCodigo != null ? poriginarioCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuebloOriginario)) {
            return false;
        }
        PuebloOriginario other = (PuebloOriginario) object;
        if ((this.poriginarioCodigo == null && other.poriginarioCodigo != null) || (this.poriginarioCodigo != null && !this.poriginarioCodigo.equals(other.poriginarioCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entities.datosDemograficos.PuebloOriginario[ poriginarioCodigo=" + poriginarioCodigo + " ]";
    }
    
}
