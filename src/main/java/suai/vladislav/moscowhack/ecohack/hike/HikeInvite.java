package suai.vladislav.moscowhack.ecohack.hike;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import suai.vladislav.moscowhack.ecohack.park.ParkContacts;
import suai.vladislav.moscowhack.ecohack.user.User;

import javax.persistence.*;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HikeInvite")
public class HikeInvite {
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

    public HikeInvite(Optional<User> byId, Optional<User> byId1, Optional<HikeGroup> byId2) {
        this.user = byId.orElseThrow();
        this.userCreator = byId1.orElseThrow();
        this.hikeGroup = byId2.orElseThrow();
    }
}
