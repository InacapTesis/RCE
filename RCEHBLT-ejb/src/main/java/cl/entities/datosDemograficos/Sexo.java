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
@Table(name = "sexo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sexo.findAll", query = "SELECT s FROM Sexo s"),
    @NamedQuery(name = "Sexo.findBySexoCodigo", query = "SELECT s FROM Sexo s WHERE s.sexoCodigo = :sexoCodigo"),
    @NamedQuery(name = "Sexo.findBySexoDescripcion", query = "SELECT s FROM Sexo s WHERE s.sexoDescripcion = :sexoDescripcion")})
public class Sexo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "Table_gen", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT" , pkColumnValue = "SEXO_SEQ", initialValue = 1 ,allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Table_gen")
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo_codigo")
    private Integer sexoCodigo;
    @Size(max = 20)
    @Column(name = "sexo_descripcion")
    private String sexoDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexoCodigo")
    private List<DatosPaciente> datosPacienteList;

    public Sexo() {
    }

    public Sexo(Integer sexoCodigo) {
        this.sexoCodigo = sexoCodigo;
    }

    public Integer getSexoCodigo() {
        return sexoCodigo;
    }

    public void setSexoCodigo(Integer sexoCodigo) {
        this.sexoCodigo = sexoCodigo;
    }

    public String getSexoDescripcion() {
        return sexoDescripcion;
    }

    public void setSexoDescripcion(String sexoDescripcion) {
        this.sexoDescripcion = sexoDescripcion;
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
        hash += (sexoCodigo != null ? sexoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sexo)) {
            return false;
        }
        Sexo other = (Sexo) object;
        if ((this.sexoCodigo == null && other.sexoCodigo != null) || (this.sexoCodigo != null && !this.sexoCodigo.equals(other.sexoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entities.datosDemograficos.Sexo[ sexoCodigo=" + sexoCodigo + " ]";
    }
    
}
