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
 * @author Raphaël
 */
@Entity
@Table(name = "game_possible_response_local")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "GamePossibleResponseLocal.findAll", query = "SELECT g FROM GamePossibleResponseLocal g"),
    @NamedQuery(name = "GamePossibleResponseLocal.findByPossibleResponseID", query = "SELECT g FROM GamePossibleResponseLocal g WHERE g.gamePossibleResponseLocalPK.possibleResponseID = :possibleResponseID"),
    @NamedQuery(name = "GamePossibleResponseLocal.findByCultureCode", query = "SELECT g FROM GamePossibleResponseLocal g WHERE g.gamePossibleResponseLocalPK.cultureCode = :cultureCode"),
    @NamedQuery(name = "GamePossibleResponseLocal.findByText", query = "SELECT g FROM GamePossibleResponseLocal g WHERE g.text = :text")
    })
public class GamePossibleResponseLocal implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GamePossibleResponseLocalPK gamePossibleResponseLocalPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "text")
    private String text;
//    private String cultureCode;
    public GamePossibleResponseLocal()
        {
        }
    public GamePossibleResponseLocal(GamePossibleResponseLocalPK gamePossibleResponseLocalPK)
        {
        this.gamePossibleResponseLocalPK = gamePossibleResponseLocalPK;
        }
    public GamePossibleResponseLocal(GamePossibleResponseLocalPK gamePossibleResponseLocalPK, String text)
        {
        this.gamePossibleResponseLocalPK = gamePossibleResponseLocalPK;
        this.text = text;
        }
    public GamePossibleResponseLocal(int possibleResponseID, String cultureCode)
        {
        this.gamePossibleResponseLocalPK = new GamePossibleResponseLocalPK(possibleResponseID, cultureCode);
        }
    public GamePossibleResponseLocalPK getGamePossibleResponseLocalPK()
        {
        return gamePossibleResponseLocalPK;
        }
    public void setGamePossibleResponseLocalPK(GamePossibleResponseLocalPK gamePossibleResponseLocalPK)
        {
        this.gamePossibleResponseLocalPK = gamePossibleResponseLocalPK;
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
        hash += (gamePossibleResponseLocalPK != null ? gamePossibleResponseLocalPK.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GamePossibleResponseLocal))
            {
            return false;
            }
        GamePossibleResponseLocal other = (GamePossibleResponseLocal) object;
        if ((this.gamePossibleResponseLocalPK == null && other.gamePossibleResponseLocalPK != null) || (this.gamePossibleResponseLocalPK != null && !this.gamePossibleResponseLocalPK.equals(other.gamePossibleResponseLocalPK)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.GamePossibleResponseLocal[ gamePossibleResponseLocalPK=" + gamePossibleResponseLocalPK + " ]";
        }
    
    }
