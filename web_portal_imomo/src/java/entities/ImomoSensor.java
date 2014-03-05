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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "imomo_sensor")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "ImomoSensor.findAll", query = "SELECT i FROM ImomoSensor i"),
    @NamedQuery(name = "ImomoSensor.findBySensorID", query = "SELECT i FROM ImomoSensor i WHERE i.sensorID = :sensorID"),
    @NamedQuery(name = "ImomoSensor.findByUid", query = "SELECT i FROM ImomoSensor i WHERE i.uid = :uid")
    })
public class ImomoSensor implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "sensorID")
    private Integer sensorID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uid")
    private int uid;
    @JoinTable(name = "imomo_sensor_sites", joinColumns =
        {
        @JoinColumn(name = "sensorID", referencedColumnName = "sensorID")
        }, inverseJoinColumns =
        {
        @JoinColumn(name = "siteID", referencedColumnName = "SiteID")
        })
    @ManyToMany
    private List<Sites> sitesList;
    @OneToMany(mappedBy = "imomoSensorID")
    private List<Datavalues> datavaluesList;
    @JoinColumn(name = "variableID", referencedColumnName = "VariableID")
    @ManyToOne(optional = false)
    private Variables variableID;
    public ImomoSensor()
        {
        }
    public ImomoSensor(Integer sensorID)
        {
        this.sensorID = sensorID;
        }
    public ImomoSensor(Integer sensorID, int uid)
        {
        this.sensorID = sensorID;
        this.uid = uid;
        }
    public Integer getSensorID()
        {
        return sensorID;
        }
    public void setSensorID(Integer sensorID)
        {
        this.sensorID = sensorID;
        }
    public int getUid()
        {
        return uid;
        }
    public void setUid(int uid)
        {
        this.uid = uid;
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
    public List<Datavalues> getDatavaluesList()
        {
        return datavaluesList;
        }
    public void setDatavaluesList(List<Datavalues> datavaluesList)
        {
        this.datavaluesList = datavaluesList;
        }
    public Variables getVariableID()
        {
        return variableID;
        }
    public void setVariableID(Variables variableID)
        {
        this.variableID = variableID;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (sensorID != null ? sensorID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImomoSensor))
            {
            return false;
            }
        ImomoSensor other = (ImomoSensor) object;
        if ((this.sensorID == null && other.sensorID != null) || (this.sensorID != null && !this.sensorID.equals(other.sensorID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.ImomoSensor[ sensorID=" + sensorID + " ]";
        }
    
    }
