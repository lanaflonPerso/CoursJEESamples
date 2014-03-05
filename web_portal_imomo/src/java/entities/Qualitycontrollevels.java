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
@Table(name = "qualitycontrollevels")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Qualitycontrollevels.findAll", query = "SELECT q FROM Qualitycontrollevels q"),
    @NamedQuery(name = "Qualitycontrollevels.findByQualityControlLevelID", query = "SELECT q FROM Qualitycontrollevels q WHERE q.qualityControlLevelID = :qualityControlLevelID"),
    @NamedQuery(name = "Qualitycontrollevels.findByQualityControlLevelCode", query = "SELECT q FROM Qualitycontrollevels q WHERE q.qualityControlLevelCode = :qualityControlLevelCode"),
    @NamedQuery(name = "Qualitycontrollevels.findByDefinition", query = "SELECT q FROM Qualitycontrollevels q WHERE q.definition = :definition")
    })
public class Qualitycontrollevels implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "QualityControlLevelID")
    private Integer qualityControlLevelID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "QualityControlLevelCode")
    private String qualityControlLevelCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Definition")
    private String definition;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Explanation")
    private String explanation;
    @OneToMany(mappedBy = "qualityControlLevelID")
    private List<Datavalues> datavaluesList;
    public Qualitycontrollevels()
        {
        }
    public Qualitycontrollevels(Integer qualityControlLevelID)
        {
        this.qualityControlLevelID = qualityControlLevelID;
        }
    public Qualitycontrollevels(Integer qualityControlLevelID, String qualityControlLevelCode, String definition, String explanation)
        {
        this.qualityControlLevelID = qualityControlLevelID;
        this.qualityControlLevelCode = qualityControlLevelCode;
        this.definition = definition;
        this.explanation = explanation;
        }
    public Integer getQualityControlLevelID()
        {
        return qualityControlLevelID;
        }
    public void setQualityControlLevelID(Integer qualityControlLevelID)
        {
        this.qualityControlLevelID = qualityControlLevelID;
        }
    public String getQualityControlLevelCode()
        {
        return qualityControlLevelCode;
        }
    public void setQualityControlLevelCode(String qualityControlLevelCode)
        {
        this.qualityControlLevelCode = qualityControlLevelCode;
        }
    public String getDefinition()
        {
        return definition;
        }
    public void setDefinition(String definition)
        {
        this.definition = definition;
        }
    public String getExplanation()
        {
        return explanation;
        }
    public void setExplanation(String explanation)
        {
        this.explanation = explanation;
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
        hash += (qualityControlLevelID != null ? qualityControlLevelID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qualitycontrollevels))
            {
            return false;
            }
        Qualitycontrollevels other = (Qualitycontrollevels) object;
        if ((this.qualityControlLevelID == null && other.qualityControlLevelID != null) || (this.qualityControlLevelID != null && !this.qualityControlLevelID.equals(other.qualityControlLevelID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Qualitycontrollevels[ qualityControlLevelID=" + qualityControlLevelID + " ]";
        }
    
    }
