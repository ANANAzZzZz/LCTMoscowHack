package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "RouteLength")
public class RouteLength {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer lengthKM;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "startPlaceId")
    private Place placeS;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "endPlaceId")
    private Place placeE;

    @JsonManagedReference
    @OneToMany(mappedBy = "routeLength")
    private List<RouteInformation> routeInformation;

}
