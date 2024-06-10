package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.ecohack.park.ParkPhoto;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RouteSecurity")
public class RouteSecurity {
    @Id
    @GeneratedValue
    private Integer id;

    private String recommendations;

    private String mchsRegistration;

    private String firstAid;

    private String orderOfActions;

}
