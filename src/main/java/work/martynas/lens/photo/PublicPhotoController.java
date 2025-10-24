package work.martynas.lens.photo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.martynas.lens.photo.errors.PhotoNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
public class PublicPhotoController {

    public final PhotoRepository photoRepository;

    public PublicPhotoController(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @GetMapping("")
    List<Photo> findAll() {
        return photoRepository.findAll();
    }

    @GetMapping("/{id}")
    Photo findById(@PathVariable Integer id) {
        Optional<Photo> photo = photoRepository.findById(id);

        if(photo.isEmpty()){
            throw new PhotoNotFoundException();
        }
        return photo.get();

    }


}
