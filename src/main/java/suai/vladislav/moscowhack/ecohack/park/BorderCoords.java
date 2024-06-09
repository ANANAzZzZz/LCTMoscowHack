package suai.vladislav.moscowhack.ecohack.park;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BorderCoords")
public class BorderCoords {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "parkid")
    private Park park;

    private Point geoTag;
}
