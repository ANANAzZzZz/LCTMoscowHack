package suai.vladislav.moscowhack.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseAnthropogenicLoadForMonthResponse {
    private Integer DT;
    private Integer DG;
    private Integer TS;
    private Integer TD;
    private Integer GS;
    private Integer T;
    private Integer currentPeriodBCC;
    private Integer periodChangeBCC;
}
