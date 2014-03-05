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
public class GameQuestionLocalPK implements Serializable
    {
    @Basic(optional = false)
    @NotNull
    @Column(name = "questionID")
    private int questionID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cultureCode")
    private String cultureCode;
    public GameQuestionLocalPK()
        {
        }
    public GameQuestionLocalPK(int questionID, String cultureCode)
        {
        this.questionID = questionID;
        this.cultureCode = cultureCode;
        }
    public int getQuestionID()
        {
        return questionID;
        }
    public void setQuestionID(int questionID)
        {
        this.questionID = questionID;
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
        hash += (int) questionID;
        hash += (cultureCode != null ? cultureCode.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameQuestionLocalPK))
            {
            return false;
            }
        GameQuestionLocalPK other = (GameQuestionLocalPK) object;
        if (this.questionID != other.questionID)
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
        return "src.entities.GameQuestionLocalPK[ questionID=" + questionID + ", cultureCode=" + cultureCode + " ]";
        }
    
    }
