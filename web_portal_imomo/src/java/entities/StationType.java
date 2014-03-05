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
@Table(name = "station_type")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "StationType.findAll", query = "SELECT s FROM StationType s"),
    @NamedQuery(name = "StationType.findByStationTypeID", query = "SELECT s FROM StationType s WHERE s.stationTypeID = :stationTypeID"),
    @NamedQuery(name = "StationType.findByTypeName", query = "SELECT s FROM StationType s WHERE s.typeName = :typeName")
    })
public class StationType implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stationTypeID")
    private Integer stationTypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "typeName")
    private String typeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stationTypeID")
    private List<Station> stationList;
    public StationType()
        {
        }
    public StationType(Integer stationTypeID)
        {
        this.stationTypeID = stationTypeID;
        }
    public StationType(Integer stationTypeID, String typeName)
        {
        this.stationTypeID = stationTypeID;
        this.typeName = typeName;
        }
    public Integer getStationTypeID()
        {
        return stationTypeID;
        }
    public void setStationTypeID(Integer stationTypeID)
        {
        this.stationTypeID = stationTypeID;
        }
    public String getTypeName()
        {
        return typeName;
        }
    public void setTypeName(String typeName)
        {
        this.typeName = typeName;
        }
    @XmlTransient
    public List<Station> getStationList()
        {
        return stationList;
        }
    public void setStationList(List<Station> stationList)
        {
        this.stationList = stationList;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (stationTypeID != null ? stationTypeID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StationType))
            {
            return false;
            }
        StationType other = (StationType) object;
        if ((this.stationTypeID == null && other.stationTypeID != null) || (this.stationTypeID != null && !this.stationTypeID.equals(other.stationTypeID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.StationType[ stationTypeID=" + stationTypeID + " ]";
        }
    
    }
