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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeLengthId")
    private RouteLength routeLength;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeTimeId")
    private RouteTime routeTime;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeEntranceOptionsid")
    private RouteEntranceOptions routeEntranceOptions;

    @JsonManagedReference
    @OneToMany(mappedBy = "routeInformation")
    private List<Route> route;

    @JsonManagedReference
    @OneToMany(mappedBy = "routeInformation")
    private List<RouteMoving> routeMoving;

    @JsonManagedReference
    @OneToMany(mappedBy = "routeInformation")
    private List<RouteVisitingConditionsXRouteInformation> routeVisitingConditionsXRouteInformation;
}
