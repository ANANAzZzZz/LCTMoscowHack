package suai.vladislav.moscowhack.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HikeGroupResponse {
    private Integer membersCount;
    private LocalDateTime startTime;
    private boolean isPrivate;
    private String password;
    private Integer creatorId;
    private Integer routeId;
}
