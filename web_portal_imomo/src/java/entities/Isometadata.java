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
@Table(name = "isometadata")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Isometadata.findAll", query = "SELECT i FROM Isometadata i"),
    @NamedQuery(name = "Isometadata.findByMetadataID", query = "SELECT i FROM Isometadata i WHERE i.metadataID = :metadataID"),
    @NamedQuery(name = "Isometadata.findByTitle", query = "SELECT i FROM Isometadata i WHERE i.title = :title"),
    @NamedQuery(name = "Isometadata.findByProfileVersion", query = "SELECT i FROM Isometadata i WHERE i.profileVersion = :profileVersion")
    })
public class Isometadata implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MetadataID")
    private Integer metadataID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Abstract")
    private String abstract1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ProfileVersion")
    private String profileVersion;
    @Lob
    @Size(max = 65535)
    @Column(name = "MetadataLink")
    private String metadataLink;
    @JoinColumn(name = "TopicCategory", referencedColumnName = "Term")
    @ManyToOne(optional = false)
    private Topiccategorycv topicCategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metadataID")
    private List<Sources> sourcesList;
    public Isometadata()
        {
        }
    public Isometadata(Integer metadataID)
        {
        this.metadataID = metadataID;
        }
    public Isometadata(Integer metadataID, String title, String abstract1, String profileVersion)
        {
        this.metadataID = metadataID;
        this.title = title;
        this.abstract1 = abstract1;
        this.profileVersion = profileVersion;
        }
    public Integer getMetadataID()
        {
        return metadataID;
        }
    public void setMetadataID(Integer metadataID)
        {
        this.metadataID = metadataID;
        }
    public String getTitle()
        {
        return title;
        }
    public void setTitle(String title)
        {
        this.title = title;
        }
    public String getAbstract1()
        {
        return abstract1;
        }
    public void setAbstract1(String abstract1)
        {
        this.abstract1 = abstract1;
        }
    public String getProfileVersion()
        {
        return profileVersion;
        }
    public void setProfileVersion(String profileVersion)
        {
        this.profileVersion = profileVersion;
        }
    public String getMetadataLink()
        {
        return metadataLink;
        }
    public void setMetadataLink(String metadataLink)
        {
        this.metadataLink = metadataLink;
        }
    public Topiccategorycv getTopicCategory()
        {
        return topicCategory;
        }
    public void setTopicCategory(Topiccategorycv topicCategory)
        {
        this.topicCategory = topicCategory;
        }
    @XmlTransient
    public List<Sources> getSourcesList()
        {
        return sourcesList;
        }
    public void setSourcesList(List<Sources> sourcesList)
        {
        this.sourcesList = sourcesList;
        }
    @Override
    public int hashCode()
        {
        int hash = 0;
        hash += (metadataID != null ? metadataID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Isometadata))
            {
            return false;
            }
        Isometadata other = (Isometadata) object;
        if ((this.metadataID == null && other.metadataID != null) || (this.metadataID != null && !this.metadataID.equals(other.metadataID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Isometadata[ metadataID=" + metadataID + " ]";
        }
    
    }
