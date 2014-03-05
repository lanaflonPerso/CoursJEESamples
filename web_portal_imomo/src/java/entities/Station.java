/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "station")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Station.findAll", query = "SELECT s FROM Station s"),
    @NamedQuery(name = "Station.findByStationID", query = "SELECT s FROM Station s WHERE s.stationID = :stationID")
    })
public class Station implements Serializable
    {
    @Basic(optional = false)
    @NotNull
    @Column(name = "uid")
    private int uid;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stationID")
    private Integer stationID;
    @JoinColumn(name = "siteID", referencedColumnName = "SiteID")
    @ManyToOne(optional = false)
    private Sites siteID;
    @JoinColumn(name = "stationTypeID", referencedColumnName = "stationTypeID")
    @ManyToOne(optional = false)
    private StationType stationTypeID;
    public Station()
        {
        }
    public Station(Integer stationID)
        {
        this.stationID = stationID;
        }
    public Integer getStationID()
        {
        return stationID;
        }
    public void setStationID(Integer stationID)
        {
        this.stationID = stationID;
        }
    public Sites getSiteID()
        {
        return siteID;
        }
    public void setSiteID(Sites siteID)
        {
        this.siteID = siteID;
        }
    public StationType getStationTypeID()
        {
        return stationTypeID;
        }
    public void setStationTypeID(StationType stationTypeID)
        {
        this.stationTypeID = stationTypeID;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (stationID != null ? stationID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Station))
            {
            return false;
            }
        Station other = (Station) object;
        if ((this.stationID == null && other.stationID != null) || (this.stationID != null && !this.stationID.equals(other.stationID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Station[ stationID=" + stationID + " ]";
        }
    public int getUid()
        {
        return uid;
        }
    public void setUid(int uid)
        {
        this.uid = uid;
        }
    
    }
