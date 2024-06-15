package suai.vladislav.moscowhack.ecohack.incident;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EmployeeXIncident")
public class EmployeeXIncident {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference(value = "employeeXIncident")
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private User user;

    @JsonBackReference(value = "employeeXIncidents")
    @ManyToOne
    @JoinColumn(name = "incidentId")
    private Incident incident;

    public EmployeeXIncident(Optional<User> user, Optional<Incident> incident) {
        this.user = user.orElse(null);
        this.incident = incident.orElse(null);
    }
}
