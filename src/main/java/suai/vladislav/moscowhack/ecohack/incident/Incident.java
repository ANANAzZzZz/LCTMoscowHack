package suai.vladislav.moscowhack.ecohack.incident;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(name = "Incident")
@NoArgsConstructor
@AllArgsConstructor
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference(value = "incidentSource")
    @ManyToOne
    @JoinColumn(name = "sourceId")
    private IncidentSource incidentSource;

    @JsonBackReference(value = "threatDegree")
    @ManyToOne
    @JoinColumn(name = "threatDegreeId")
    private ThreatDegree threatDegree;

    @JsonBackReference(value = "incidentType")
    @ManyToOne
    @JoinColumn(name = "incidentTypeId")
    private IncidentType incidentType;

    @JsonManagedReference(value = "incidentPhoto")
    @OneToMany(mappedBy = "incident")
    private List<IncidentPhoto> incidentPhotos;

    @JsonManagedReference(value = "employeeXIncidents")
    @OneToMany(mappedBy = "user")
    private List<EmployeeXIncident> employeeXIncidents;

    @JsonManagedReference(value = "incidentStatusXIncident")
    @OneToMany(mappedBy = "incidentStatus")
    private List<IncidentStatusXIncident> incidentStatusXIncidents;

    private float latitude;

    private float longitude;

    private String comment;

    private LocalDateTime date;

    public Incident(Optional<IncidentSource> byId, Optional<ThreatDegree> byId1, Optional<IncidentType> byId2, float latitude, float longitude, String comment) {
        this.incidentSource = byId.orElse(null);
        this.threatDegree = byId1.orElse(null);
        this.incidentType = byId2.orElse(null);
        this.date = java.time.LocalDateTime.now();
        this.latitude = latitude;
        this.longitude = longitude;
        this.comment = comment;
    }
}
