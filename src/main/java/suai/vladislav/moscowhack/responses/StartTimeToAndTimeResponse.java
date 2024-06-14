package suai.vladislav.moscowhack.responses;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartTimeToAndTimeResponse {
    private Integer time8to9;
    private Integer time9to10;
    private Integer time10to11;
    private Integer time11to12;
    private Integer time12to13;
    private Integer time13to14;
    private Integer time14to15;
    private Integer time15to16;
    private Integer time16to17;
    private Integer time17to18;
    private Integer time18to19;
}
