package suai.vladislav.moscowhack.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HikeGroupXUserRequest {
    private Integer hikeGroupId;
    private Integer userId;
}
