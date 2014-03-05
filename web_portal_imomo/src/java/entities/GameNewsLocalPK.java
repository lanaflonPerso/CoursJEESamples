/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andreea Mihet
 */
@Embeddable
public class GameNewsLocalPK implements Serializable
    {
    @Basic(optional = false)
    @NotNull
    @Column(name = "newsID")
    private int newsID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cultureCode")
    private String cultureCode;
    public GameNewsLocalPK()
        {
        }
    public GameNewsLocalPK(int newsID, String cultureCode)
        {
        this.newsID = newsID;
        this.cultureCode = cultureCode;
        }
    public int getNewsID()
        {
        return newsID;
        }
    public void setNewsID(int newsID)
        {
        this.newsID = newsID;
        }
    public String getCultureCode()
        {
        return cultureCode;
        }
    public void setCultureCode(String cultureCode)
        {
        this.cultureCode = cultureCode;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (int) newsID;
        hash += (cultureCode != null ? cultureCode.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameNewsLocalPK))
            {
            return false;
            }
        GameNewsLocalPK other = (GameNewsLocalPK) object;
        if (this.newsID != other.newsID)
            {
            return false;
            }
        if ((this.cultureCode == null && other.cultureCode != null) || (this.cultureCode != null && !this.cultureCode.equals(other.cultureCode)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.GameNewsLocalPK[ questionID=" + newsID + ", cultureCode=" + cultureCode + " ]";
        }
    
    }
