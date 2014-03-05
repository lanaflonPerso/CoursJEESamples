/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "derivedfrom")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Derivedfrom.findAll", query = "SELECT d FROM Derivedfrom d"),
    @NamedQuery(name = "Derivedfrom.findByDerivedFromID", query = "SELECT d FROM Derivedfrom d WHERE d.derivedFromID = :derivedFromID")
    })
public class Derivedfrom implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DerivedFromID")
    private Integer derivedFromID;
    @JoinColumn(name = "ValueID", referencedColumnName = "ValueID")
    @ManyToOne(optional = false)
    private Datavalues valueID;
    public Derivedfrom()
        {
        }
    public Derivedfrom(Integer derivedFromID)
        {
        this.derivedFromID = derivedFromID;
        }
    public Integer getDerivedFromID()
        {
        return derivedFromID;
        }
    public void setDerivedFromID(Integer derivedFromID)
        {
        this.derivedFromID = derivedFromID;
        }
    public Datavalues getValueID()
        {
        return valueID;
        }
    public void setValueID(Datavalues valueID)
        {
        this.valueID = valueID;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (derivedFromID != null ? derivedFromID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Derivedfrom))
            {
            return false;
            }
        Derivedfrom other = (Derivedfrom) object;
        if ((this.derivedFromID == null && other.derivedFromID != null) || (this.derivedFromID != null && !this.derivedFromID.equals(other.derivedFromID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Derivedfrom[ derivedFromID=" + derivedFromID + " ]";
        }
    
    }
