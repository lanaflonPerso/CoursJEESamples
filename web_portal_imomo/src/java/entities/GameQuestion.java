/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "game_question")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "GameQuestion.findAll", query = "SELECT g FROM GameQuestion g"),
    @NamedQuery(name = "GameQuestion.findByQuestionID", query = "SELECT g FROM GameQuestion g WHERE g.questionID = :questionID"),
    @NamedQuery(name = "GameQuestion.findByKeyword", query = "SELECT g FROM GameQuestion g WHERE g.keyword = :keyword"),
    @NamedQuery(name = "GameQuestion.findByUserResponseAllowed", query = "SELECT g FROM GameQuestion g WHERE g.userResponseAllowed = :userResponseAllowed"),
    @NamedQuery(name = "GameQuestion.findByTimeBetweenResponses", query = "SELECT g FROM GameQuestion g WHERE g.timeBetweenResponses = :timeBetweenResponses")
    })
public class GameQuestion implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "questionID")
    private Integer questionID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "keyword")
    private String keyword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userResponseAllowed")
    private boolean userResponseAllowed; 
    @Basic(optional = false)
    @NotNull
    @Column(name = "timeBetweenResponses")
    private int timeBetweenResponses;
    @Basic(optional = false)
    @NotNull    
    @Column(name = "profLevel")
    private int profLevel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionID")
    private List<GameResponse> gameResponseList;
    @JoinColumn(name = "variableID", referencedColumnName = "VariableID")
    @ManyToOne
    private Variables variableID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionID")
    private List<GamePossibleResponse> gamePossibleResponseList;
    public GameQuestion()
        {
        }
    public GameQuestion(Integer questionID)
        {
        this.questionID = questionID;
        }
    public GameQuestion(Integer questionID, String keyword, boolean userResponseAllowed, int timeBetweenResponses)
        {
        this.questionID = questionID;
        this.keyword = keyword;
        this.userResponseAllowed = userResponseAllowed;
        this.timeBetweenResponses = timeBetweenResponses;
        }
    public Integer getQuestionID()
        {
        return questionID;
        }
    public void setQuestionID(Integer questionID)
        {
        this.questionID = questionID;
        }
    public String getKeyword()
        {
        return keyword;
        }
    public void setKeyword(String keyword)
        {
        this.keyword = keyword;
        }
    public boolean getUserResponseAllowed()
        {
        return userResponseAllowed;
        }
    public void setUserResponseAllowed(boolean userResponseAllowed)
        {
        this.userResponseAllowed = userResponseAllowed;
        }
    public int getTimeBetweenResponses()
        {
        return timeBetweenResponses;
        }
    public void setTimeBetweenResponses(int timeBetweenResponses)
        {
        this.timeBetweenResponses = timeBetweenResponses;
        }
    public int getProfLevel() {
        return profLevel;
    }

    public void setProfLevel(int profLevel) {
        this.profLevel = profLevel;
    }
    
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
    public Variables getVariableID()
        {
        return variableID;
        }
    public void setVariableID(Variables variableID)
        {
        this.variableID = variableID;
        }
    @XmlTransient
    public List<GamePossibleResponse> getGamePossibleResponseList()
        {
        return gamePossibleResponseList;
        }
    public void setGamePossibleResponseList(List<GamePossibleResponse> gamePossibleResponseList)
        {
        this.gamePossibleResponseList = gamePossibleResponseList;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (questionID != null ? questionID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameQuestion))
            {
            return false;
            }
        GameQuestion other = (GameQuestion) object;
        if ((this.questionID == null && other.questionID != null) || (this.questionID != null && !this.questionID.equals(other.questionID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.GameQuestion[ questionID=" + questionID + " ]";
        }

    public Iterable<GameQuestion> getChildren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }
