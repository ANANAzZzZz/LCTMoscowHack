package suai.vladislav.moscowhack.ecohack.route;

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
@Table(name = "RouteDescription")
public class RouteDescription {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "routeDescription")
    private List<Route> routes;

    @JsonManagedReference
    @OneToMany(mappedBy = "routeDescription")
    private List<KeySight> keySights;

    @JsonManagedReference
    @OneToMany(mappedBy = "routeDescription")
    private List<Parking> parkings;

    @JsonManagedReference
    @OneToMany(mappedBy = "routeDescription")
    private List<Gps> gps;
}
