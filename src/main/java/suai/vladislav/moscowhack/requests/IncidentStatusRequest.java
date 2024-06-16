package suai.vladislav.moscowhack.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IncidentStatusRequest {
    private String title;
    private String description;
    private Integer employeeId;
    private Integer incidentId;
}
