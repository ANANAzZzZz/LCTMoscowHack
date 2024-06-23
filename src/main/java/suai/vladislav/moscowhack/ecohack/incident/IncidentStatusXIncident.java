package suai.vladislav.moscowhack.ecohack.incident;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "IncidentStatusXIncident")
@NoArgsConstructor
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

    public IncidentStatusXIncident(Optional<IncidentStatus> incidentStatus, Optional<Incident> incident) {
        this.incidentStatus = incidentStatus.orElse(null);
        this.incident = incident.orElse(null);
    }

    public Incident getIncident() {
        return incident;
    }

    public IncidentStatus getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(IncidentStatus incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
}
