package work.martynas.lens.photo;

import org.springframework.data.annotation.Id;

import java.util.List;

public record Album(
        @Id
        Integer id,
        String title,
        String description,
        String coverUri,
        List<Photo> photos
) {
}
