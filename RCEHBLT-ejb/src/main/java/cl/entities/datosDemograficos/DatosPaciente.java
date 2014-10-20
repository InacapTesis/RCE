/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entities.datosDemograficos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "datos_paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosPaciente.findAll", query = "SELECT d FROM DatosPaciente d"),
    @NamedQuery(name = "DatosPaciente.findByPacienteId", query = "SELECT d FROM DatosPaciente d WHERE d.pacienteId = :pacienteId"),
    @NamedQuery(name = "DatosPaciente.findByPacienteRut", query = "SELECT d FROM DatosPaciente d WHERE d.pacienteRut = :pacienteRut"),
    @NamedQuery(name = "DatosPaciente.findByPacienteDvIdentificador", query = "SELECT d FROM DatosPaciente d WHERE d.pacienteDvIdentificador = :pacienteDvIdentificador"),
    @NamedQuery(name = "DatosPaciente.findByPacienteNombres", query = "SELECT d FROM DatosPaciente d WHERE d.pacienteNombres = :pacienteNombres"),
    @NamedQuery(name = "DatosPaciente.findByPacienteApellidoPaterno", query = "SELECT d FROM DatosPaciente d WHERE d.pacienteApellidoPaterno = :pacienteApellidoPaterno"),
    @NamedQuery(name = "DatosPaciente.findByPacienteApellidoMaterno", query = "SELECT d FROM DatosPaciente d WHERE d.pacienteApellidoMaterno = :pacienteApellidoMaterno"),
    @NamedQuery(name = "DatosPaciente.findByPacienteCelular", query = "SELECT d FROM DatosPaciente d WHERE d.pacienteCelular = :pacienteCelular"),
    @NamedQuery(name = "DatosPaciente.findByPacienteDireccion", query = "SELECT d FROM DatosPaciente d WHERE d.pacienteDireccion = :pacienteDireccion"),
    @NamedQuery(name = "DatosPaciente.findByPacienteFechaNacimiento", query = "SELECT d FROM DatosPaciente d WHERE d.pacienteFechaNacimiento = :pacienteFechaNacimiento"),
    @NamedQuery(name = "DatosPaciente.findByPacienteNumeroFicha", query = "SELECT d FROM DatosPaciente d WHERE d.pacienteNumeroFicha = :pacienteNumeroFicha"),
    @NamedQuery(name = "DatosPaciente.findByPacienteOcupacion", query = "SELECT d FROM DatosPaciente d WHERE d.pacienteOcupacion = :pacienteOcupacion")})
public class DatosPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "paciente_id")
    private Integer pacienteId;
    @Size(max = 15)
    @Column(name = "paciente_rut")
    private String pacienteRut;
    @Size(max = 1)
    @Column(name = "paciente_dv_identificador")
    private String pacienteDvIdentificador;
    @Size(max = 50)
    @Column(name = "paciente_nombres")
    private String pacienteNombres;
    @Size(max = 30)
    @Column(name = "paciente_apellido_paterno")
    private String pacienteApellidoPaterno;
    @Size(max = 30)
    @Column(name = "paciente_apellido_materno")
    private String pacienteApellidoMaterno;
    @Size(max = 10)
    @Column(name = "paciente_celular")
    private String pacienteCelular;
    @Size(max = 20)
    @Column(name = "paciente__direccion")
    private String pacienteDireccion;
    @Column(name = "paciente_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date pacienteFechaNacimiento;
    @Column(name = "paciente_numero_ficha")
    private Integer pacienteNumeroFicha;
    @Size(max = 30)
    @Column(name = "paciente_ocupacion")
    private String pacienteOcupacion;
    @JoinColumn(name = "sexo_codigo", referencedColumnName = "sexo_codigo")
    @ManyToOne(optional = false)
    private Sexo sexoCodigo;
    @JoinColumn(name = "religion_codigo", referencedColumnName = "religion_codigo")
    @ManyToOne(optional = false)
    private Religion religionCodigo;
    @JoinColumn(name = "poriginario_codigo", referencedColumnName = "poriginario_codigo")
    @ManyToOne(optional = false)
    private PuebloOriginario poriginarioCodigo;
    @JoinColumn(name = "prevision_codigo", referencedColumnName = "prevision_codigo")
    @ManyToOne(optional = false)
    private Prevision previsionCodigo;
    @JoinColumn(name = "educ_codigo", referencedColumnName = "educ_codigo")
    @ManyToOne(optional = false)
    private NivelEducacional educCodigo;
    @JoinColumn(name = "nacionalidad_codigo", referencedColumnName = "nacionalidad_codigo")
    @ManyToOne(optional = false)
    private Nacionalidad nacionalidadCodigo;
    @JoinColumn(name = "gsanguineo_codigo", referencedColumnName = "gsanguineo_codigo")
    @ManyToOne(optional = false)
    private GrupoSanguineo gsanguineoCodigo;
    @JoinColumn(name = "estado_civil_codigo", referencedColumnName = "estado_civil_codigo")
    @ManyToOne(optional = false)
    private EstadoCivil estadoCivilCodigo;
    @JoinColumn(name = "comuna_codigo", referencedColumnName = "comuna_codigo")
    @ManyToOne(optional = false)
    private Comuna comunaCodigo;

    public DatosPaciente() {
    }

    public DatosPaciente(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getPacienteRut() {
        return pacienteRut;
    }

    public void setPacienteRut(String pacienteRut) {
        this.pacienteRut = pacienteRut;
    }

    public String getPacienteDvIdentificador() {
        return pacienteDvIdentificador;
    }

    public void setPacienteDvIdentificador(String pacienteDvIdentificador) {
        this.pacienteDvIdentificador = pacienteDvIdentificador;
    }

    public String getPacienteNombres() {
        return pacienteNombres;
    }

    public void setPacienteNombres(String pacienteNombres) {
        this.pacienteNombres = pacienteNombres;
    }

    public String getPacienteApellidoPaterno() {
        return pacienteApellidoPaterno;
    }

    public void setPacienteApellidoPaterno(String pacienteApellidoPaterno) {
        this.pacienteApellidoPaterno = pacienteApellidoPaterno;
    }

    public String getPacienteApellidoMaterno() {
        return pacienteApellidoMaterno;
    }

    public void setPacienteApellidoMaterno(String pacienteApellidoMaterno) {
        this.pacienteApellidoMaterno = pacienteApellidoMaterno;
    }

    public String getPacienteCelular() {
        return pacienteCelular;
    }

    public void setPacienteCelular(String pacienteCelular) {
        this.pacienteCelular = pacienteCelular;
    }

    public String getPacienteDireccion() {
        return pacienteDireccion;
    }

    public void setPacienteDireccion(String pacienteDireccion) {
        this.pacienteDireccion = pacienteDireccion;
    }

    public Date getPacienteFechaNacimiento() {
        return pacienteFechaNacimiento;
    }

    public void setPacienteFechaNacimiento(Date pacienteFechaNacimiento) {
        this.pacienteFechaNacimiento = pacienteFechaNacimiento;
    }

    public Integer getPacienteNumeroFicha() {
        return pacienteNumeroFicha;
    }

    public void setPacienteNumeroFicha(Integer pacienteNumeroFicha) {
        this.pacienteNumeroFicha = pacienteNumeroFicha;
    }

    public String getPacienteOcupacion() {
        return pacienteOcupacion;
    }

    public void setPacienteOcupacion(String pacienteOcupacion) {
        this.pacienteOcupacion = pacienteOcupacion;
    }

    public Sexo getSexoCodigo() {
        return sexoCodigo;
    }

    public void setSexoCodigo(Sexo sexoCodigo) {
        this.sexoCodigo = sexoCodigo;
    }

    public Religion getReligionCodigo() {
        return religionCodigo;
    }

    public void setReligionCodigo(Religion religionCodigo) {
        this.religionCodigo = religionCodigo;
    }

    public PuebloOriginario getPoriginarioCodigo() {
        return poriginarioCodigo;
    }

    public void setPoriginarioCodigo(PuebloOriginario poriginarioCodigo) {
        this.poriginarioCodigo = poriginarioCodigo;
    }

    public Prevision getPrevisionCodigo() {
        return previsionCodigo;
    }

    public void setPrevisionCodigo(Prevision previsionCodigo) {
        this.previsionCodigo = previsionCodigo;
    }

    public NivelEducacional getEducCodigo() {
        return educCodigo;
    }

    public void setEducCodigo(NivelEducacional educCodigo) {
        this.educCodigo = educCodigo;
    }

    public Nacionalidad getNacionalidadCodigo() {
        return nacionalidadCodigo;
    }

    public void setNacionalidadCodigo(Nacionalidad nacionalidadCodigo) {
        this.nacionalidadCodigo = nacionalidadCodigo;
    }

    public GrupoSanguineo getGsanguineoCodigo() {
        return gsanguineoCodigo;
    }

    public void setGsanguineoCodigo(GrupoSanguineo gsanguineoCodigo) {
        this.gsanguineoCodigo = gsanguineoCodigo;
    }

    public EstadoCivil getEstadoCivilCodigo() {
        return estadoCivilCodigo;
    }

    public void setEstadoCivilCodigo(EstadoCivil estadoCivilCodigo) {
        this.estadoCivilCodigo = estadoCivilCodigo;
    }

    public Comuna getComunaCodigo() {
        return comunaCodigo;
    }

    public void setComunaCodigo(Comuna comunaCodigo) {
        this.comunaCodigo = comunaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacienteId != null ? pacienteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosPaciente)) {
            return false;
        }
        DatosPaciente other = (DatosPaciente) object;
        if ((this.pacienteId == null && other.pacienteId != null) || (this.pacienteId != null && !this.pacienteId.equals(other.pacienteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entities.datosDemograficos.DatosPaciente[ pacienteId=" + pacienteId + " ]";
    }
    
}
