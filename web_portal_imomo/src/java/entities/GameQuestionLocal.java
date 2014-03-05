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
@Table(name = "game_question_local")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "GameQuestionLocal.findAll", query = "SELECT g FROM GameQuestionLocal g"),
    @NamedQuery(name = "GameQuestionLocal.findByQuestionID", query = "SELECT g FROM GameQuestionLocal g WHERE g.gameQuestionLocalPK.questionID = :questionID"),
    @NamedQuery(name = "GameQuestionLocal.findByCultureCode", query = "SELECT g FROM GameQuestionLocal g WHERE g.gameQuestionLocalPK.cultureCode = :cultureCode"),
    @NamedQuery(name = "GameQuestionLocal.findByText", query = "SELECT g FROM GameQuestionLocal g WHERE g.text = :text")
    })
public class GameQuestionLocal implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GameQuestionLocalPK gameQuestionLocalPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "text")
    private String text;
//    private String cultureCode;
    public GameQuestionLocal()
        {
        }
    public GameQuestionLocal(GameQuestionLocalPK gameQuestionLocalPK)
        {
        this.gameQuestionLocalPK = gameQuestionLocalPK;
        }
    public GameQuestionLocal(GameQuestionLocalPK gameQuestionLocalPK, String text)
        {
        this.gameQuestionLocalPK = gameQuestionLocalPK;
        this.text = text;
        }
    public GameQuestionLocal(int questionID, String cultureCode)
        {
        this.gameQuestionLocalPK = new GameQuestionLocalPK(questionID, cultureCode);
        }
    public GameQuestionLocalPK getGameQuestionLocalPK()
        {
        return gameQuestionLocalPK;
        }
    public void setGameQuestionLocalPK(GameQuestionLocalPK gameQuestionLocalPK)
        {
        this.gameQuestionLocalPK = gameQuestionLocalPK;
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
        hash += (gameQuestionLocalPK != null ? gameQuestionLocalPK.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameQuestionLocal))
            {
            return false;
            }
        GameQuestionLocal other = (GameQuestionLocal) object;
        if ((this.gameQuestionLocalPK == null && other.gameQuestionLocalPK != null) || (this.gameQuestionLocalPK != null && !this.gameQuestionLocalPK.equals(other.gameQuestionLocalPK)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.GameQuestionLocal[ gameQuestionLocalPK=" + gameQuestionLocalPK + " ]";
        }
    
    }
