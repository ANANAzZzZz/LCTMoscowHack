package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.hike.HikeGroup;
import suai.vladislav.moscowhack.ecohack.hike.HikeInvite;
import suai.vladislav.moscowhack.ecohack.park.Park;

import javax.persistence.*;
import java.util.List;

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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeInformationId")
    private RouteInformation routeInformation;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parkId")
    private Park park;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeStateId")
    private RouteState routeState;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeRequirementsId")
    private RouteRequirements routeRequirements;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeSecurityId")
    private RouteSecurity routeSecurity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeDescriptionId")
    private RouteDescription routeDescription;

    @JsonManagedReference
    @OneToMany(mappedBy = "route")
    private List<HikeGroup> hikeGroups;
}
