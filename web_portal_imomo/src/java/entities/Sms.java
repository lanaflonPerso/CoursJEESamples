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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "sms")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Sms.findAll", query = "SELECT s FROM Sms s"),
    @NamedQuery(name = "Sms.findBySmsID", query = "SELECT s FROM Sms s WHERE s.smsID = :smsID"),
    @NamedQuery(name = "Sms.findByGsmTerminalID", query = "SELECT s FROM Sms s WHERE s.gsmTerminalID = :gsmTerminalID"),
    @NamedQuery(name = "Sms.findByPhoneNB", query = "SELECT s FROM Sms s WHERE s.phoneNB = :phoneNB"),
    @NamedQuery(name = "Sms.findByText", query = "SELECT s FROM Sms s WHERE s.text = :text"),
    @NamedQuery(name = "Sms.findByDateTime", query = "SELECT s FROM Sms s WHERE s.dateTime = :dateTime"),
    @NamedQuery(name = "Sms.findByStatus", query = "SELECT s FROM Sms s WHERE s.status = :status")
    })
public class Sms implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SmsID")
    private Integer smsID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GsmTerminalID")
    private int gsmTerminalID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PhoneNB")
    private String phoneNB;
    @Size(max = 255)
    @Column(name = "Text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;
    public Sms()
        {
        }
    public Sms(Integer smsID)
        {
        this.smsID = smsID;
        }
    public Sms(Integer smsID, int gsmTerminalID, String phoneNB, Date dateTime, int status)
        {
        this.smsID = smsID;
        this.gsmTerminalID = gsmTerminalID;
        this.phoneNB = phoneNB;
        this.dateTime = dateTime;
        this.status = status;
        }
    public Integer getSmsID()
        {
        return smsID;
        }
    public void setSmsID(Integer smsID)
        {
        this.smsID = smsID;
        }
    public int getGsmTerminalID()
        {
        return gsmTerminalID;
        }
    public void setGsmTerminalID(int gsmTerminalID)
        {
        this.gsmTerminalID = gsmTerminalID;
        }
    public String getPhoneNB()
        {
        return phoneNB;
        }
    public void setPhoneNB(String phoneNB)
        {
        this.phoneNB = phoneNB;
        }
    public String getText()
        {
        return text;
        }
    public void setText(String text)
        {
        this.text = text;
        }
    public Date getDateTime()
        {
        return dateTime;
        }
    public void setDateTime(Date dateTime)
        {
        this.dateTime = dateTime;
        }
    public int getStatus()
        {
        return status;
        }
    public void setStatus(int status)
        {
        this.status = status;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (smsID != null ? smsID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sms))
            {
            return false;
            }
        Sms other = (Sms) object;
        if ((this.smsID == null && other.smsID != null) || (this.smsID != null && !this.smsID.equals(other.smsID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Sms[ smsID=" + smsID + " ]";
        }
    
    }
