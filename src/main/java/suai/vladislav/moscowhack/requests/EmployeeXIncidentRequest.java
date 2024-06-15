package suai.vladislav.moscowhack.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeXIncidentRequest {
    private int employeeId;
    private int incidentId;
}
