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
@Table(name = "religion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Religion.findAll", query = "SELECT r FROM Religion r"),
    @NamedQuery(name = "Religion.findByReligionCodigo", query = "SELECT r FROM Religion r WHERE r.religionCodigo = :religionCodigo"),
    @NamedQuery(name = "Religion.findByReligionDescripcion", query = "SELECT r FROM Religion r WHERE r.religionDescripcion = :religionDescripcion")})
public class Religion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "Table_gen", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT" , pkColumnValue = "RELIGION_SEQ", initialValue = 1 ,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Table_gen")
    @Basic(optional = false)
    @NotNull
    @Column(name = "religion_codigo")
    private Integer religionCodigo;
    @Size(max = 20)
    @Column(name = "religion_descripcion")
    private String religionDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "religionCodigo")
    private List<DatosPaciente> datosPacienteList;

    public Religion() {
    }

    public Religion(Integer religionCodigo) {
        this.religionCodigo = religionCodigo;
    }

    public Integer getReligionCodigo() {
        return religionCodigo;
    }

    public void setReligionCodigo(Integer religionCodigo) {
        this.religionCodigo = religionCodigo;
    }

    public String getReligionDescripcion() {
        return religionDescripcion;
    }

    public void setReligionDescripcion(String religionDescripcion) {
        this.religionDescripcion = religionDescripcion;
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
        hash += (religionCodigo != null ? religionCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Religion)) {
            return false;
        }
        Religion other = (Religion) object;
        if ((this.religionCodigo == null && other.religionCodigo != null) || (this.religionCodigo != null && !this.religionCodigo.equals(other.religionCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entities.datosDemograficos.Religion[ religionCodigo=" + religionCodigo + " ]";
    }
    
}
