package suai.vladislav.moscowhack.ecohack.park;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BorderCoords")
public class BorderCoords {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference(value = "parkCoords")
    @ManyToOne
    @JoinColumn(name = "parkid")
    private Park park;

    private float latitude;

    private float longitude;
}
