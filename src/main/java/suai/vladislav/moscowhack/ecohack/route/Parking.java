package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Parking")
public class Parking {
    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    private String title;

    private Point point;

    @ManyToOne
    @JoinColumn(name = "routeDescriptionId")
    private RouteDescription routeDescription;
}
