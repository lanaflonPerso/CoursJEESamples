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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andreea Mihet
 */
@Entity
@Table(name = "game_news")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "GameNews.findAll", query = "SELECT g FROM GameNews g"),
    @NamedQuery(name = "GameNews.findByNewsID", query = "SELECT g FROM GameNews g WHERE g.newsID = :newsID"),
    @NamedQuery(name = "GameNews.findBydateTimeUTC", query = "SELECT g FROM GameNews g WHERE g.dateTimeUTC = :dateTimeUTC")
    })
public class GameNews implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "newsID")
    private Integer newsID;
    @Basic(optional = false)
    @NotNull    
    @Column(name = "dateTimeUTC")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTimeUTC;    

    public GameNews(){
        }
    public GameNews(Integer newsID){
        this.newsID = newsID;
        }
    public GameNews(Integer newsID, Date dateTimeUTC)
        {
        this.newsID = newsID;
        this.dateTimeUTC = dateTimeUTC;
        }
    public Integer getNewsID()
        {
        return newsID;
        }
    public void setNewsID(Integer newsID)
        {
        this.newsID = newsID;
        }
    public Date getDateTimeUTC()
        {
        return dateTimeUTC;
        }
    public void setDateTimeUTC(Date dateTimeUTC)
        {
        this.dateTimeUTC = dateTimeUTC;
        }

    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (newsID != null ? newsID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameNews))
            {
            return false;
            }
        GameNews other = (GameNews) object;
        if ((this.newsID == null && other.newsID != null) || (this.newsID != null && !this.newsID.equals(other.newsID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.GameNews[ newsID=" + newsID + " ]";
        }

    public Iterable<GameNews> getChildren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }
