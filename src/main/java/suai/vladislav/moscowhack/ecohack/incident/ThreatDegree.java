package suai.vladislav.moscowhack.ecohack.incident;

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
@Table(name = "ThreatDegree")
public class ThreatDegree {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @JsonManagedReference(value = "threatDegree")
    @OneToMany(mappedBy = "threatDegree")
    private List<Incident> incidents;
}
