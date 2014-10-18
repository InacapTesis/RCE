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
@Table(name = "estado_civil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e"),
    @NamedQuery(name = "EstadoCivil.findByEstadoCivilCodigo", query = "SELECT e FROM EstadoCivil e WHERE e.estadoCivilCodigo = :estadoCivilCodigo"),
    @NamedQuery(name = "EstadoCivil.findByEstadoCivilDescripcion", query = "SELECT e FROM EstadoCivil e WHERE e.estadoCivilDescripcion = :estadoCivilDescripcion")})
public class EstadoCivil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "Table_gen", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT" , pkColumnValue = "ESTCIV_SEQ", initialValue = 1 ,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Table_gen")
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_civil_codigo")
    private Integer estadoCivilCodigo;
    @Size(max = 20)
    @Column(name = "estado_civil_descripcion")
    private String estadoCivilDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoCivilCodigo")
    private List<DatosPaciente> datosPacienteList;

    public EstadoCivil() {
    }

    public EstadoCivil(Integer estadoCivilCodigo) {
        this.estadoCivilCodigo = estadoCivilCodigo;
    }

    public Integer getEstadoCivilCodigo() {
        return estadoCivilCodigo;
    }

    public void setEstadoCivilCodigo(Integer estadoCivilCodigo) {
        this.estadoCivilCodigo = estadoCivilCodigo;
    }

    public String getEstadoCivilDescripcion() {
        return estadoCivilDescripcion;
    }

    public void setEstadoCivilDescripcion(String estadoCivilDescripcion) {
        this.estadoCivilDescripcion = estadoCivilDescripcion;
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
        hash += (estadoCivilCodigo != null ? estadoCivilCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.estadoCivilCodigo == null && other.estadoCivilCodigo != null) || (this.estadoCivilCodigo != null && !this.estadoCivilCodigo.equals(other.estadoCivilCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entities.datosDemograficos.EstadoCivil[ estadoCivilCodigo=" + estadoCivilCodigo + " ]";
    }
    
}
