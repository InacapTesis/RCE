/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.entities.datosDemograficos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresEduardo
 */
@Entity
@Table(name = "sequence_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SequenceTable.findAll", query = "SELECT s FROM SequenceTable s"),
    @NamedQuery(name = "SequenceTable.findBySeqName", query = "SELECT s FROM SequenceTable s WHERE s.seqName = :seqName"),
    @NamedQuery(name = "SequenceTable.findBySeqCount", query = "SELECT s FROM SequenceTable s WHERE s.seqCount = :seqCount")})
public class SequenceTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "seq_name")
    private String seqName;
    @Column(name = "seq_count")
    private Integer seqCount;

    public SequenceTable() {
    }

    public SequenceTable(String seqName) {
        this.seqName = seqName;
    }

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public Integer getSeqCount() {
        return seqCount;
    }

    public void setSeqCount(Integer seqCount) {
        this.seqCount = seqCount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqName != null ? seqName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SequenceTable)) {
            return false;
        }
        SequenceTable other = (SequenceTable) object;
        if ((this.seqName == null && other.seqName != null) || (this.seqName != null && !this.seqName.equals(other.seqName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.entities.datosDemograficos.SequenceTable[ seqName=" + seqName + " ]";
    }
    
}
