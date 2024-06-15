package suai.vladislav.moscowhack.ecohack.incident;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "IncidentStatus")
public class IncidentStatus {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String description;

    private LocalDateTime date;

    @JsonBackReference(value = "incidentStatus")
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "incident")
    private List<IncidentStatusXIncident> incidentStatusXIncidents;

    public IncidentStatus(String title, String description, Optional<User> byId) {
        this.title = title;
        this.description = description;
        this.user = byId.orElse(null);
        this.date = java.time.LocalDateTime.now();
    }
}
