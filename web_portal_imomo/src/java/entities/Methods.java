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
@Table(name = "methods")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Methods.findAll", query = "SELECT m FROM Methods m"),
    @NamedQuery(name = "Methods.findByMethodID", query = "SELECT m FROM Methods m WHERE m.methodID = :methodID")
    })
public class Methods implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MethodID")
    private Integer methodID;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "MethodDescription")
    private String methodDescription;
    @Lob
    @Size(max = 65535)
    @Column(name = "MethodLink")
    private String methodLink;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "methodID")
    private List<Datavalues> datavaluesList;
    public Methods()
        {
        }
    public Methods(Integer methodID)
        {
        this.methodID = methodID;
        }
    public Methods(Integer methodID, String methodDescription)
        {
        this.methodID = methodID;
        this.methodDescription = methodDescription;
        }
    public Integer getMethodID()
        {
        return methodID;
        }
    public void setMethodID(Integer methodID)
        {
        this.methodID = methodID;
        }
    public String getMethodDescription()
        {
        return methodDescription;
        }
    public void setMethodDescription(String methodDescription)
        {
        this.methodDescription = methodDescription;
        }
    public String getMethodLink()
        {
        return methodLink;
        }
    public void setMethodLink(String methodLink)
        {
        this.methodLink = methodLink;
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
        hash += (methodID != null ? methodID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Methods))
            {
            return false;
            }
        Methods other = (Methods) object;
        if ((this.methodID == null && other.methodID != null) || (this.methodID != null && !this.methodID.equals(other.methodID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Methods[ methodID=" + methodID + " ]";
        }
    
    }
