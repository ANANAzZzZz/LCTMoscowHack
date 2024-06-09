package suai.vladislav.moscowhack.ecohack.incident;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @OneToMany(mappedBy = "incident")
    private List<IncidentPhoto> incidentPhotos;

    private Integer incidentTypeId;
    private Point coordinates;
    private Integer threatDegreeId;
    private Integer sourceId;
    private String comment;

}
