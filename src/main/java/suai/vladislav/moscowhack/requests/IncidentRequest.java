package suai.vladislav.moscowhack.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class IncidentRequest {
    private Integer incidentTypeId;
    private Integer threadDegreeId;
    private Integer sourceId;
    private String comment;
    private float latitude;
    private float longitude;
}
