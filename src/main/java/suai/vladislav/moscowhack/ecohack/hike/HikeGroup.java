package suai.vladislav.moscowhack.ecohack.hike;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HikeGroup")
public class HikeGroup {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer membersCount;

    private Integer routeId;

    private LocalDateTime startTime;

    private Boolean isPrivate;

    private String password;

    private Integer creatorId;
}
