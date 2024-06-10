package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ParkingPhoto")
public class ParkingPhoto {
    @Id
    @GeneratedValue
    private Integer id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "parkingId")
    private Parking parking;
}
