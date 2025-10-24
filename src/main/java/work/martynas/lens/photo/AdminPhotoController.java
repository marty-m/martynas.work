package work.martynas.lens.photo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import work.martynas.lens.photo.errors.PhotoNotFoundException;

@RestController
@RequestMapping("/api/admin/photos")
public class AdminPhotoController {

    private final PhotoRepository photoRepository;

    public AdminPhotoController(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Photo create(@Valid @RequestBody Photo photo){
        Photo newPhoto = new Photo(
                null,
                photo.name(),
                photo.description(),
                photo.url(),
                photo.albumId()
        );
        return photoRepository.save(newPhoto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    Photo update(@PathVariable Integer id, @Valid @RequestBody Photo photo){
        return photoRepository.findById(id)
                .map(existingPhoto -> {
                    Photo updatedPhoto = new Photo(
                            existingPhoto.id(),
                            photo.name(),
                            photo.description(),
                            photo.url(),
                            photo.albumId()
                    );
                    return photoRepository.save(updatedPhoto);
                })
                .orElseThrow(PhotoNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        photoRepository.deleteById(id);
    }


}
