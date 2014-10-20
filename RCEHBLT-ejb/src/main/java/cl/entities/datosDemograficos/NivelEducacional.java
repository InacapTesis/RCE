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
@Table(name = "nivel_educacional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelEducacional.findAll", query = "SELECT n FROM NivelEducacional n"),
    @NamedQuery(name = "NivelEducacional.findByEducCodigo", query = "SELECT n FROM NivelEducacional n WHERE n.educCodigo = :educCodigo"),
    @NamedQuery(name = "NivelEducacional.findByEducDescripcion", query = "SELECT n FROM NivelEducacional n WHERE n.educDescripcion = :educDescripcion")})
public class NivelEducacional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @TableGenerator(name = "Table_gen", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_COUNT", pkColumnValue = "NIVEDU_SEQ", initialValue = 1, allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Table_gen")
    @Basic(optional = false)
    @NotNull
    @Column(name = "educ_codigo")
    private Integer educCodigo;
    @Size(max = 20)
    @Column(name = "educ_descripcion")
    private String educDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educCodigo")
    private List<DatosPaciente> datosPacienteList;

    public NivelEducacional() {
    }

    public NivelEducacional(Integer educCodigo) {
        this.educCodigo = educCodigo;
    }

    public Integer getEducCodigo() {
        return educCodigo;
    }

    public void setEducCodigo(Integer educCodigo) {
        this.educCodigo = educCodigo;
    }

    public String getEducDescripcion() {
        return educDescripcion;
    }

    public void setEducDescripcion(String educDescripcion) {
        this.educDescripcion = educDescripcion;
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
        hash += (educCodigo != null ? educCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelEducacional)) {
            return false;
        }
        NivelEducacional other = (NivelEducacional) object;
        if ((this.educCodigo == null && other.educCodigo != null) || (this.educCodigo != null && !this.educCodigo.equals(other.educCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entities.datosDemograficos.NivelEducacional[ educCodigo=" + educCodigo + " ]";
    }

}
