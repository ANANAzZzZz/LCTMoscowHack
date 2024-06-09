package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.ecohack.park.ParkContacts;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Route")
public class Route {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String additionalInfo;

    @ManyToOne
    @JoinColumn(name = "parkId")
    private Park park;

    @ManyToOne
    @JoinColumn(name = "routeStateId")
    private RouteState routeState;

    @ManyToOne
    @JoinColumn(name = "routeRequirementsId")
    private RouteRequirements routeRequirements;

    @ManyToOne
    @JoinColumn(name = "routeSecurityId")
    private RouteSecurity routeSecurity;

    @ManyToOne
    @JoinColumn(name = "routeDescriptionId")
    private RouteDescription routeDescription;
}
