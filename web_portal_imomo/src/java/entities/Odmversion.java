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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "odmversion")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Odmversion.findAll", query = "SELECT o FROM Odmversion o"),
    @NamedQuery(name = "Odmversion.findByVersionNumber", query = "SELECT o FROM Odmversion o WHERE o.versionNumber = :versionNumber")
    })
public class Odmversion implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "VersionNumber")
    private String versionNumber;
    public Odmversion()
        {
        }
    public Odmversion(String versionNumber)
        {
        this.versionNumber = versionNumber;
        }
    public String getVersionNumber()
        {
        return versionNumber;
        }
    public void setVersionNumber(String versionNumber)
        {
        this.versionNumber = versionNumber;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (versionNumber != null ? versionNumber.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odmversion))
            {
            return false;
            }
        Odmversion other = (Odmversion) object;
        if ((this.versionNumber == null && other.versionNumber != null) || (this.versionNumber != null && !this.versionNumber.equals(other.versionNumber)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Odmversion[ versionNumber=" + versionNumber + " ]";
        }
    
    }
