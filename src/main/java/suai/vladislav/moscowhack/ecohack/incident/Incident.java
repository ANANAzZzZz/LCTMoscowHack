package suai.vladislav.moscowhack.ecohack.incident;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(name = "Incident")
@NoArgsConstructor
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference(value = "incidentSource")
    @ManyToOne
    @JoinColumn(name = "sourceId")
    private IncidentSource incidentSource;

    @ManyToOne
    @JoinColumn(name = "threatDegreeId")
    private ThreatDegree threatDegree;

    @ManyToOne
    @JoinColumn(name = "incidentTypeId")
    private IncidentType incidentType;

    @JsonManagedReference(value = "incidentPhotos")
    @OneToMany(mappedBy = "incident")
    private List<IncidentPhoto> incidentPhotos;

//    @JsonManagedReference(value = "employeeXIncidentss")
//    @OneToMany(mappedBy = "incident")
//    private List<EmployeeXIncident> employeeXIncidents;

    @JsonManagedReference(value = "incidentCrossStatus")
    @ManyToMany
    @JoinTable(
            name = "IncidentCrossStatus",
            joinColumns = @JoinColumn(name = "Incident_id"),
            inverseJoinColumns = @JoinColumn(name = "IncidentStatus_id")
    )
    private List<IncidentStatus> incidentStatus;

    @JsonIgnore
    @JsonManagedReference(value = "employeeCrossUser")
    @ManyToMany
    @JoinTable(
            name = "IncidentCrossUser",
            joinColumns = @JoinColumn(name = "Incident_id"),
            inverseJoinColumns = @JoinColumn(name = "User_id")
    )
    private List<User> user;


//    @JsonManagedReference(value = "incidentStatusXIncident")
//    @OneToMany(mappedBy = "incidentStatus")
//    private List<IncidentStatusXIncident> incidentStatusXIncidents;

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

//    public List<EmployeeXIncident> getEmployeeXIncidents() {
//        return employeeXIncidents;
//    }
//
//    public void setEmployeeXIncidents(List<EmployeeXIncident> employeeXIncidents) {
//        this.employeeXIncidents = employeeXIncidents;
//    }

//    public List<IncidentStatusXIncident> getIncidentStatusXIncidents() {
//        return incidentStatusXIncidents;
//    }
//
//    public void setIncidentStatusXIncidents(List<IncidentStatusXIncident> incidentStatusXIncidents) {
//        this.incidentStatusXIncidents = incidentStatusXIncidents;
//    }

    public List<User> getEmployeesCross() {
        return user;
    }

    public void setEmployeesCross(List<User> employeesCross) {
        this.user = employeesCross;
    }
}
