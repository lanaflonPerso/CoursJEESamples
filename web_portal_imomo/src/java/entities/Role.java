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
@Table(name = "role")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name"),
    @NamedQuery(name = "Role.findByInfo", query = "SELECT r FROM Role r WHERE r.info = :info")
    })
public class Role implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "info")
    private String info;
    
    public Role()
        {
        }
    public Role(String name)
        {
        this.name = name;
        }

    public String getName()
        {
        return name;
        }
    public void setName(String name)
        {
        this.name = name;
        }
    public String getInfo()
        {
        return info;
        }
    public void setInfo(String info)
        {
        this.info = info;
        }
    
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role))
            {
            return false;
            }
        Role other = (Role) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return name;
        }
    
    }
