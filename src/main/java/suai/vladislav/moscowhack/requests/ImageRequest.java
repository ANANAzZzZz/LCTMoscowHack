package suai.vladislav.moscowhack.requests;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class ImageRequest {
    private MultipartFile file;
}
