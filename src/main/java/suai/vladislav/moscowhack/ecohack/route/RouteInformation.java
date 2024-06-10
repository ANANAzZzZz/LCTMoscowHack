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
@Table(name = "RouteInformation")
public class RouteInformation {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer numberMonthStartWork;
    private Integer numberMonthEndWork;
    private String routeType;
    private String routeComplexity;
//
    @ManyToOne
    @JoinColumn(name = "routeLengthId")
    private RouteLength routeLength;

    @ManyToOne
    @JoinColumn(name = "routeTimeId")
    private RouteTime routeTime;

    @ManyToOne
    @JoinColumn(name = "routeEntranceOptionsid")
    private RouteEntranceOptions routeEntranceOptions;



}
