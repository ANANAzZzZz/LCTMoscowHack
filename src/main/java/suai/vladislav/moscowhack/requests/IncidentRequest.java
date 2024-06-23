package suai.vladislav.moscowhack.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncidentRequest implements Serializable {
    private Integer incidentTypeId;
    private Integer threadDegreeId;
    private Integer sourceId;
    private String comment;
    private Float latitude;
    private Float longitude;
    private MultipartFile file;
}
