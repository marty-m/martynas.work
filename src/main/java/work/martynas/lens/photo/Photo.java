package work.martynas.lens.photo;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

public record Photo(
        @Id Integer id,
        String name,
        String description,
        @NotEmpty String url,
        Integer albumId
) {
}
