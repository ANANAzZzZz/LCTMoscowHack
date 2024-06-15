package suai.vladislav.moscowhack.ecohack.incident;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.park.Park;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "IncidentPhoto")
public class IncidentPhoto {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference(value = "incidentPhoto")
    @ManyToOne
    @JoinColumn(name = "incidentid")
    private Incident incident;

    private byte[] data;
}
