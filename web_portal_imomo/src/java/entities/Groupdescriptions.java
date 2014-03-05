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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "groupdescriptions")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Groupdescriptions.findAll", query = "SELECT g FROM Groupdescriptions g"),
    @NamedQuery(name = "Groupdescriptions.findByGroupID", query = "SELECT g FROM Groupdescriptions g WHERE g.groupID = :groupID")
    })
public class Groupdescriptions implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GroupID")
    private Integer groupID;
    @Lob
    @Size(max = 65535)
    @Column(name = "GroupDescription")
    private String groupDescription;
    @ManyToMany(mappedBy = "groupdescriptionsList")
    private List<Datavalues> datavaluesList;
    public Groupdescriptions()
        {
        }
    public Groupdescriptions(Integer groupID)
        {
        this.groupID = groupID;
        }
    public Integer getGroupID()
        {
        return groupID;
        }
    public void setGroupID(Integer groupID)
        {
        this.groupID = groupID;
        }
    public String getGroupDescription()
        {
        return groupDescription;
        }
    public void setGroupDescription(String groupDescription)
        {
        this.groupDescription = groupDescription;
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
        hash += (groupID != null ? groupID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupdescriptions))
            {
            return false;
            }
        Groupdescriptions other = (Groupdescriptions) object;
        if ((this.groupID == null && other.groupID != null) || (this.groupID != null && !this.groupID.equals(other.groupID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Groupdescriptions[ groupID=" + groupID + " ]";
        }
    
    }
