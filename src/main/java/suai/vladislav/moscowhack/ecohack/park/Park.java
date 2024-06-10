package suai.vladislav.moscowhack.ecohack.park;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToMany(mappedBy = "park")
    private List<ParkPhoto> parkPhotos;

    @OneToMany(mappedBy = "park")
    private List<BorderCoords> borderCoords;

    @OneToMany(mappedBy = "park")
    private List<Route> routes;

    @OneToMany(mappedBy = "park")
    private List<ParkKeySight> parkKeySights;
}
