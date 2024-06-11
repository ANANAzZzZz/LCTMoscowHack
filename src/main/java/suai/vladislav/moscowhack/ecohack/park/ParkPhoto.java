package suai.vladislav.moscowhack.ecohack.park;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
@Table(name = "ParkPhoto")
public class ParkPhoto {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "parkid")
    private Park park;

    private String url;
}
