package suai.vladislav.moscowhack.ecohack.hike;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import suai.vladislav.moscowhack.ecohack.user.User;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HikeGroupXUser")
public class HikeGroupXUser {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "hikeGroupId")
    private HikeGroup hikeGroup;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
