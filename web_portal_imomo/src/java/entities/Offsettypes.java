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
import javax.persistence.Lob;
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
@Table(name = "offsettypes")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Offsettypes.findAll", query = "SELECT o FROM Offsettypes o"),
    @NamedQuery(name = "Offsettypes.findByOffsetTypeID", query = "SELECT o FROM Offsettypes o WHERE o.offsetTypeID = :offsetTypeID")
    })
public class Offsettypes implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OffsetTypeID")
    private Integer offsetTypeID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "OffsetDescription")
    private String offsetDescription;
    @JoinColumn(name = "OffsetUnitsID", referencedColumnName = "UnitsID")
    @ManyToOne(optional = false)
    private Units offsetUnitsID;
    @OneToMany(mappedBy = "offsetTypeID")
    private List<Datavalues> datavaluesList;
    public Offsettypes()
        {
        }
    public Offsettypes(Integer offsetTypeID)
        {
        this.offsetTypeID = offsetTypeID;
        }
    public Offsettypes(Integer offsetTypeID, String offsetDescription)
        {
        this.offsetTypeID = offsetTypeID;
        this.offsetDescription = offsetDescription;
        }
    public Integer getOffsetTypeID()
        {
        return offsetTypeID;
        }
    public void setOffsetTypeID(Integer offsetTypeID)
        {
        this.offsetTypeID = offsetTypeID;
        }
    public String getOffsetDescription()
        {
        return offsetDescription;
        }
    public void setOffsetDescription(String offsetDescription)
        {
        this.offsetDescription = offsetDescription;
        }
    public Units getOffsetUnitsID()
        {
        return offsetUnitsID;
        }
    public void setOffsetUnitsID(Units offsetUnitsID)
        {
        this.offsetUnitsID = offsetUnitsID;
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
        hash += (offsetTypeID != null ? offsetTypeID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offsettypes))
            {
            return false;
            }
        Offsettypes other = (Offsettypes) object;
        if ((this.offsetTypeID == null && other.offsetTypeID != null) || (this.offsetTypeID != null && !this.offsetTypeID.equals(other.offsetTypeID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Offsettypes[ offsetTypeID=" + offsetTypeID + " ]";
        }
    
    }
