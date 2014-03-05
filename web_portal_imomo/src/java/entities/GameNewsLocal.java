/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andreea Mihet
 */
@Entity
@Table(name = "game_news_local")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "GameNewsLocal.findAll", query = "SELECT g FROM GameNewsLocal g"),
    @NamedQuery(name = "GameNewsLocal.findByNewsID", query = "SELECT g FROM GameNewsLocal g WHERE g.gameNewsLocalPK.newsID = :newsID"),
    @NamedQuery(name = "GameNewsLocal.findByCultureCode", query = "SELECT g FROM GameNewsLocal g WHERE g.gameNewsLocalPK.cultureCode = :cultureCode"),
    @NamedQuery(name = "GameNewsLocal.findByTitle", query = "SELECT g FROM GameNewsLocal g WHERE g.title = :title"),
    @NamedQuery(name = "GameNewsLocal.findByText", query = "SELECT g FROM GameNewsLocal g WHERE g.text = :text")
    })
public class GameNewsLocal implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GameNewsLocalPK gameNewsLocalPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "text")
    private String text;
//    private String cultureCode;
    public GameNewsLocal(){
        }
    public GameNewsLocal(GameNewsLocalPK gameNewsLocalPK)
        {
        this.gameNewsLocalPK = gameNewsLocalPK;
        }
    public GameNewsLocal(GameNewsLocalPK gameNewsLocalPK, String text)
        {
        this.gameNewsLocalPK = gameNewsLocalPK;
        this.text = text;
        }
    public GameNewsLocal(int newsID, String cultureCode)
        {
        this.gameNewsLocalPK = new GameNewsLocalPK(newsID, cultureCode);
        }
    public GameNewsLocalPK getGameNewsLocalPK()
        {
        return gameNewsLocalPK;
        }
    public void setGameNewsLocalPK(GameNewsLocalPK gameNewsLocalPK)
        {
        this.gameNewsLocalPK = gameNewsLocalPK;
        }
    public String getTitle()
        {
        return title;
        }
    public void setTitle(String title)
        {
        this.title = title;
        }
    public String getText()
        {
        return text;
        }
    public void setText(String text)
        {
        this.text = text;
        }
    
//    public String getCultureCode()
//        {
//        return cultureCode;
//        }
//    public void setCultureCode(String cultureCode)
//        {
//        this.cultureCode = cultureCode;
//        }
    
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (gameNewsLocalPK != null ? gameNewsLocalPK.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameNewsLocal))
            {
            return false;
            }
        GameNewsLocal other = (GameNewsLocal) object;
        if ((this.gameNewsLocalPK == null && other.gameNewsLocalPK != null) || (this.gameNewsLocalPK != null && !this.gameNewsLocalPK.equals(other.gameNewsLocalPK)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.GameNewsLocal[ gameNewsLocalPK=" + gameNewsLocalPK + " ]";
        }
    
    }
