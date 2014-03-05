/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "game_user")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "GameUser.findAll", query = "SELECT g FROM GameUser g"),
    @NamedQuery(name = "GameUser.findByUserID", query = "SELECT g FROM GameUser g WHERE g.userID = :userID"),
    @NamedQuery(name = "GameUser.findByScore", query = "SELECT g FROM GameUser g WHERE g.score = :score"),
    @NamedQuery(name = "GameUser.findByHealth", query = "SELECT g FROM GameUser g WHERE g.health = :health"),
    @NamedQuery(name = "GameUser.findByLastUseDate", query = "SELECT g FROM GameUser g WHERE g.lastUseDate = :lastUseDate"),
    @NamedQuery(name = "GameUser.findByRegistrationDate", query = "SELECT g FROM GameUser g WHERE g.registrationDate = :registrationDate"),
    @NamedQuery(name = "GameUser.findByProfLevel", query = "SELECT g FROM GameUser g WHERE g.profLevel = :profLevel")
    })
public class GameUser implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userID")
    private Integer userID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score")
    private int score;
    @Basic(optional = false)
    @NotNull
    @Column(name = "health")
    private int health;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lastUseDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUseDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registrationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;
    @Column(name = "profLevel")
    private Short profLevel;
    @JoinTable(name = "game_friend", joinColumns =
        {
        @JoinColumn(name = "friendID", referencedColumnName = "userID")
        }, inverseJoinColumns =
        {
        @JoinColumn(name = "userID", referencedColumnName = "userID")
        })
    @ManyToMany
    private List<GameUser> gameUserList;
    @ManyToMany(mappedBy = "gameUserList")
    private List<GameUser> gameUserList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private List<GameResponse> gameResponseList;
    @JoinColumn(name = "defaultSiteID", referencedColumnName = "SiteID")
    @ManyToOne(optional = false)
    private Sites defaultSiteID;
    @JoinColumn(name = "userID", referencedColumnName = "userID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;
    public GameUser()
        {
        }
    public GameUser(Integer userID)
        {
        this.userID = userID;
        }
    public GameUser(Integer userID, int score, int health, Date lastUseDate, Date registrationDate)
        {
        this.userID = userID;
        this.score = score;
        this.health = health;
        this.lastUseDate = lastUseDate;
        this.registrationDate = registrationDate;
        }
    @PrePersist
    private void onCreate()
        {
        lastUseDate = new Date();
        registrationDate = new Date();
        }
    public Integer getUserID()
        {
        return userID;
        }
    public void setUserID(Integer userID)
        {
        this.userID = userID;
        }
    public int getScore()
        {
        return score;
        }
    public void setScore(int score)
        {
        this.score = score;
        }
    public int getHealth()
        {
        return health;
        }
    public void setHealth(int health)
        {
        this.health = health;
        }
    public Date getLastUseDate()
        {
        return lastUseDate;
        }
    public void setLastUseDate(Date lastUseDate)
        {
        this.lastUseDate = lastUseDate;
        }
    public Date getRegistrationDate()
        {
        return registrationDate;
        }
    public void setRegistrationDate(Date registrationDate)
        {
        this.registrationDate = registrationDate;
        }
    public Short getProfLevel()
        {
        return profLevel;
        }
    public void setProfLevel(Short profLevel)
        {
        this.profLevel = profLevel;
        }
    @XmlTransient
    public List<GameUser> getGameUserList()
        {
        return gameUserList;
        }
    public void setGameUserList(List<GameUser> gameUserList)
        {
        this.gameUserList = gameUserList;
        }
    @XmlTransient
    public List<GameUser> getGameUserList1()
        {
        return gameUserList1;
        }
    public void setGameUserList1(List<GameUser> gameUserList1)
        {
        this.gameUserList1 = gameUserList1;
        }
    @XmlTransient
    public List<GameResponse> getGameResponseList()
        {
        return gameResponseList;
        }
    public void setGameResponseList(List<GameResponse> gameResponseList)
        {
        this.gameResponseList = gameResponseList;
        }
    public Sites getDefaultSiteID()
        {
        return defaultSiteID;
        }
    public void setDefaultSiteID(Sites defaultSiteID)
        {
        this.defaultSiteID = defaultSiteID;
        }
    public User getUser()
        {
        return user;
        }
    public void setUser(User user)
        {
        this.user = user;
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
        if (!(object instanceof GameUser))
            {
            return false;
            }
        GameUser other = (GameUser) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.GameUser[ userID=" + userID + " ]";
        }
    }
