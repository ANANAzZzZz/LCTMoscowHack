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
@Table(name = "Gps")
public class Gps {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer ord;

    @ManyToOne
    @JoinColumn(name = "routeDescriptionId")
    private RouteDescription routeDescription;

    @OneToMany(mappedBy = "gps")
    private List<GpsPoint> gpsPoints;
}
