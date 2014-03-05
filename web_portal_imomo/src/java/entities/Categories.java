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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphaël
 */
@Entity
@Table(name = "categories")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c"),
    @NamedQuery(name = "Categories.findByVariableID", query = "SELECT c FROM Categories c WHERE c.variableID = :variableID"),
    @NamedQuery(name = "Categories.findByDataValue", query = "SELECT c FROM Categories c WHERE c.dataValue = :dataValue")
    })
public class Categories implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "VariableID")
    private Integer variableID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DataValue")
    private double dataValue;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "CategoryDescription")
    private String categoryDescription;
    @JoinColumn(name = "VariableID", referencedColumnName = "VariableID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Variables variables;
    public Categories()
        {
        }
    public Categories(Integer variableID)
        {
        this.variableID = variableID;
        }
    public Categories(Integer variableID, double dataValue, String categoryDescription)
        {
        this.variableID = variableID;
        this.dataValue = dataValue;
        this.categoryDescription = categoryDescription;
        }
    public Integer getVariableID()
        {
        return variableID;
        }
    public void setVariableID(Integer variableID)
        {
        this.variableID = variableID;
        }
    public double getDataValue()
        {
        return dataValue;
        }
    public void setDataValue(double dataValue)
        {
        this.dataValue = dataValue;
        }
    public String getCategoryDescription()
        {
        return categoryDescription;
        }
    public void setCategoryDescription(String categoryDescription)
        {
        this.categoryDescription = categoryDescription;
        }
    public Variables getVariables()
        {
        return variables;
        }
    public void setVariables(Variables variables)
        {
        this.variables = variables;
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
        if (!(object instanceof Categories))
            {
            return false;
            }
        Categories other = (Categories) object;
        if ((this.variableID == null && other.variableID != null) || (this.variableID != null && !this.variableID.equals(other.variableID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Categories[ variableID=" + variableID + " ]";
        }
    
    }
