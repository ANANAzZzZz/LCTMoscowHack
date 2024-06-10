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
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String post;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<IncidentStatus> incidentStatuses;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<EmployeeXIncident> employeeXIncidents;
}
