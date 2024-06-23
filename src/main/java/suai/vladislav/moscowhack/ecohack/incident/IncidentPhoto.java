package suai.vladislav.moscowhack.ecohack.incident;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import suai.vladislav.moscowhack.ecohack.park.Park;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name = "IncidentPhoto")
public class IncidentPhoto {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference(value = "incidentPhotos")
    @ManyToOne
    @JoinColumn(name = "incidentid")
    private Incident incident;

    @Setter
    @Lob
    private byte[] data;
}
