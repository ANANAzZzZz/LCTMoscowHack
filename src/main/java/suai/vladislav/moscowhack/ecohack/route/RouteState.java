package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.park.Park;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RouteState")
public class RouteState {
    @Id
    @GeneratedValue
    private Integer id;

    private String arrangement;

    private String routeQuality;

    private String waterSources;

    private String mobileConnection;

    @OneToMany(mappedBy = "routeState")
    private List<Route> routes;
}
