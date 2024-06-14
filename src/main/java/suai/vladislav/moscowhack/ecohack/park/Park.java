package suai.vladislav.moscowhack.ecohack.park;

import com.fasterxml.jackson.annotation.*;
import suai.vladislav.moscowhack.ecohack.route.Route;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Park")
public class Park {

    // Используем @JsonAlias для десериализации JSON, который содержит поле "id" в areaId.
    @JsonProperty("id")
    private String areaId;  // Переименование id из AreasListItem для избежания конфликта

    @Id
    @GeneratedValue
    private Integer id;  // Это поле будет использоваться как идентификатор базы данных.

    private String title;
    private String description;
    private Integer avgTouristsPY;
    private String workingTime;
    private String siteUrl;

    // Поля из AreasListItem
    private String borderColor;
    private String color;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String points;

    @ManyToOne
    @JoinColumn(name = "contactsId")
    private ParkContacts parkContacts;

    @JsonManagedReference(value = "parkPhotos")
    @OneToMany(mappedBy = "park")
    private List<ParkPhoto> parkPhotos;

    @JsonManagedReference(value = "parkCoords")
    @OneToMany(mappedBy = "park")
    private List<BorderCoords> borderCoords;

    @JsonProperty("id")
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvgTouristsPY(Integer avgTouristsPY) {
        this.avgTouristsPY = avgTouristsPY;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public void setParkContacts(ParkContacts parkContacts) {
        this.parkContacts = parkContacts;
    }

    public void setParkPhotos(List<ParkPhoto> parkPhotos) {
        this.parkPhotos = parkPhotos;
    }

    public void setBorderCoords(List<BorderCoords> borderCoords) {
        this.borderCoords = borderCoords;
    }

    @JsonProperty("id")
    public String getAreaId() {
        return areaId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAvgTouristsPY() {
        return avgTouristsPY;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getPoints() {
        return points;
    }

    public ParkContacts getParkContacts() {
        return parkContacts;
    }

    public List<ParkPhoto> getParkPhotos() {
        return parkPhotos;
    }

    public List<BorderCoords> getBorderCoords() {
        return borderCoords;
    }
}