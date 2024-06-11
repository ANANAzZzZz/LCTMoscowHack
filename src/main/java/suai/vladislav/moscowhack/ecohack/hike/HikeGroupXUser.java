package suai.vladislav.moscowhack.ecohack.hike;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HikeGroupXUser")
public class HikeGroupXUser {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer hikeGroupId;

    private Integer userId;
}
