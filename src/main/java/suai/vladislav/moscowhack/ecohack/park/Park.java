package suai.vladislav.moscowhack.ecohack.park;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.route.Route;
import suai.vladislav.moscowhack.ecohack.route.RouteMoving;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Park")
public class Park {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer routeId;

    @ManyToOne
    @JoinColumn(name = "contactsId")
    private ParkContacts parkContacts;

    private String title;
    private String description;
    private Integer avgTouristsPY;
    private String workingTime;
    private String siteUrl;

    @OneToMany(mappedBy = "park")
    private List<ParkPhoto> parkPhotos;

    @OneToMany(mappedBy = "park")
    private List<Route> route;

    @OneToMany(mappedBy = "park")
    private List<BorderCoords> borderCoords;

    @OneToMany(mappedBy = "park")
    private List<ParkKeySight> parkKeySights;

}
