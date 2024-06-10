package suai.vladislav.moscowhack.ecohack.route;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "RouteTime")
public class RouteTime {
    //
    @Id
    @GeneratedValue
    private Integer id;

    @JsonManagedReference
    @OneToMany(mappedBy = "routeTime")
    private List<RouteInformation> routeInformation;


    private Integer hours;
    private Integer days;
    private Integer nights;

}
