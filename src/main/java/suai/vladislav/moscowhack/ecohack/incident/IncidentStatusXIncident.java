package suai.vladislav.moscowhack.ecohack.incident;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "IncidentStatusXIncident")
public class IncidentStatusXIncident {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "incidentStatusId")
    private IncidentStatus incidentStatus;

    @ManyToOne
    @JoinColumn(name = "incidentId")
    private Incident incident;
}
