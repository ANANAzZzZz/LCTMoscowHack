package suai.vladislav.moscowhack.ecohack.incident;

import com.fasterxml.jackson.annotation.*;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeXIncident {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonIgnore
    @JsonBackReference(value = "employeUser")
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private User user;

    @JsonBackReference(value = "employeeXIncidentss")
    @ManyToOne
    @JoinColumn(name = "incidentId")
    private Incident incident;

    public EmployeeXIncident(Optional<User> user, Optional<Incident> incident) {
        this.user = user.orElse(null);
        this.incident = incident.orElse(null);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("employeeId")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("incidentId")
    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
}
