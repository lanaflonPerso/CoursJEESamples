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
@Table(name = "units")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Units.findAll", query = "SELECT u FROM Units u"),
    @NamedQuery(name = "Units.findByUnitsID", query = "SELECT u FROM Units u WHERE u.unitsID = :unitsID"),
    @NamedQuery(name = "Units.findByUnitsName", query = "SELECT u FROM Units u WHERE u.unitsName = :unitsName"),
    @NamedQuery(name = "Units.findByUnitsType", query = "SELECT u FROM Units u WHERE u.unitsType = :unitsType"),
    @NamedQuery(name = "Units.findByUnitsAbbreviation", query = "SELECT u FROM Units u WHERE u.unitsAbbreviation = :unitsAbbreviation")
    })
public class Units implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UnitsID")
    private Integer unitsID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "UnitsName")
    private String unitsName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "UnitsType")
    private String unitsType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "UnitsAbbreviation")
    private String unitsAbbreviation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeUnitsID")
    private List<Variables> variablesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "variableUnitsID")
    private List<Variables> variablesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offsetUnitsID")
    private List<Offsettypes> offsettypesList;
    public Units()
        {
        }
    public Units(Integer unitsID)
        {
        this.unitsID = unitsID;
        }
    public Units(Integer unitsID, String unitsName, String unitsType, String unitsAbbreviation)
        {
        this.unitsID = unitsID;
        this.unitsName = unitsName;
        this.unitsType = unitsType;
        this.unitsAbbreviation = unitsAbbreviation;
        }
    public Integer getUnitsID()
        {
        return unitsID;
        }
    public void setUnitsID(Integer unitsID)
        {
        this.unitsID = unitsID;
        }
    public String getUnitsName()
        {
        return unitsName;
        }
    public void setUnitsName(String unitsName)
        {
        this.unitsName = unitsName;
        }
    public String getUnitsType()
        {
        return unitsType;
        }
    public void setUnitsType(String unitsType)
        {
        this.unitsType = unitsType;
        }
    public String getUnitsAbbreviation()
        {
        return unitsAbbreviation;
        }
    public void setUnitsAbbreviation(String unitsAbbreviation)
        {
        this.unitsAbbreviation = unitsAbbreviation;
        }
    @XmlTransient
    public List<Variables> getVariablesList()
        {
        return variablesList;
        }
    public void setVariablesList(List<Variables> variablesList)
        {
        this.variablesList = variablesList;
        }
    @XmlTransient
    public List<Variables> getVariablesList1()
        {
        return variablesList1;
        }
    public void setVariablesList1(List<Variables> variablesList1)
        {
        this.variablesList1 = variablesList1;
        }
    @XmlTransient
    public List<Offsettypes> getOffsettypesList()
        {
        return offsettypesList;
        }
    public void setOffsettypesList(List<Offsettypes> offsettypesList)
        {
        this.offsettypesList = offsettypesList;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (unitsID != null ? unitsID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Units))
            {
            return false;
            }
        Units other = (Units) object;
        if ((this.unitsID == null && other.unitsID != null) || (this.unitsID != null && !this.unitsID.equals(other.unitsID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Units[ unitsID=" + unitsID + " ]";
        }
    
    }
