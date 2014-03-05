/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "game_response")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "GameResponse.findAll", query = "SELECT g FROM GameResponse g"),
    @NamedQuery(name = "GameResponse.findByResponseID", query = "SELECT g FROM GameResponse g WHERE g.responseID = :responseID"),
    @NamedQuery(name = "GameResponse.findByUserResponse", query = "SELECT g FROM GameResponse g WHERE g.userResponse = :userResponse"),
    @NamedQuery(name = "GameResponse.findByDateTimeUTC", query = "SELECT g FROM GameResponse g WHERE g.dateTimeUTC = :dateTimeUTC")
    })
public class GameResponse implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "responseID")
    private Integer responseID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "userResponse")
    private Double userResponse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateTimeUTC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeUTC;
    @JoinColumn(name = "questionID", referencedColumnName = "questionID")
    @ManyToOne(optional = false)
    private GameQuestion questionID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne(optional = false)
    private GameUser userID;
    @JoinColumn(name = "possibleResponseID", referencedColumnName = "possibleResponseID")
    @ManyToOne
    private GamePossibleResponse possibleResponseID;
    public GameResponse()
        {
        }
    public GameResponse(Integer responseID)
        {
        this.responseID = responseID;
        }
    public GameResponse(Integer responseID, Date dateTimeUTC)
        {
        this.responseID = responseID;
        this.dateTimeUTC = dateTimeUTC;
        }
    public Integer getResponseID()
        {
        return responseID;
        }
    public void setResponseID(Integer responseID)
        {
        this.responseID = responseID;
        }
    public Double getUserResponse()
        {
        return userResponse;
        }
    public void setUserResponse(Double userResponse)
        {
        this.userResponse = userResponse;
        }
    public Date getDateTimeUTC()
        {
        return dateTimeUTC;
        }
    public void setDateTimeUTC(Date dateTimeUTC)
        {
        this.dateTimeUTC = dateTimeUTC;
        }
    public GameQuestion getQuestionID()
        {
        return questionID;
        }
    public void setQuestionID(GameQuestion questionID)
        {
        this.questionID = questionID;
        }
    public GameUser getUserID()
        {
        return userID;
        }
    public void setUserID(GameUser userID)
        {
        this.userID = userID;
        }
    public GamePossibleResponse getPossibleResponseID()
        {
        return possibleResponseID;
        }
    public void setPossibleResponseID(GamePossibleResponse possibleResponseID)
        {
        this.possibleResponseID = possibleResponseID;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (responseID != null ? responseID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameResponse))
            {
            return false;
            }
        GameResponse other = (GameResponse) object;
        if ((this.responseID == null && other.responseID != null) || (this.responseID != null && !this.responseID.equals(other.responseID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.GameResponse[ responseID=" + responseID + " ]";
        }
    
    }
