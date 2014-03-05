/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "game_possible_response")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "GamePossibleResponse.findAll", query = "SELECT g FROM GamePossibleResponse g"),
    @NamedQuery(name = "GamePossibleResponse.findByPossibleResponseID", query = "SELECT g FROM GamePossibleResponse g WHERE g.possibleResponseID = :possibleResponseID"),
    @NamedQuery(name = "GamePossibleResponse.findByKeyword", query = "SELECT g FROM GamePossibleResponse g WHERE g.keyword = :keyword"),
    @NamedQuery(name = "GamePossibleResponse.findByValue", query = "SELECT g FROM GamePossibleResponse g WHERE g.value = :value")
    })
public class GamePossibleResponse implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "possibleResponseID")
    private Integer possibleResponseID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "keyword")
    private String keyword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private double value;
    @OneToMany(mappedBy = "possibleResponseID")
    private List<GameResponse> gameResponseList;
    @JoinColumn(name = "questionID", referencedColumnName = "questionID")
    @ManyToOne(optional = false)
    private GameQuestion questionID;
    public GamePossibleResponse()
        {
        }
    public GamePossibleResponse(Integer possibleResponseID)
        {
        this.possibleResponseID = possibleResponseID;
        }
    public GamePossibleResponse(Integer possibleResponseID, String keyword, double value)
        {
        this.possibleResponseID = possibleResponseID;
        this.keyword = keyword;
        this.value = value;
        }
    public Integer getPossibleResponseID()
        {
        return possibleResponseID;
        }
    public void setPossibleResponseID(Integer possibleResponseID)
        {
        this.possibleResponseID = possibleResponseID;
        }
    public String getKeyword()
        {
        return keyword;
        }
    public void setKeyword(String keyword)
        {
        this.keyword = keyword;
        }
    public double getValue()
        {
        return value;
        }
    public void setValue(double value)
        {
        this.value = value;
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
    public GameQuestion getQuestionID()
        {
        return questionID;
        }
    public void setQuestionID(GameQuestion questionID)
        {
        this.questionID = questionID;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (possibleResponseID != null ? possibleResponseID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GamePossibleResponse))
            {
            return false;
            }
        GamePossibleResponse other = (GamePossibleResponse) object;
        if ((this.possibleResponseID == null && other.possibleResponseID != null) || (this.possibleResponseID != null && !this.possibleResponseID.equals(other.possibleResponseID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.GamePossibleResponse[ possibleResponseID=" + possibleResponseID + " ]";
        }
    
    }
