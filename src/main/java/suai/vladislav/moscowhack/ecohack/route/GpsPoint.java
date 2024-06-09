package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GpsPoint")
public class GpsPoint {
    @Id
    @GeneratedValue
    private Integer id;

    private Point geotag;

    @ManyToOne
    @JoinColumn(name = "gpsId")
    private Gps gps;
}
