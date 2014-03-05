/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "datavalues")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Datavalues.findAll", query = "SELECT d FROM Datavalues d"),
    @NamedQuery(name = "Datavalues.findByValueID", query = "SELECT d FROM Datavalues d WHERE d.valueID = :valueID"),
    @NamedQuery(name = "Datavalues.findByDataValue", query = "SELECT d FROM Datavalues d WHERE d.dataValue = :dataValue"),
    @NamedQuery(name = "Datavalues.findByValueAccuracy", query = "SELECT d FROM Datavalues d WHERE d.valueAccuracy = :valueAccuracy"),
    @NamedQuery(name = "Datavalues.findByLocalDateTime", query = "SELECT d FROM Datavalues d WHERE d.localDateTime = :localDateTime"),
    @NamedQuery(name = "Datavalues.findByUTCOffset", query = "SELECT d FROM Datavalues d WHERE d.uTCOffset = :uTCOffset"),
    @NamedQuery(name = "Datavalues.findByDateTimeUTC", query = "SELECT d FROM Datavalues d WHERE d.dateTimeUTC = :dateTimeUTC"),
    @NamedQuery(name = "Datavalues.findByOffsetValue", query = "SELECT d FROM Datavalues d WHERE d.offsetValue = :offsetValue"),
    @NamedQuery(name = "Datavalues.findByDerivedFromID", query = "SELECT d FROM Datavalues d WHERE d.derivedFromID = :derivedFromID"),
    @NamedQuery(name = "Datavalues.findBySiteID", query = "SELECT d FROM Datavalues d WHERE d.siteID = :siteID")
    })
public class Datavalues implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ValueID")
    private Integer valueID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataValue")
    private double dataValue;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValueAccuracy")
    private Double valueAccuracy;
    @Column(name = "LocalDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date localDateTime;
    @Column(name = "UTCOffset")
    private Double uTCOffset;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateTimeUTC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeUTC;
    @Column(name = "OffsetValue")
    private Double offsetValue;
    @Column(name = "DerivedFromID")
    private Integer derivedFromID;
    @JoinTable(name = "groups", joinColumns =
        {
        @JoinColumn(name = "ValueID", referencedColumnName = "ValueID")
        }, inverseJoinColumns =
        {
        @JoinColumn(name = "GroupID", referencedColumnName = "GroupID")
        })
    @ManyToMany
    private List<Groupdescriptions> groupdescriptionsList;
    @JoinColumn(name = "VariableID", referencedColumnName = "VariableID")
    @ManyToOne(optional = false)
    private Variables variableID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne()
    private User userID;
    @JoinColumn(name = "SourceID", referencedColumnName = "SourceID")
    @ManyToOne
    private Sources sourceID;
    @JoinColumn(name = "SiteID", referencedColumnName = "SiteID")
    @ManyToOne(optional = false)
    private Sites siteID;
    @JoinColumn(name = "SampleID", referencedColumnName = "SampleID")
    @ManyToOne
    private Samples sampleID;
    @JoinColumn(name = "QualityControlLevelID", referencedColumnName = "QualityControlLevelID")
    @ManyToOne
    private Qualitycontrollevels qualityControlLevelID;
    @JoinColumn(name = "QualifierID", referencedColumnName = "QualifierID")
    @ManyToOne
    private Qualifiers qualifierID;
    @JoinColumn(name = "OffsetTypeID", referencedColumnName = "OffsetTypeID")
    @ManyToOne
    private Offsettypes offsetTypeID;
    @JoinColumn(name = "MethodID", referencedColumnName = "MethodID")
    @ManyToOne(optional = false)
    private Methods methodID;
    @JoinColumn(name = "imomoSensorID", referencedColumnName = "sensorID")
    @ManyToOne
    private ImomoSensor imomoSensorID;
    @JoinColumn(name = "CensorCode", referencedColumnName = "Term")
    @ManyToOne
    private Censorcodecv censorCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "valueID")
    private List<Derivedfrom> derivedfromList;
    public Datavalues()
        {
        }
    public Datavalues(Integer valueID)
        {
        this.valueID = valueID;
        }
    public Datavalues(Integer valueID, double dataValue, Date dateTimeUTC)
        {
        this.valueID = valueID;
        this.dataValue = dataValue;
        this.dateTimeUTC = dateTimeUTC;
        }
    public Integer getValueID()
        {
        return valueID;
        }
    public void setValueID(Integer valueID)
        {
        this.valueID = valueID;
        }
    public double getDataValue()
        {
        return dataValue;
        }
    public void setDataValue(double dataValue)
        {
        this.dataValue = dataValue;
        }
    public Double getValueAccuracy()
        {
        return valueAccuracy;
        }
    public void setValueAccuracy(Double valueAccuracy)
        {
        this.valueAccuracy = valueAccuracy;
        }
    public Date getLocalDateTime()
        {
        return localDateTime;
        }
    public void setLocalDateTime(Date localDateTime)
        {
        this.localDateTime = localDateTime;
        }
    public Double getUTCOffset()
        {
        return uTCOffset;
        }
    public void setUTCOffset(Double uTCOffset)
        {
        this.uTCOffset = uTCOffset;
        }
    public Date getDateTimeUTC()
        {
        return dateTimeUTC;
        }
    public void setDateTimeUTC(Date dateTimeUTC)
        {
        this.dateTimeUTC = dateTimeUTC;
        }
    public Double getOffsetValue()
        {
        return offsetValue;
        }
    public void setOffsetValue(Double offsetValue)
        {
        this.offsetValue = offsetValue;
        }
    public Integer getDerivedFromID()
        {
        return derivedFromID;
        }
    public void setDerivedFromID(Integer derivedFromID)
        {
        this.derivedFromID = derivedFromID;
        }
    @XmlTransient
    public List<Groupdescriptions> getGroupdescriptionsList()
        {
        return groupdescriptionsList;
        }
    public void setGroupdescriptionsList(List<Groupdescriptions> groupdescriptionsList)
        {
        this.groupdescriptionsList = groupdescriptionsList;
        }
    public Variables getVariableID()
        {
        return variableID;
        }
    public void setVariableID(Variables variableID)
        {
        this.variableID = variableID;
        }
    public User getUserID()
        {
        return userID;
        }
    public void setUserID(User userID)
        {
        this.userID = userID;
        }
    public Sources getSourceID()
        {
        return sourceID;
        }
    public void setSourceID(Sources sourceID)
        {
        this.sourceID = sourceID;
        }
    public Sites getSiteID()
        {
        return siteID;
        }
    public void setSiteID(Sites siteID)
        {
        this.siteID = siteID;
        }
    public Samples getSampleID()
        {
        return sampleID;
        }
    public void setSampleID(Samples sampleID)
        {
        this.sampleID = sampleID;
        }
    public Qualitycontrollevels getQualityControlLevelID()
        {
        return qualityControlLevelID;
        }
    public void setQualityControlLevelID(Qualitycontrollevels qualityControlLevelID)
        {
        this.qualityControlLevelID = qualityControlLevelID;
        }
    public Qualifiers getQualifierID()
        {
        return qualifierID;
        }
    public void setQualifierID(Qualifiers qualifierID)
        {
        this.qualifierID = qualifierID;
        }
    public Offsettypes getOffsetTypeID()
        {
        return offsetTypeID;
        }
    public void setOffsetTypeID(Offsettypes offsetTypeID)
        {
        this.offsetTypeID = offsetTypeID;
        }
    public Methods getMethodID()
        {
        return methodID;
        }
    public void setMethodID(Methods methodID)
        {
        this.methodID = methodID;
        }
    public ImomoSensor getImomoSensorID()
        {
        return imomoSensorID;
        }
    public void setImomoSensorID(ImomoSensor imomoSensorID)
        {
        this.imomoSensorID = imomoSensorID;
        }
    public Censorcodecv getCensorCode()
        {
        return censorCode;
        }
    public void setCensorCode(Censorcodecv censorCode)
        {
        this.censorCode = censorCode;
        }
    @XmlTransient
    public List<Derivedfrom> getDerivedfromList()
        {
        return derivedfromList;
        }
    public void setDerivedfromList(List<Derivedfrom> derivedfromList)
        {
        this.derivedfromList = derivedfromList;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (valueID != null ? valueID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datavalues))
            {
            return false;
            }
        Datavalues other = (Datavalues) object;
        if ((this.valueID == null && other.valueID != null) || (this.valueID != null && !this.valueID.equals(other.valueID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Datavalues[ valueID=" + valueID + " ]";
        }
    
    }
