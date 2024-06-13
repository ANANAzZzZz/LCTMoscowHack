package suai.vladislav.moscowhack.ecohack.route;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.park.Park;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RouteMoving")
public class RouteMoving {
    //
    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference(value = "routeMoving")
    @ManyToOne
    @JoinColumn(name = "routeVisitingConditionsId")
    private RouteInformation routeInformation;
}
