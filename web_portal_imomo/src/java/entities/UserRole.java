/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "user_role")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u"),
    @NamedQuery(name = "UserRole.findByUserroleID", query = "SELECT u FROM UserRole u WHERE u.userroleID = :userroleID"),
    @NamedQuery(name = "UserRole.findByRole", query = "SELECT u FROM UserRole u WHERE u.role = :role")
    })
public class UserRole implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userroleID")
    private Integer userroleID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "role")
    private String role;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne(optional = false)
    private User userID;
    public UserRole()
        {
        }
    public UserRole(Integer userroleID)
        {
        this.userroleID = userroleID;
        }
    public UserRole(Integer userroleID, String role, Date createdOn, Date updatedOn)
        {
        this.userroleID = userroleID;
        this.role = role;
        }
    public Integer getUserroleID()
        {
        return userroleID;
        }
    public void setUserroleID(Integer userroleID)
        {
        this.userroleID = userroleID;
        }
    public String getRole()
        {
        return role;
        }
    public void setRole(String role)
        {
        this.role = role;
        }
    public User getUserID()
        {
        return userID;
        }
    public void setUserID(User userID)
        {
        this.userID = userID;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (userroleID != null ? userroleID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole))
            {
            return false;
            }
        UserRole other = (UserRole) object;
        if ((this.userroleID == null && other.userroleID != null) || (this.userroleID != null && !this.userroleID.equals(other.userroleID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "entities.UserRole[ userroleID=" + userroleID + " ]";
        }
    }
