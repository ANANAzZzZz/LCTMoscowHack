package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RouteDescription")
public class RouteDescription {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    @OneToMany(mappedBy = "routeDescription")
    private List<Route> routes;

    @OneToMany(mappedBy = "routeDescription")
    private List<KeySight> keySights;

    @OneToMany(mappedBy = "routeDescription")
    private List<Parking> parkings;

    @OneToMany(mappedBy = "routeDescription")
    private List<Gps> gps;
}
