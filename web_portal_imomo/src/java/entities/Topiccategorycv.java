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
@Table(name = "topiccategorycv")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Topiccategorycv.findAll", query = "SELECT t FROM Topiccategorycv t"),
    @NamedQuery(name = "Topiccategorycv.findByTerm", query = "SELECT t FROM Topiccategorycv t WHERE t.term = :term")
    })
public class Topiccategorycv implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Term")
    private String term;
    @Lob
    @Size(max = 65535)
    @Column(name = "Definition")
    private String definition;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topicCategory")
    private List<Isometadata> isometadataList;
    public Topiccategorycv()
        {
        }
    public Topiccategorycv(String term)
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
    public List<Isometadata> getIsometadataList()
        {
        return isometadataList;
        }
    public void setIsometadataList(List<Isometadata> isometadataList)
        {
        this.isometadataList = isometadataList;
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
        if (!(object instanceof Topiccategorycv))
            {
            return false;
            }
        Topiccategorycv other = (Topiccategorycv) object;
        if ((this.term == null && other.term != null) || (this.term != null && !this.term.equals(other.term)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Topiccategorycv[ term=" + term + " ]";
        }
    
    }
