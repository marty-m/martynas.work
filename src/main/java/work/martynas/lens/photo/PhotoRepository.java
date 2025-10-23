package work.martynas.lens.photo;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PhotoRepository extends ListCrudRepository<Photo, Integer> {
}
