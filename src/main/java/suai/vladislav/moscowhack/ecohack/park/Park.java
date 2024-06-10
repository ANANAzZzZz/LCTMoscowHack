package suai.vladislav.moscowhack.ecohack.park;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import suai.vladislav.moscowhack.ecohack.route.Route;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Park")
public class Park {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String description;

    private Integer avgTouristsPY;

    private String workingTime;

    private String siteUrl;

    @ManyToOne
    @JoinColumn(name = "contactsId")
    private ParkContacts parkContacts;

    @JsonManagedReference
    @OneToMany(mappedBy = "park")
    private List<ParkPhoto> parkPhotos;

    @JsonManagedReference
    @OneToMany(mappedBy = "park")
    private List<BorderCoords> borderCoords;
}
