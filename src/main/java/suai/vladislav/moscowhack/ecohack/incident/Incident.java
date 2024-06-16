package suai.vladislav.moscowhack.ecohack.incident;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Incident {
    public IncidentType getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentType incidentType) {
        this.incidentType = incidentType;
    }

    public ThreatDegree getThreatDegree() {
        return threatDegree;
    }

    public void setThreatDegree(ThreatDegree threatDegree) {
        this.threatDegree = threatDegree;
    }

    public IncidentSource getIncidentSource() {
        return incidentSource;
    }

    public void setIncidentSource(IncidentSource incidentSource) {
        this.incidentSource = incidentSource;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty
    @JsonBackReference(value = "incidentSource")
    @ManyToOne
    @JoinColumn(name = "sourceId")
    private IncidentSource incidentSource;

    @JsonProperty
    @JsonBackReference(value = "threatDegree")
    @ManyToOne
    @JoinColumn(name = "threatDegreeId")
    private ThreatDegree threatDegree;

    @JsonProperty
    @JsonBackReference(value = "incidentType")
    @ManyToOne
    @JoinColumn(name = "incidentTypeId")
    private IncidentType incidentType;

    @JsonManagedReference(value = "incidentPhoto")
    @OneToMany(mappedBy = "incident")
    private List<IncidentPhoto> incidentPhotos;

    @JsonProperty
    @JsonManagedReference(value = "employeeXIncidents")
    @OneToMany(mappedBy = "user")
    private List<EmployeeXIncident> employeeXIncidents;

    @JsonProperty
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

    public List<IncidentPhoto> getIncidentPhotos() {
        return incidentPhotos;
    }

    public void setIncidentPhotos(List<IncidentPhoto> incidentPhotos) {
        this.incidentPhotos = incidentPhotos;
    }

    public List<EmployeeXIncident> getEmployeeXIncidents() {
        return employeeXIncidents;
    }

    public void setEmployeeXIncidents(List<EmployeeXIncident> employeeXIncidents) {
        this.employeeXIncidents = employeeXIncidents;
    }

    public List<IncidentStatusXIncident> getIncidentStatusXIncidents() {
        return incidentStatusXIncidents;
    }

    public void setIncidentStatusXIncidents(List<IncidentStatusXIncident> incidentStatusXIncidents) {
        this.incidentStatusXIncidents = incidentStatusXIncidents;
    }
}
