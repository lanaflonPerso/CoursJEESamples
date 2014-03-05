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
 * @author Raphaël
 */
@Embeddable
public class GamePossibleResponseLocalPK implements Serializable
    {
    @Basic(optional = false)
    @NotNull
    @Column(name = "possibleResponseID")
    private int possibleResponseID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cultureCode")
    private String cultureCode;
    public GamePossibleResponseLocalPK()
        {
        }
    public GamePossibleResponseLocalPK(int possibleResponseID, String cultureCode)
        {
        this.possibleResponseID = possibleResponseID;
        this.cultureCode = cultureCode;
        }
    public int getPossibleResponseID()
        {
        return possibleResponseID;
        }
    public void setPossibleResponseID(int possibleResponseID)
        {
        this.possibleResponseID = possibleResponseID;
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
        hash += (int) possibleResponseID;
        hash += (cultureCode != null ? cultureCode.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GamePossibleResponseLocalPK))
            {
            return false;
            }
        GamePossibleResponseLocalPK other = (GamePossibleResponseLocalPK) object;
        if (this.possibleResponseID != other.possibleResponseID)
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
        return "src.entities.GamePossibleResponseLocalPK[ possibleResponseID=" + possibleResponseID + ", cultureCode=" + cultureCode + " ]";
        }
    
    }
