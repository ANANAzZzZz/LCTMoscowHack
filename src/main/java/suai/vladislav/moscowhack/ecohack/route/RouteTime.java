package suai.vladislav.moscowhack.ecohack.route;


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
    @Id
    @GeneratedValue
    private Integer id;


    private Integer hours;
    private Integer days;
    private Integer nights;

}
