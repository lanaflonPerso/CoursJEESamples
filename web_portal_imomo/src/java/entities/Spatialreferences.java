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
@Table(name = "spatialreferences")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Spatialreferences.findAll", query = "SELECT s FROM Spatialreferences s"),
    @NamedQuery(name = "Spatialreferences.findBySpatialReferenceID", query = "SELECT s FROM Spatialreferences s WHERE s.spatialReferenceID = :spatialReferenceID"),
    @NamedQuery(name = "Spatialreferences.findBySrsid", query = "SELECT s FROM Spatialreferences s WHERE s.srsid = :srsid"),
    @NamedQuery(name = "Spatialreferences.findBySRSName", query = "SELECT s FROM Spatialreferences s WHERE s.sRSName = :sRSName"),
    @NamedQuery(name = "Spatialreferences.findByIsGeographic", query = "SELECT s FROM Spatialreferences s WHERE s.isGeographic = :isGeographic")
    })
public class Spatialreferences implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SpatialReferenceID")
    private Integer spatialReferenceID;
    @Column(name = "SRSID")
    private Integer srsid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SRSName")
    private String sRSName;
    @Column(name = "IsGeographic")
    private Boolean isGeographic;
    @Lob
    @Size(max = 65535)
    @Column(name = "Notes")
    private String notes;
    @OneToMany(mappedBy = "localProjectionID")
    private List<Sites> sitesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "latLongDatumID")
    private List<Sites> sitesList1;
    public Spatialreferences()
        {
        }
    public Spatialreferences(Integer spatialReferenceID)
        {
        this.spatialReferenceID = spatialReferenceID;
        }
    public Spatialreferences(Integer spatialReferenceID, String sRSName)
        {
        this.spatialReferenceID = spatialReferenceID;
        this.sRSName = sRSName;
        }
    public Integer getSpatialReferenceID()
        {
        return spatialReferenceID;
        }
    public void setSpatialReferenceID(Integer spatialReferenceID)
        {
        this.spatialReferenceID = spatialReferenceID;
        }
    public Integer getSrsid()
        {
        return srsid;
        }
    public void setSrsid(Integer srsid)
        {
        this.srsid = srsid;
        }
    public String getSRSName()
        {
        return sRSName;
        }
    public void setSRSName(String sRSName)
        {
        this.sRSName = sRSName;
        }
    public Boolean getIsGeographic()
        {
        return isGeographic;
        }
    public void setIsGeographic(Boolean isGeographic)
        {
        this.isGeographic = isGeographic;
        }
    public String getNotes()
        {
        return notes;
        }
    public void setNotes(String notes)
        {
        this.notes = notes;
        }
    @XmlTransient
    public List<Sites> getSitesList()
        {
        return sitesList;
        }
    public void setSitesList(List<Sites> sitesList)
        {
        this.sitesList = sitesList;
        }
    @XmlTransient
    public List<Sites> getSitesList1()
        {
        return sitesList1;
        }
    public void setSitesList1(List<Sites> sitesList1)
        {
        this.sitesList1 = sitesList1;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (spatialReferenceID != null ? spatialReferenceID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spatialreferences))
            {
            return false;
            }
        Spatialreferences other = (Spatialreferences) object;
        if ((this.spatialReferenceID == null && other.spatialReferenceID != null) || (this.spatialReferenceID != null && !this.spatialReferenceID.equals(other.spatialReferenceID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Spatialreferences[ spatialReferenceID=" + spatialReferenceID + " ]";
        }
    
    }
