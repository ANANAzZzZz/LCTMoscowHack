package suai.vladislav.moscowhack.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HikeRequestOpenGroup {
    private Integer userId;
    private Integer creatorId;
    private Integer hikeGroupId;
}
