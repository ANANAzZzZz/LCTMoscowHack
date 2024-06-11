package suai.vladislav.moscowhack.ecohack.hike;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HikeInvite")
public class HikeInvite {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer creatorId;

    private Integer userId;

    private Integer hikeGroupId;
}
