package suai.vladislav.moscowhack.ecohack.park;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;


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

    @JsonBackReference(value = "parkPhotos")
    @ManyToOne
    @JoinColumn(name = "parkid")
    private Park park;

    @Setter
    private byte[] data;

}
