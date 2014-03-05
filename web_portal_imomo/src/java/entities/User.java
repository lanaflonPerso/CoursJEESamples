/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import tools.Constant;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserID", query = "SELECT u FROM User u WHERE u.userID = :userID"),
    @NamedQuery(name = "User.findByPhoneNb", query = "SELECT u FROM User u WHERE u.phoneNb = :phoneNb"),
    @NamedQuery(name = "User.findByNickname", query = "SELECT u FROM User u WHERE u.nickname = :nickname"),
    @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByGsmTerminalID", query = "SELECT u FROM User u WHERE u.gsmTerminalID = :gsmTerminalID"),
    @NamedQuery(name = "User.findByCulture", query = "SELECT u FROM User u WHERE u.culture = :culture")
    })
public class User implements Serializable
    {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID", orphanRemoval = true)
    private List<UserRole> userRoleList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userID")
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "phoneNb")
    private String phoneNb;
    @Size(min = Constant.MIN_SIZE_USERNAME, max = Constant.MAX_SIZE_NORMAL_INPUT)
    @Column(name = "nickname")
    private String nickname;
    @Size(max = Constant.MAX_SIZE_NORMAL_INPUT)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = Constant.MAX_SIZE_NORMAL_INPUT)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = Constant.MAX_SIZE_PASSWORD)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gsmTerminalID")
    private int gsmTerminalID;
    @Size(max = 5)
    @Column(name = "culture")
    private String culture;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private GameUser gameUser;
    @OneToMany(mappedBy = "userID")
    private List<Datavalues> datavaluesList;
    @NotNull
    @Column(name = "activated")
    private boolean activated;
    
        public boolean getActivated()
        {
        return activated;
        }
    public void setActivated(boolean activated)
        {
        this.activated = activated;
        }
    public User()
        {
        }
    public User(Integer userID)
        {
        this.userID = userID;
        }
    public User(Integer userID, String phoneNb, int gsmTerminalID)
        {
        this.userID = userID;
        this.phoneNb = phoneNb;
        this.gsmTerminalID = gsmTerminalID;
        }
    public Integer getUserID()
        {
        return userID;
        }
    public void setUserID(Integer userID)
        {
        this.userID = userID;
        }
    public String getPhoneNb()
        {
        return phoneNb;
        }
    public void setPhoneNb(String phoneNb)
        {
        this.phoneNb = phoneNb;
        }
    public String getNickname()
        {
        return nickname;
        }
    public void setNickname(String nickname)
        {
        this.nickname = nickname;
        }
    public String getLastname()
        {
        return lastname;
        }
    public void setLastname(String lastname)
        {
        this.lastname = lastname;
        }
    public String getFirstname()
        {
        return firstname;
        }
    public void setFirstname(String firstname)
        {
        this.firstname = firstname;
        }
    public String getPassword()
        {
        return password;
        }
    public void setPassword(String password)
        {
        this.password = password;
        }
    public int getGsmTerminalID()
        {
        return gsmTerminalID;
        }
    public void setGsmTerminalID(int gsmTerminalID)
        {
        this.gsmTerminalID = gsmTerminalID;
        }
    public String getCulture()
        {
        return culture;
        }
    public void setCulture(String culture)
        {
        this.culture = culture;
        }
    public GameUser getGameUser()
        {
        return gameUser;
        }
    public void setGameUser(GameUser gameUser)
        {
        this.gameUser = gameUser;
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
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User))
            {
            return false;
            }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.User[ userID=" + userID + " ]";
        }
    @XmlTransient
    public List<UserRole> getUserRoleList()
        {
        return userRoleList;
        }
    public void setUserRoleList(List<UserRole> userRoleList)
        {
        this.userRoleList = userRoleList;
        }
    public boolean hasNickname()
        {
        return this.nickname.length() > 0;
        }
    }
