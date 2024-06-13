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
@Table(name = "RouteVisitingConditions")
public class RouteVisitingConditions {
    
    @Id
    @GeneratedValue
    private Integer id;

    @JsonManagedReference(value = "RouteVisitingConditions")
    @OneToMany(mappedBy = "routeVisitingConditions")
    private List<RouteVisitingConditionsXRouteInformation> routeVisitingConditionsXRouteInformation;

    private String content;

}
