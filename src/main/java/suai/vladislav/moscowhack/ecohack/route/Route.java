package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.ecohack.park.ParkPhoto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Route")
public class Route {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String additionalInfo;
    @Getter
    private Integer length;
    @Getter
    private Integer optimalDistanceBetweenGroups;

    private boolean onMap;
    private String color;
    @Column(columnDefinition = "TEXT")
    private String paths;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;

    @JsonProperty("areaId")
    private String areaId;

    @JsonProperty("routeId")
    private String routeId;


    @JsonProperty("routeId")
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @JsonProperty("areaId")
    public String getAreaId() {
        return areaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public boolean isOnMap() {
        return onMap;
    }

    public void setOnMap(boolean onMap) {
        this.onMap = onMap;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPaths() {
        return paths;
    }

    public void setPaths(String paths) {
        this.paths = paths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RouteSecurity getRouteSecurity() {
        return routeSecurity;
    }

    public RouteRequirements getRouteRequirements() {
        return routeRequirements;
    }

    public RouteState getRouteState() {
        return routeState;
    }

//    public Park getPark() {
//        return park;
//    }


    @JsonProperty("routeId")
    public String getRouteId() {
        return routeId;
    }

    @JsonProperty("areaId")
    public void setAreaId(String areaId) {
        this.routeId = areaId;
    }

    @JsonManagedReference(value = "routeInformation")
    @OneToMany(mappedBy = "route")
    private List<RouteInformation> routeInformation;

    @JsonBackReference(value = "park")
    @ManyToOne
    @JoinColumn(name = "parkId")
    private Park park;

    @JsonBackReference(value = "routeState")
    @ManyToOne
    @JoinColumn(name = "routeStateId")
    private RouteState routeState;

    @JsonBackReference(value = "routeRequirements")
    @ManyToOne
    @JoinColumn(name = "routeRequirementsId")
    private RouteRequirements routeRequirements;

    @JsonBackReference(value = "routeSecurity")
    @ManyToOne
    @JoinColumn(name = "routeSecurityId")
    private RouteSecurity routeSecurity;

    @JsonManagedReference(value = "RouteParking")
    @OneToMany(mappedBy = "route")
    private List<Parking> parking;


    public List<Parking> getParking() {
        return parking;
    }

    public void setParking(List<Parking> parking) {
        this.parking = parking;
    }

    public List<RouteInformation> getRouteInformation() {
        return routeInformation;
    }

    public void setRouteInformation(List<RouteInformation> routeInformation) {
        this.routeInformation = routeInformation;
    }
}
