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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "seriescatalog")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Seriescatalog.findAll", query = "SELECT s FROM Seriescatalog s"),
    @NamedQuery(name = "Seriescatalog.findBySeriesID", query = "SELECT s FROM Seriescatalog s WHERE s.seriesID = :seriesID"),
    @NamedQuery(name = "Seriescatalog.findBySiteID", query = "SELECT s FROM Seriescatalog s WHERE s.siteID = :siteID"),
    @NamedQuery(name = "Seriescatalog.findBySiteCode", query = "SELECT s FROM Seriescatalog s WHERE s.siteCode = :siteCode"),
    @NamedQuery(name = "Seriescatalog.findBySiteName", query = "SELECT s FROM Seriescatalog s WHERE s.siteName = :siteName"),
    @NamedQuery(name = "Seriescatalog.findByVariableID", query = "SELECT s FROM Seriescatalog s WHERE s.variableID = :variableID"),
    @NamedQuery(name = "Seriescatalog.findByVariableCode", query = "SELECT s FROM Seriescatalog s WHERE s.variableCode = :variableCode"),
    @NamedQuery(name = "Seriescatalog.findByVariableName", query = "SELECT s FROM Seriescatalog s WHERE s.variableName = :variableName"),
    @NamedQuery(name = "Seriescatalog.findBySpeciation", query = "SELECT s FROM Seriescatalog s WHERE s.speciation = :speciation"),
    @NamedQuery(name = "Seriescatalog.findByVariableUnitsID", query = "SELECT s FROM Seriescatalog s WHERE s.variableUnitsID = :variableUnitsID"),
    @NamedQuery(name = "Seriescatalog.findByVariableUnitsName", query = "SELECT s FROM Seriescatalog s WHERE s.variableUnitsName = :variableUnitsName"),
    @NamedQuery(name = "Seriescatalog.findBySampleMedium", query = "SELECT s FROM Seriescatalog s WHERE s.sampleMedium = :sampleMedium"),
    @NamedQuery(name = "Seriescatalog.findByValueType", query = "SELECT s FROM Seriescatalog s WHERE s.valueType = :valueType"),
    @NamedQuery(name = "Seriescatalog.findByTimeSupport", query = "SELECT s FROM Seriescatalog s WHERE s.timeSupport = :timeSupport"),
    @NamedQuery(name = "Seriescatalog.findByTimeUnitsID", query = "SELECT s FROM Seriescatalog s WHERE s.timeUnitsID = :timeUnitsID"),
    @NamedQuery(name = "Seriescatalog.findByTimeUnitsName", query = "SELECT s FROM Seriescatalog s WHERE s.timeUnitsName = :timeUnitsName"),
    @NamedQuery(name = "Seriescatalog.findByDataType", query = "SELECT s FROM Seriescatalog s WHERE s.dataType = :dataType"),
    @NamedQuery(name = "Seriescatalog.findByGeneralCategory", query = "SELECT s FROM Seriescatalog s WHERE s.generalCategory = :generalCategory"),
    @NamedQuery(name = "Seriescatalog.findByMethodID", query = "SELECT s FROM Seriescatalog s WHERE s.methodID = :methodID"),
    @NamedQuery(name = "Seriescatalog.findBySourceID", query = "SELECT s FROM Seriescatalog s WHERE s.sourceID = :sourceID"),
    @NamedQuery(name = "Seriescatalog.findByOrganization", query = "SELECT s FROM Seriescatalog s WHERE s.organization = :organization"),
    @NamedQuery(name = "Seriescatalog.findByQualityControlLevelID", query = "SELECT s FROM Seriescatalog s WHERE s.qualityControlLevelID = :qualityControlLevelID"),
    @NamedQuery(name = "Seriescatalog.findByQualityControlLevelCode", query = "SELECT s FROM Seriescatalog s WHERE s.qualityControlLevelCode = :qualityControlLevelCode"),
    @NamedQuery(name = "Seriescatalog.findByBeginDateTime", query = "SELECT s FROM Seriescatalog s WHERE s.beginDateTime = :beginDateTime"),
    @NamedQuery(name = "Seriescatalog.findByEndDateTime", query = "SELECT s FROM Seriescatalog s WHERE s.endDateTime = :endDateTime"),
    @NamedQuery(name = "Seriescatalog.findByBeginDateTimeUTC", query = "SELECT s FROM Seriescatalog s WHERE s.beginDateTimeUTC = :beginDateTimeUTC"),
    @NamedQuery(name = "Seriescatalog.findByEndDateTimeUTC", query = "SELECT s FROM Seriescatalog s WHERE s.endDateTimeUTC = :endDateTimeUTC"),
    @NamedQuery(name = "Seriescatalog.findByValueCount", query = "SELECT s FROM Seriescatalog s WHERE s.valueCount = :valueCount")
    })
public class Seriescatalog implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SeriesID")
    private Integer seriesID;
    @Column(name = "SiteID")
    private Integer siteID;
    @Size(max = 50)
    @Column(name = "SiteCode")
    private String siteCode;
    @Size(max = 255)
    @Column(name = "SiteName")
    private String siteName;
    @Column(name = "VariableID")
    private Integer variableID;
    @Size(max = 50)
    @Column(name = "VariableCode")
    private String variableCode;
    @Size(max = 255)
    @Column(name = "VariableName")
    private String variableName;
    @Size(max = 255)
    @Column(name = "Speciation")
    private String speciation;
    @Column(name = "VariableUnitsID")
    private Integer variableUnitsID;
    @Size(max = 255)
    @Column(name = "VariableUnitsName")
    private String variableUnitsName;
    @Size(max = 255)
    @Column(name = "SampleMedium")
    private String sampleMedium;
    @Size(max = 255)
    @Column(name = "ValueType")
    private String valueType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TimeSupport")
    private Double timeSupport;
    @Column(name = "TimeUnitsID")
    private Integer timeUnitsID;
    @Size(max = 255)
    @Column(name = "TimeUnitsName")
    private String timeUnitsName;
    @Size(max = 255)
    @Column(name = "DataType")
    private String dataType;
    @Size(max = 255)
    @Column(name = "GeneralCategory")
    private String generalCategory;
    @Column(name = "MethodID")
    private Integer methodID;
    @Lob
    @Size(max = 65535)
    @Column(name = "MethodDescription")
    private String methodDescription;
    @Column(name = "SourceID")
    private Integer sourceID;
    @Size(max = 255)
    @Column(name = "Organization")
    private String organization;
    @Lob
    @Size(max = 65535)
    @Column(name = "SourceDescription")
    private String sourceDescription;
    @Lob
    @Size(max = 65535)
    @Column(name = "Citation")
    private String citation;
    @Column(name = "QualityControlLevelID")
    private Integer qualityControlLevelID;
    @Size(max = 50)
    @Column(name = "QualityControlLevelCode")
    private String qualityControlLevelCode;
    @Column(name = "BeginDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginDateTime;
    @Column(name = "EndDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDateTime;
    @Column(name = "BeginDateTimeUTC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginDateTimeUTC;
    @Column(name = "EndDateTimeUTC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDateTimeUTC;
    @Column(name = "ValueCount")
    private Integer valueCount;
    public Seriescatalog()
        {
        }
    public Seriescatalog(Integer seriesID)
        {
        this.seriesID = seriesID;
        }
    public Integer getSeriesID()
        {
        return seriesID;
        }
    public void setSeriesID(Integer seriesID)
        {
        this.seriesID = seriesID;
        }
    public Integer getSiteID()
        {
        return siteID;
        }
    public void setSiteID(Integer siteID)
        {
        this.siteID = siteID;
        }
    public String getSiteCode()
        {
        return siteCode;
        }
    public void setSiteCode(String siteCode)
        {
        this.siteCode = siteCode;
        }
    public String getSiteName()
        {
        return siteName;
        }
    public void setSiteName(String siteName)
        {
        this.siteName = siteName;
        }
    public Integer getVariableID()
        {
        return variableID;
        }
    public void setVariableID(Integer variableID)
        {
        this.variableID = variableID;
        }
    public String getVariableCode()
        {
        return variableCode;
        }
    public void setVariableCode(String variableCode)
        {
        this.variableCode = variableCode;
        }
    public String getVariableName()
        {
        return variableName;
        }
    public void setVariableName(String variableName)
        {
        this.variableName = variableName;
        }
    public String getSpeciation()
        {
        return speciation;
        }
    public void setSpeciation(String speciation)
        {
        this.speciation = speciation;
        }
    public Integer getVariableUnitsID()
        {
        return variableUnitsID;
        }
    public void setVariableUnitsID(Integer variableUnitsID)
        {
        this.variableUnitsID = variableUnitsID;
        }
    public String getVariableUnitsName()
        {
        return variableUnitsName;
        }
    public void setVariableUnitsName(String variableUnitsName)
        {
        this.variableUnitsName = variableUnitsName;
        }
    public String getSampleMedium()
        {
        return sampleMedium;
        }
    public void setSampleMedium(String sampleMedium)
        {
        this.sampleMedium = sampleMedium;
        }
    public String getValueType()
        {
        return valueType;
        }
    public void setValueType(String valueType)
        {
        this.valueType = valueType;
        }
    public Double getTimeSupport()
        {
        return timeSupport;
        }
    public void setTimeSupport(Double timeSupport)
        {
        this.timeSupport = timeSupport;
        }
    public Integer getTimeUnitsID()
        {
        return timeUnitsID;
        }
    public void setTimeUnitsID(Integer timeUnitsID)
        {
        this.timeUnitsID = timeUnitsID;
        }
    public String getTimeUnitsName()
        {
        return timeUnitsName;
        }
    public void setTimeUnitsName(String timeUnitsName)
        {
        this.timeUnitsName = timeUnitsName;
        }
    public String getDataType()
        {
        return dataType;
        }
    public void setDataType(String dataType)
        {
        this.dataType = dataType;
        }
    public String getGeneralCategory()
        {
        return generalCategory;
        }
    public void setGeneralCategory(String generalCategory)
        {
        this.generalCategory = generalCategory;
        }
    public Integer getMethodID()
        {
        return methodID;
        }
    public void setMethodID(Integer methodID)
        {
        this.methodID = methodID;
        }
    public String getMethodDescription()
        {
        return methodDescription;
        }
    public void setMethodDescription(String methodDescription)
        {
        this.methodDescription = methodDescription;
        }
    public Integer getSourceID()
        {
        return sourceID;
        }
    public void setSourceID(Integer sourceID)
        {
        this.sourceID = sourceID;
        }
    public String getOrganization()
        {
        return organization;
        }
    public void setOrganization(String organization)
        {
        this.organization = organization;
        }
    public String getSourceDescription()
        {
        return sourceDescription;
        }
    public void setSourceDescription(String sourceDescription)
        {
        this.sourceDescription = sourceDescription;
        }
    public String getCitation()
        {
        return citation;
        }
    public void setCitation(String citation)
        {
        this.citation = citation;
        }
    public Integer getQualityControlLevelID()
        {
        return qualityControlLevelID;
        }
    public void setQualityControlLevelID(Integer qualityControlLevelID)
        {
        this.qualityControlLevelID = qualityControlLevelID;
        }
    public String getQualityControlLevelCode()
        {
        return qualityControlLevelCode;
        }
    public void setQualityControlLevelCode(String qualityControlLevelCode)
        {
        this.qualityControlLevelCode = qualityControlLevelCode;
        }
    public Date getBeginDateTime()
        {
        return beginDateTime;
        }
    public void setBeginDateTime(Date beginDateTime)
        {
        this.beginDateTime = beginDateTime;
        }
    public Date getEndDateTime()
        {
        return endDateTime;
        }
    public void setEndDateTime(Date endDateTime)
        {
        this.endDateTime = endDateTime;
        }
    public Date getBeginDateTimeUTC()
        {
        return beginDateTimeUTC;
        }
    public void setBeginDateTimeUTC(Date beginDateTimeUTC)
        {
        this.beginDateTimeUTC = beginDateTimeUTC;
        }
    public Date getEndDateTimeUTC()
        {
        return endDateTimeUTC;
        }
    public void setEndDateTimeUTC(Date endDateTimeUTC)
        {
        this.endDateTimeUTC = endDateTimeUTC;
        }
    public Integer getValueCount()
        {
        return valueCount;
        }
    public void setValueCount(Integer valueCount)
        {
        this.valueCount = valueCount;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (seriesID != null ? seriesID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seriescatalog))
            {
            return false;
            }
        Seriescatalog other = (Seriescatalog) object;
        if ((this.seriesID == null && other.seriesID != null) || (this.seriesID != null && !this.seriesID.equals(other.seriesID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Seriescatalog[ seriesID=" + seriesID + " ]";
        }
    
    }
