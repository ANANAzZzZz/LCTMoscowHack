package suai.vladislav.moscowhack.ecohack.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KeySightPhoto")
public class KeySightPhoto {
    @Id
    @GeneratedValue
    private Integer id;

    private String url;

    @ManyToOne
    @JoinColumn(name = "keySightId")
    private KeySight keySight;
}
