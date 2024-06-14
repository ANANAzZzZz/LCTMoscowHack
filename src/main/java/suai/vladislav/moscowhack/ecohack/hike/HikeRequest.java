package suai.vladislav.moscowhack.ecohack.hike;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.route.Route;
import suai.vladislav.moscowhack.ecohack.user.User;

import javax.persistence.*;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HikeRequest")
public class HikeRequest {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "creatorId")
    private User userCreator;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "hikeGroupId")
    private HikeGroup hikeGroup;

    public HikeRequest(Optional<User> byId, Optional<User> byId1, Optional<HikeGroup> byId2) {
        this.user = byId.orElseThrow();
        this.userCreator = byId1.orElseThrow();
        this.hikeGroup = byId2.orElseThrow();
    }
}
