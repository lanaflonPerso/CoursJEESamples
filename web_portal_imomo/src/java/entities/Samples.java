/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "samples")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Samples.findAll", query = "SELECT s FROM Samples s"),
    @NamedQuery(name = "Samples.findBySampleID", query = "SELECT s FROM Samples s WHERE s.sampleID = :sampleID"),
    @NamedQuery(name = "Samples.findByLabSampleCode", query = "SELECT s FROM Samples s WHERE s.labSampleCode = :labSampleCode")
    })
public class Samples implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SampleID")
    private Integer sampleID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LabSampleCode")
    private String labSampleCode;
    @JoinColumn(name = "SampleType", referencedColumnName = "Term")
    @ManyToOne(optional = false)
    private Sampletypecv sampleType;
    @JoinColumn(name = "LabMethodID", referencedColumnName = "LabMethodID")
    @ManyToOne(optional = false)
    private Labmethods labMethodID;
    @OneToMany(mappedBy = "sampleID")
    private List<Datavalues> datavaluesList;
    public Samples()
        {
        }
    public Samples(Integer sampleID)
        {
        this.sampleID = sampleID;
        }
    public Samples(Integer sampleID, String labSampleCode)
        {
        this.sampleID = sampleID;
        this.labSampleCode = labSampleCode;
        }
    public Integer getSampleID()
        {
        return sampleID;
        }
    public void setSampleID(Integer sampleID)
        {
        this.sampleID = sampleID;
        }
    public String getLabSampleCode()
        {
        return labSampleCode;
        }
    public void setLabSampleCode(String labSampleCode)
        {
        this.labSampleCode = labSampleCode;
        }
    public Sampletypecv getSampleType()
        {
        return sampleType;
        }
    public void setSampleType(Sampletypecv sampleType)
        {
        this.sampleType = sampleType;
        }
    public Labmethods getLabMethodID()
        {
        return labMethodID;
        }
    public void setLabMethodID(Labmethods labMethodID)
        {
        this.labMethodID = labMethodID;
        }
    @XmlTransient
    public List<Datavalues> getDatavaluesList()
        {
        return datavaluesList;
        }
    public void setDatavaluesList(List<Datavalues> datavaluesList)
        {
        this.datavaluesList = datavaluesList;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (sampleID != null ? sampleID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Samples))
            {
            return false;
            }
        Samples other = (Samples) object;
        if ((this.sampleID == null && other.sampleID != null) || (this.sampleID != null && !this.sampleID.equals(other.sampleID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Samples[ sampleID=" + sampleID + " ]";
        }
    
    }
