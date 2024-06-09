package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Place")
public class Place {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "placeS")
    private List<RouteLength> routeLengthS;

    @OneToMany(mappedBy = "placeE")
    private List<RouteLength> routeLengthE;

    private String name;
}
