package work.martynas.lens.photo;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public record Photo(
        @Id Integer id,
        String name,
        String description,
        @NotEmpty String url,
        Integer albumId
) {
}
