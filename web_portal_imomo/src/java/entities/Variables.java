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
import javax.persistence.OneToOne;
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
@Table(name = "variables")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Variables.findAll", query = "SELECT v FROM Variables v"),
    @NamedQuery(name = "Variables.findByVariableID", query = "SELECT v FROM Variables v WHERE v.variableID = :variableID"),
    @NamedQuery(name = "Variables.findByVariableCode", query = "SELECT v FROM Variables v WHERE v.variableCode = :variableCode"),
    @NamedQuery(name = "Variables.findByIsRegular", query = "SELECT v FROM Variables v WHERE v.isRegular = :isRegular"),
    @NamedQuery(name = "Variables.findByTimeSupport", query = "SELECT v FROM Variables v WHERE v.timeSupport = :timeSupport"),
    @NamedQuery(name = "Variables.findByNoDataValue", query = "SELECT v FROM Variables v WHERE v.noDataValue = :noDataValue")
//    @NamedQuery(name = "Variables.findByValueType", query = "SELECT v FROM Variables v WHERE v.valueType = :valueType")
    })
public class Variables implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VariableID")
    private Integer variableID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "VariableCode")
    private String variableCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsRegular")
    private boolean isRegular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TimeSupport")
    private double timeSupport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NoDataValue")
    private double noDataValue;
    @OneToMany(mappedBy = "variableID")
    private List<GameQuestion> gameQuestionList;
    @JoinColumn(name = "VariableName", referencedColumnName = "Term")
    @ManyToOne(optional = false)
    private Variablenamecv variableName;
    @JoinColumn(name = "ValueType", referencedColumnName = "Term")
    @ManyToOne(optional = false)
    private Valuetypecv valueType;
    @JoinColumn(name = "TimeUnitsID", referencedColumnName = "UnitsID")
    @ManyToOne(optional = false)
    private Units timeUnitsID;
    @JoinColumn(name = "VariableUnitsID", referencedColumnName = "UnitsID")
    @ManyToOne(optional = false)
    private Units variableUnitsID;
    @JoinColumn(name = "Speciation", referencedColumnName = "Term")
    @ManyToOne(optional = false)
    private Speciationcv speciation;
    @JoinColumn(name = "SampleMedium", referencedColumnName = "Term")
    @ManyToOne(optional = false)
    private Samplemediumcv sampleMedium;
    @JoinColumn(name = "GeneralCategory", referencedColumnName = "Term")
    @ManyToOne(optional = false)
    private Generalcategorycv generalCategory;
    @JoinColumn(name = "DataType", referencedColumnName = "Term")
    @ManyToOne(optional = false)
    private Datatypecv dataType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "variableID")
    private List<Datavalues> datavaluesList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "variables")
    private Categories categories;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "variableID")
    private List<ImomoSensor> imomoSensorList;
    public Variables()
        {
        }
    public Variables(Integer variableID)
        {
        this.variableID = variableID;
        }
    public Variables(Integer variableID, String variableCode, boolean isRegular, double timeSupport, double noDataValue)
        {
        this.variableID = variableID;
        this.variableCode = variableCode;
        this.isRegular = isRegular;
        this.timeSupport = timeSupport;
        this.noDataValue = noDataValue;
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
    public boolean getIsRegular()
        {
        return isRegular;
        }
    public void setIsRegular(boolean isRegular)
        {
        this.isRegular = isRegular;
        }
    public double getTimeSupport()
        {
        return timeSupport;
        }
    public void setTimeSupport(double timeSupport)
        {
        this.timeSupport = timeSupport;
        }
    public double getNoDataValue()
        {
        return noDataValue;
        }
    public void setNoDataValue(double noDataValue)
        {
        this.noDataValue = noDataValue;
        }
    @XmlTransient
    public List<GameQuestion> getGameQuestionList()
        {
        return gameQuestionList;
        }
    public void setGameQuestionList(List<GameQuestion> gameQuestionList)
        {
        this.gameQuestionList = gameQuestionList;
        }
    public Variablenamecv getVariableName()
        {
        return variableName;
        }
    public void setVariableName(Variablenamecv variableName)
        {
        this.variableName = variableName;
        }
    public Valuetypecv getValueType()
        {
        return valueType;
        }
    public void setValueType(Valuetypecv valueType)
        {
        this.valueType = valueType;
        }
    public Units getTimeUnitsID()
        {
        return timeUnitsID;
        }
    public void setTimeUnitsID(Units timeUnitsID)
        {
        this.timeUnitsID = timeUnitsID;
        }
    public Units getVariableUnitsID()
        {
        return variableUnitsID;
        }
    public void setVariableUnitsID(Units variableUnitsID)
        {
        this.variableUnitsID = variableUnitsID;
        }
    public Speciationcv getSpeciation()
        {
        return speciation;
        }
    public void setSpeciation(Speciationcv speciation)
        {
        this.speciation = speciation;
        }
    public Samplemediumcv getSampleMedium()
        {
        return sampleMedium;
        }
    public void setSampleMedium(Samplemediumcv sampleMedium)
        {
        this.sampleMedium = sampleMedium;
        }
    public Generalcategorycv getGeneralCategory()
        {
        return generalCategory;
        }
    public void setGeneralCategory(Generalcategorycv generalCategory)
        {
        this.generalCategory = generalCategory;
        }
    public Datatypecv getDataType()
        {
        return dataType;
        }
    public void setDataType(Datatypecv dataType)
        {
        this.dataType = dataType;
        }
    @XmlTransient
    public List<Datavalues> getDatavaluesList()
        {
        return datavaluesList;
        }
    public void setDatavaluesList(List<Datavalues> datavaluesList)
        {
        this.datavaluesList = datavaluesList;
        }
    public Categories getCategories()
        {
        return categories;
        }
    public void setCategories(Categories categories)
        {
        this.categories = categories;
        }
    @XmlTransient
    public List<ImomoSensor> getImomoSensorList()
        {
        return imomoSensorList;
        }
    public void setImomoSensorList(List<ImomoSensor> imomoSensorList)
        {
        this.imomoSensorList = imomoSensorList;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (variableID != null ? variableID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variables))
            {
            return false;
            }
        Variables other = (Variables) object;
        if ((this.variableID == null && other.variableID != null) || (this.variableID != null && !this.variableID.equals(other.variableID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Variables[ variableID=" + variableID + " ]";
        }
    
    }
