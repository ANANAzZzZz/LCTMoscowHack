package suai.vladislav.moscowhack.ecohack.incident;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EmployeeXIncident")
public class EmployeeXIncident {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "incidentId")
    private Incident incident;
}
