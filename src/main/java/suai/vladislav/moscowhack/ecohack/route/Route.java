package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Route")
public class Route {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String additionalInfo;
    private Integer routeSecurityId;
    private Integer routeInformationId;
    private Integer routeStateId;
    private Integer routeDescriptionId;
    private Integer routeRequirementsId;
}
