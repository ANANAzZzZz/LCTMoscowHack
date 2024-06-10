package suai.vladislav.moscowhack.ecohack.park;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ParkContacts")
public class ParkContacts {
    @Id
    @GeneratedValue
    private Integer id;
    private String phone;
    private String email;

//    @OneToMany(mappedBy = "parkContacts")
//    private List<Park> park;
}
