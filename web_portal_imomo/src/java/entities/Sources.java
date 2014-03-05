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
import javax.persistence.Lob;
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
@Table(name = "sources")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Sources.findAll", query = "SELECT s FROM Sources s"),
    @NamedQuery(name = "Sources.findBySourceID", query = "SELECT s FROM Sources s WHERE s.sourceID = :sourceID"),
    @NamedQuery(name = "Sources.findByOrganization", query = "SELECT s FROM Sources s WHERE s.organization = :organization"),
    @NamedQuery(name = "Sources.findByContactName", query = "SELECT s FROM Sources s WHERE s.contactName = :contactName"),
    @NamedQuery(name = "Sources.findByPhone", query = "SELECT s FROM Sources s WHERE s.phone = :phone"),
    @NamedQuery(name = "Sources.findByEmail", query = "SELECT s FROM Sources s WHERE s.email = :email"),
    @NamedQuery(name = "Sources.findByAddress", query = "SELECT s FROM Sources s WHERE s.address = :address"),
    @NamedQuery(name = "Sources.findByCity", query = "SELECT s FROM Sources s WHERE s.city = :city"),
    @NamedQuery(name = "Sources.findByState", query = "SELECT s FROM Sources s WHERE s.state = :state"),
    @NamedQuery(name = "Sources.findByZipCode", query = "SELECT s FROM Sources s WHERE s.zipCode = :zipCode")
    })
public class Sources implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SourceID")
    private Integer sourceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Organization")
    private String organization;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "SourceDescription")
    private String sourceDescription;
    @Lob
    @Size(max = 65535)
    @Column(name = "SourceLink")
    private String sourceLink;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ContactName")
    private String contactName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ZipCode")
    private String zipCode;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Citation")
    private String citation;
    @JoinColumn(name = "MetadataID", referencedColumnName = "MetadataID")
    @ManyToOne(optional = false)
    private Isometadata metadataID;
    @OneToMany(mappedBy = "sourceID")
    private List<Datavalues> datavaluesList;
    public Sources()
        {
        }
    public Sources(Integer sourceID)
        {
        this.sourceID = sourceID;
        }
    public Sources(Integer sourceID, String organization, String sourceDescription, String contactName, String phone, String email, String address, String city, String state, String zipCode, String citation)
        {
        this.sourceID = sourceID;
        this.organization = organization;
        this.sourceDescription = sourceDescription;
        this.contactName = contactName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.citation = citation;
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
    public String getSourceLink()
        {
        return sourceLink;
        }
    public void setSourceLink(String sourceLink)
        {
        this.sourceLink = sourceLink;
        }
    public String getContactName()
        {
        return contactName;
        }
    public void setContactName(String contactName)
        {
        this.contactName = contactName;
        }
    public String getPhone()
        {
        return phone;
        }
    public void setPhone(String phone)
        {
        this.phone = phone;
        }
    public String getEmail()
        {
        return email;
        }
    public void setEmail(String email)
        {
        this.email = email;
        }
    public String getAddress()
        {
        return address;
        }
    public void setAddress(String address)
        {
        this.address = address;
        }
    public String getCity()
        {
        return city;
        }
    public void setCity(String city)
        {
        this.city = city;
        }
    public String getState()
        {
        return state;
        }
    public void setState(String state)
        {
        this.state = state;
        }
    public String getZipCode()
        {
        return zipCode;
        }
    public void setZipCode(String zipCode)
        {
        this.zipCode = zipCode;
        }
    public String getCitation()
        {
        return citation;
        }
    public void setCitation(String citation)
        {
        this.citation = citation;
        }
    public Isometadata getMetadataID()
        {
        return metadataID;
        }
    public void setMetadataID(Isometadata metadataID)
        {
        this.metadataID = metadataID;
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
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (sourceID != null ? sourceID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sources))
            {
            return false;
            }
        Sources other = (Sources) object;
        if ((this.sourceID == null && other.sourceID != null) || (this.sourceID != null && !this.sourceID.equals(other.sourceID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Sources[ sourceID=" + sourceID + " ]";
        }
    
    }
