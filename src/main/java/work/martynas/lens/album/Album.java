package work.martynas.lens.album;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;


public record Album(
        @Id Integer id,
        String title,
        String description,
        @NotEmpty String coverUrl
) {
}
