package suai.vladislav.moscowhack.ecohack.route;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.park.Park;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DangerZone")
public class DangerZone {
    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "routeSecurityId")
    private RouteSecurity routeSecurity;
}
