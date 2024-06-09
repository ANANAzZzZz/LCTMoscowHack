package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.park.Park;

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
    private Integer routeSecurityId;

    @ManyToOne
    @JoinColumn(name = "routeInformationId")
    private RouteInformation routeInformation;

    @ManyToOne
    @JoinColumn(name = "parkid")
    private Park park;

    private Integer routeStateId;
    private Integer routeDescriptionId;
    private Integer routeRequirementsId;
}
