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
@Table(name = "gsmterminal")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Gsmterminal.findAll", query = "SELECT g FROM Gsmterminal g"),
    @NamedQuery(name = "Gsmterminal.findByGsmTerminalID", query = "SELECT g FROM Gsmterminal g WHERE g.gsmTerminalID = :gsmTerminalID"),
    @NamedQuery(name = "Gsmterminal.findByCountry", query = "SELECT g FROM Gsmterminal g WHERE g.country = :country"),
    @NamedQuery(name = "Gsmterminal.findByOperator", query = "SELECT g FROM Gsmterminal g WHERE g.operator = :operator")
    })
public class Gsmterminal implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GsmTerminalID")
    private Integer gsmTerminalID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Operator")
    private String operator;
    public Gsmterminal()
        {
        }
    public Gsmterminal(Integer gsmTerminalID)
        {
        this.gsmTerminalID = gsmTerminalID;
        }
    public Gsmterminal(Integer gsmTerminalID, String country, String operator)
        {
        this.gsmTerminalID = gsmTerminalID;
        this.country = country;
        this.operator = operator;
        }
    public Integer getGsmTerminalID()
        {
        return gsmTerminalID;
        }
    public void setGsmTerminalID(Integer gsmTerminalID)
        {
        this.gsmTerminalID = gsmTerminalID;
        }
    public String getCountry()
        {
        return country;
        }
    public void setCountry(String country)
        {
        this.country = country;
        }
    public String getOperator()
        {
        return operator;
        }
    public void setOperator(String operator)
        {
        this.operator = operator;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (gsmTerminalID != null ? gsmTerminalID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gsmterminal))
            {
            return false;
            }
        Gsmterminal other = (Gsmterminal) object;
        if ((this.gsmTerminalID == null && other.gsmTerminalID != null) || (this.gsmTerminalID != null && !this.gsmTerminalID.equals(other.gsmTerminalID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Gsmterminal[ gsmTerminalID=" + gsmTerminalID + " ]";
        }
    
    }
