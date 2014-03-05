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
@Table(name = "censorcodecv")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Censorcodecv.findAll", query = "SELECT c FROM Censorcodecv c"),
    @NamedQuery(name = "Censorcodecv.findByTerm", query = "SELECT c FROM Censorcodecv c WHERE c.term = :term")
    })
public class Censorcodecv implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Term")
    private String term;
    @Lob
    @Size(max = 65535)
    @Column(name = "Definition")
    private String definition;
    @OneToMany(mappedBy = "censorCode")
    private List<Datavalues> datavaluesList;
    public Censorcodecv()
        {
        }
    public Censorcodecv(String term)
        {
        this.term = term;
        }
    public String getTerm()
        {
        return term;
        }
    public void setTerm(String term)
        {
        this.term = term;
        }
    public String getDefinition()
        {
        return definition;
        }
    public void setDefinition(String definition)
        {
        this.definition = definition;
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
        hash += (term != null ? term.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Censorcodecv))
            {
            return false;
            }
        Censorcodecv other = (Censorcodecv) object;
        if ((this.term == null && other.term != null) || (this.term != null && !this.term.equals(other.term)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Censorcodecv[ term=" + term + " ]";
        }
    
    }
