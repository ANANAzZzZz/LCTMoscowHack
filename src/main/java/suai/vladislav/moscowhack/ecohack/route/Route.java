package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import suai.vladislav.moscowhack.ecohack.park.Park;

import javax.persistence.*;

@Entity
@Table(name = "Route")
public class Route {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String additionalInfo;

    private boolean onMap;
    private String color;
    @Column(columnDefinition = "TEXT")
    private String paths;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;


    private String areaId;

    @JsonProperty("id")
    private String routeId;


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

    public RouteDescription getRouteDescription() {
        return routeDescription;
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

    public RouteInformation getRouteInformation() {
        return routeInformation;
    }

    @JsonProperty("id")
    public String getRouteId() {
        return routeId;
    }

    @JsonProperty("id")
    public void setAreaId(String areaId) {
        this.routeId = areaId;
    }


    @JsonBackReference(value = "routeInformation")
    @ManyToOne
    @JoinColumn(name = "routeInformationId")
    private RouteInformation routeInformation;

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

    @JsonBackReference(value = "routeDescription")
    @ManyToOne
    @JoinColumn(name = "routeDescriptionId")
    private RouteDescription routeDescription;
}
