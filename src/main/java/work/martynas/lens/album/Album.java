package work.martynas.lens.album;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;


public record Album(
        @Id Integer id,
        String name,
        String description,
        @NotEmpty String coverUrl
) {
}
