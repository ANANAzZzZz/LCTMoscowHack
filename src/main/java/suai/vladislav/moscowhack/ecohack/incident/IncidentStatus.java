package suai.vladislav.moscowhack.ecohack.incident;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

}
