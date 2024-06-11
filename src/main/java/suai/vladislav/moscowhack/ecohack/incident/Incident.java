package suai.vladislav.moscowhack.ecohack.incident;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.park.ParkContacts;
import suai.vladislav.moscowhack.ecohack.park.ParkPhoto;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Incident")
public class Incident {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sourceId")
    private IncidentSource incidentSource;

    @ManyToOne
    @JoinColumn(name = "threatDegreeId")
    private ThreatDegree threatDegree;

    @ManyToOne
    @JoinColumn(name = "incidentTypeId")
    private IncidentType incidentType;

    @JsonManagedReference
    @OneToMany(mappedBy = "incident")
    private List<IncidentPhoto> incidentPhotos;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<EmployeeXIncident> employeeXIncidents;

    @JsonManagedReference
    @OneToMany(mappedBy = "incidentStatus")
    private List<IncidentStatusXIncident> incidentStatusXIncidents;

    private float latitude;

    private float longitude;

    private String comment;
}
