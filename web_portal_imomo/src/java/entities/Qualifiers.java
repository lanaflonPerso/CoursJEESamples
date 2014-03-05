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
@Table(name = "qualifiers")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Qualifiers.findAll", query = "SELECT q FROM Qualifiers q"),
    @NamedQuery(name = "Qualifiers.findByQualifierID", query = "SELECT q FROM Qualifiers q WHERE q.qualifierID = :qualifierID"),
    @NamedQuery(name = "Qualifiers.findByQualifierCode", query = "SELECT q FROM Qualifiers q WHERE q.qualifierCode = :qualifierCode")
    })
public class Qualifiers implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "QualifierID")
    private Integer qualifierID;
    @Size(max = 50)
    @Column(name = "QualifierCode")
    private String qualifierCode;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "QualifierDescription")
    private String qualifierDescription;
    @OneToMany(mappedBy = "qualifierID")
    private List<Datavalues> datavaluesList;
    public Qualifiers()
        {
        }
    public Qualifiers(Integer qualifierID)
        {
        this.qualifierID = qualifierID;
        }
    public Qualifiers(Integer qualifierID, String qualifierDescription)
        {
        this.qualifierID = qualifierID;
        this.qualifierDescription = qualifierDescription;
        }
    public Integer getQualifierID()
        {
        return qualifierID;
        }
    public void setQualifierID(Integer qualifierID)
        {
        this.qualifierID = qualifierID;
        }
    public String getQualifierCode()
        {
        return qualifierCode;
        }
    public void setQualifierCode(String qualifierCode)
        {
        this.qualifierCode = qualifierCode;
        }
    public String getQualifierDescription()
        {
        return qualifierDescription;
        }
    public void setQualifierDescription(String qualifierDescription)
        {
        this.qualifierDescription = qualifierDescription;
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
        hash += (qualifierID != null ? qualifierID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qualifiers))
            {
            return false;
            }
        Qualifiers other = (Qualifiers) object;
        if ((this.qualifierID == null && other.qualifierID != null) || (this.qualifierID != null && !this.qualifierID.equals(other.qualifierID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Qualifiers[ qualifierID=" + qualifierID + " ]";
        }
    
    }
