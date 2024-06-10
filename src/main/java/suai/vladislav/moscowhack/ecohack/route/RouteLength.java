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
@Table(name = "RouteLength")
public class RouteLength {
    //
    @Id
    @GeneratedValue
    private Integer id;
    private Integer lengthKM;


    @ManyToOne
    @JoinColumn(name = "startPlaceId")
    private Place placeS;

    @ManyToOne
    @JoinColumn(name = "endPlaceId")
    private Place placeE;

}
