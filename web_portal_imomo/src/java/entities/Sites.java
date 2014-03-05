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
import javax.persistence.ManyToMany;
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
@Table(name = "sites")
@XmlRootElement
@NamedQueries(
    {
    @NamedQuery(name = "Sites.findAll", query = "SELECT s FROM Sites s"),
    @NamedQuery(name = "Sites.findBySiteID", query = "SELECT s FROM Sites s WHERE s.siteID = :siteID"),
    @NamedQuery(name = "Sites.findBySiteCode", query = "SELECT s FROM Sites s WHERE s.siteCode = :siteCode"),
    @NamedQuery(name = "Sites.findBySiteName", query = "SELECT s FROM Sites s WHERE s.siteName = :siteName"),
    @NamedQuery(name = "Sites.findByLatitude", query = "SELECT s FROM Sites s WHERE s.latitude = :latitude"),
    @NamedQuery(name = "Sites.findByLongitude", query = "SELECT s FROM Sites s WHERE s.longitude = :longitude"),
    @NamedQuery(name = "Sites.findByElevationm", query = "SELECT s FROM Sites s WHERE s.elevationm = :elevationm"),
    @NamedQuery(name = "Sites.findByLocalX", query = "SELECT s FROM Sites s WHERE s.localX = :localX"),
    @NamedQuery(name = "Sites.findByLocalY", query = "SELECT s FROM Sites s WHERE s.localY = :localY"),
    @NamedQuery(name = "Sites.findByPosAccuracym", query = "SELECT s FROM Sites s WHERE s.posAccuracym = :posAccuracym"),
    @NamedQuery(name = "Sites.findByState", query = "SELECT s FROM Sites s WHERE s.state = :state"),
    @NamedQuery(name = "Sites.findByCounty", query = "SELECT s FROM Sites s WHERE s.county = :county")
    })
public class Sites implements Serializable
    {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SiteID")
    private Integer siteID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SiteCode")
    private String siteCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "SiteName")
    private String siteName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Latitude")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Longitude")
    private double longitude;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Elevation_m")
    private Double elevationm;
    @Column(name = "LocalX")
    private Double localX;
    @Column(name = "LocalY")
    private Double localY;
    @Column(name = "PosAccuracy_m")
    private Double posAccuracym;
    @Size(max = 255)
    @Column(name = "State")
    private String state;
    @Size(max = 255)
    @Column(name = "County")
    private String county;
    @Lob
    @Size(max = 65535)
    @Column(name = "Comments")
    private String comments;
    @ManyToMany(mappedBy = "sitesList")
    private List<ImomoSensor> imomoSensorList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sites")
    private GameSite gameSite;
    @JoinColumn(name = "VerticalDatum", referencedColumnName = "Term")
    @ManyToOne
    private Verticaldatumcv verticalDatum;
    @JoinColumn(name = "LocalProjectionID", referencedColumnName = "SpatialReferenceID")
    @ManyToOne
    private Spatialreferences localProjectionID;
    @JoinColumn(name = "LatLongDatumID", referencedColumnName = "SpatialReferenceID")
    @ManyToOne(optional = false)
    private Spatialreferences latLongDatumID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteID")
    private List<Station> stationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "defaultSiteID")
    private List<GameUser> gameUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteID")
    private List<Datavalues> datavaluesList;
    public Sites()
        {
        }
    public Sites(Integer siteID)
        {
        this.siteID = siteID;
        }
    public Sites(Integer siteID, String siteCode, String siteName, double latitude, double longitude)
        {
        this.siteID = siteID;
        this.siteCode = siteCode;
        this.siteName = siteName;
        this.latitude = latitude;
        this.longitude = longitude;
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
    public double getLatitude()
        {
        return latitude;
        }
    public void setLatitude(double latitude)
        {
        this.latitude = latitude;
        }
    public double getLongitude()
        {
        return longitude;
        }
    public void setLongitude(double longitude)
        {
        this.longitude = longitude;
        }
    public Double getElevationm()
        {
        return elevationm;
        }
    public void setElevationm(Double elevationm)
        {
        this.elevationm = elevationm;
        }
    public Double getLocalX()
        {
        return localX;
        }
    public void setLocalX(Double localX)
        {
        this.localX = localX;
        }
    public Double getLocalY()
        {
        return localY;
        }
    public void setLocalY(Double localY)
        {
        this.localY = localY;
        }
    public Double getPosAccuracym()
        {
        return posAccuracym;
        }
    public void setPosAccuracym(Double posAccuracym)
        {
        this.posAccuracym = posAccuracym;
        }
    public String getState()
        {
        return state;
        }
    public void setState(String state)
        {
        this.state = state;
        }
    public String getCounty()
        {
        return county;
        }
    public void setCounty(String county)
        {
        this.county = county;
        }
    public String getComments()
        {
        return comments;
        }
    public void setComments(String comments)
        {
        this.comments = comments;
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
    public GameSite getGameSite()
        {
        return gameSite;
        }
    public void setGameSite(GameSite gameSite)
        {
        this.gameSite = gameSite;
        }
    public Verticaldatumcv getVerticalDatum()
        {
        return verticalDatum;
        }
    public void setVerticalDatum(Verticaldatumcv verticalDatum)
        {
        this.verticalDatum = verticalDatum;
        }
    public Spatialreferences getLocalProjectionID()
        {
        return localProjectionID;
        }
    public void setLocalProjectionID(Spatialreferences localProjectionID)
        {
        this.localProjectionID = localProjectionID;
        }
    public Spatialreferences getLatLongDatumID()
        {
        return latLongDatumID;
        }
    public void setLatLongDatumID(Spatialreferences latLongDatumID)
        {
        this.latLongDatumID = latLongDatumID;
        }
    @XmlTransient
    public List<Station> getStationList()
        {
        return stationList;
        }
    public void setStationList(List<Station> stationList)
        {
        this.stationList = stationList;
        }
    @XmlTransient
    public List<GameUser> getGameUserList()
        {
        return gameUserList;
        }
    public void setGameUserList(List<GameUser> gameUserList)
        {
        this.gameUserList = gameUserList;
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
        hash += (siteID != null ? siteID.hashCode() : 0);
        return hash;
        }
    @Override
    public boolean equals(Object object)
        {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sites))
            {
            return false;
            }
        Sites other = (Sites) object;
        if ((this.siteID == null && other.siteID != null) || (this.siteID != null && !this.siteID.equals(other.siteID)))
            {
            return false;
            }
        return true;
        }
    @Override
    public String toString()
        {
        return "src.entities.Sites[ siteID=" + siteID + " ]";
        }
    
    }
