/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "labmethods")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Labmethods.findAll", query = "SELECT l FROM Labmethods l"),
    @NamedQuery(name = "Labmethods.findByLabMethodID", query = "SELECT l FROM Labmethods l WHERE l.labMethodID = :labMethodID"),
    @NamedQuery(name = "Labmethods.findByLabName", query = "SELECT l FROM Labmethods l WHERE l.labName = :labName"),
    @NamedQuery(name = "Labmethods.findByLabOrganization", query = "SELECT l FROM Labmethods l WHERE l.labOrganization = :labOrganization"),
    @NamedQuery(name = "Labmethods.findByLabMethodName", query = "SELECT l FROM Labmethods l WHERE l.labMethodName = :labMethodName")
    })
public class Labmethods implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LabMethodID")
    private Integer labMethodID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LabName")
    private String labName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LabOrganization")
    private String labOrganization;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LabMethodName")
    private String labMethodName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "LabMethodDescription")
    private String labMethodDescription;
    @Lob
    @Size(max = 65535)
    @Column(name = "LabMethodLink")
    private String labMethodLink;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "labMethodID")
    private List<Samples> samplesList;
    public Labmethods()
        {
        }
    public Labmethods(Integer labMethodID)
        {
        this.labMethodID = labMethodID;
        }
    public Labmethods(Integer labMethodID, String labName, String labOrganization, String labMethodName, String labMethodDescription)
        {
        this.labMethodID = labMethodID;
        this.labName = labName;
        this.labOrganization = labOrganization;
        this.labMethodName = labMethodName;
        this.labMethodDescription = labMethodDescription;
        }
    public Integer getLabMethodID()
        {
        return labMethodID;
        }
    public void setLabMethodID(Integer labMethodID)
        {
        this.labMethodID = labMethodID;
        }
    public String getLabName()
        {
        return labName;
        }
    public void setLabName(String labName)
        {
        this.labName = labName;
        }
    public String getLabOrganization()
        {
        return labOrganization;
        }
    public void setLabOrganization(String labOrganization)
        {
        this.labOrganization = labOrganization;
        }
    public String getLabMethodName()
        {
        return labMethodName;
        }
    public void setLabMethodName(String labMethodName)
        {
        this.labMethodName = labMethodName;
        }
    public String getLabMethodDescription()
        {
        return labMethodDescription;
        }
    public void setLabMethodDescription(String labMethodDescription)
        {
        this.labMethodDescription = labMethodDescription;
        }
    public String getLabMethodLink()
        {
        return labMethodLink;
        }
    public void setLabMethodLink(String labMethodLink)
        {
        this.labMethodLink = labMethodLink;
        }
    @XmlTransient
    public List<Samples> getSamplesList()
        {
        return samplesList;
        }
    public void setSamplesList(List<Samples> samplesList)
        {
        this.samplesList = samplesList;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (labMethodID != null ? labMethodID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Labmethods))
            {
            return false;
            }
        Labmethods other = (Labmethods) object;
        if ((this.labMethodID == null && other.labMethodID != null) || (this.labMethodID != null && !this.labMethodID.equals(other.labMethodID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Labmethods[ labMethodID=" + labMethodID + " ]";
        }
    
    }
