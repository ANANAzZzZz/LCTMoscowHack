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
@Table(name = "ParkKeySightPhoto")
public class ParkKeySightPhoto {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "keySightId")
    private ParkKeySight parkKeySight;

    private String url;
}
