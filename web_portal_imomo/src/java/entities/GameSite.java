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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "game_site")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "GameSite.findAll", query = "SELECT g FROM GameSite g"),
    @NamedQuery(name = "GameSite.findBySiteID", query = "SELECT g FROM GameSite g WHERE g.siteID = :siteID")
    })
public class GameSite implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "siteID")
    private Integer siteID;
    @JoinColumn(name = "siteID", referencedColumnName = "SiteID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Sites sites;
    public GameSite()
        {
        }
    public GameSite(Integer siteID)
        {
        this.siteID = siteID;
        }
    public Integer getSiteID()
        {
        return siteID;
        }
    public void setSiteID(Integer siteID)
        {
        this.siteID = siteID;
        }
    public Sites getSites()
        {
        return sites;
        }
    public void setSites(Sites sites)
        {
        this.sites = sites;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (siteID != null ? siteID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameSite))
            {
            return false;
            }
        GameSite other = (GameSite) object;
        if ((this.siteID == null && other.siteID != null) || (this.siteID != null && !this.siteID.equals(other.siteID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.GameSite[ siteID=" + siteID + " ]";
        }
    
    }
