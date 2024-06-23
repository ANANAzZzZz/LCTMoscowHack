package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RouteInformation")
public class RouteInformation {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer numberMonthStartWork;
    private Integer numberMonthEndWork;
    private String routeType;
    private String routeComplexity;
//
    @JsonBackReference(value = "routeLength")
    @ManyToOne
    @JoinColumn(name = "routeLengthId")
    private RouteLength routeLength;

    @JsonBackReference(value = "routeTime")
    @ManyToOne
    @JoinColumn(name = "routeTimeId")
    private RouteTime routeTime;

    @JsonBackReference(value = "routeEntranceOptions")
    @ManyToOne
    @JoinColumn(name = "routeEntranceOptionsid")
    private RouteEntranceOptions routeEntranceOptions;

    @JsonBackReference(value = "routeInformation")
    @ManyToOne
    @JoinColumn(name = "routeId")
    private Route route;

    @JsonBackReference(value = "routeMoving")
    @OneToMany(mappedBy = "routeInformation")
    private List<RouteMoving>routeMoving;

    @JsonManagedReference(value = "routeInformationCross")
    @OneToMany(mappedBy = "routeInformation")
    private List<RouteVisitingConditionsXRouteInformation> routeVisitingConditionsXRouteInformation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberMonthStartWork() {
        return numberMonthStartWork;
    }

    public void setNumberMonthStartWork(Integer numberMonthStartWork) {
        this.numberMonthStartWork = numberMonthStartWork;
    }

    public Integer getNumberMonthEndWork() {
        return numberMonthEndWork;
    }

    public void setNumberMonthEndWork(Integer numberMonthEndWork) {
        this.numberMonthEndWork = numberMonthEndWork;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public String getRouteComplexity() {
        return routeComplexity;
    }

    public void setRouteComplexity(String routeComplexity) {
        this.routeComplexity = routeComplexity;
    }

    public RouteLength getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(RouteLength routeLength) {
        this.routeLength = routeLength;
    }

    public RouteTime getRouteTime() {
        return routeTime;
    }

    public void setRouteTime(RouteTime routeTime) {
        this.routeTime = routeTime;
    }

    public RouteEntranceOptions getRouteEntranceOptions() {
        return routeEntranceOptions;
    }

    public void setRouteEntranceOptions(RouteEntranceOptions routeEntranceOptions) {
        this.routeEntranceOptions = routeEntranceOptions;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<RouteMoving> getRouteMoving() {
        return routeMoving;
    }

    public void setRouteMoving(List<RouteMoving> routeMoving) {
        this.routeMoving = routeMoving;
    }
}
