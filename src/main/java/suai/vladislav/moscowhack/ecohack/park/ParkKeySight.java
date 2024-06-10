package suai.vladislav.moscowhack.ecohack.park;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ParkKeySight")
public class ParkKeySight {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parkid")
    private Park park;

    @JsonManagedReference
    @OneToMany(mappedBy = "parkKeySight")
    private List<ParkKeySightPhoto> parkKeySightPhotos;

    private String description;
    private String title;
    private Point geotag;
}
