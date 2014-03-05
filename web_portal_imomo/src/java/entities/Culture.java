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
@Table(name = "culture")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Culture.findAll", query = "SELECT c FROM Culture c"),
    @NamedQuery(name = "Culture.findByCode", query = "SELECT c FROM Culture c WHERE c.code = :code"),
    @NamedQuery(name = "Culture.findByName", query = "SELECT c FROM Culture c WHERE c.name = :name")
    })
public class Culture implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    public Culture()
        {
        }
    public Culture(String code)
        {
        this.code = code;
        }
    public Culture(String code, String name)
        {
        this.code = code;
        this.name = name;
        }
    public String getCode()
        {
        return code;
        }
    public void setCode(String code)
        {
        this.code = code;
        }
    public String getName()
        {
        return name;
        }
    public void setName(String name)
        {
        this.name = name;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Culture))
            {
            return false;
            }
        Culture other = (Culture) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Culture[ code=" + code + " ]";
        }
    
    }
