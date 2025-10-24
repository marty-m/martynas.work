package work.martynas.lens.album;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import work.martynas.lens.album.errors.AlbumNotFoundException;

@RestController
@RequestMapping("/api/admin/albums")
public class AdminAlbumController {

    private final AlbumRepository albumRepository;

    public AdminAlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Album create(@Valid @RequestBody Album album){
        Album newAlbum = new Album(
                null,
                album.name(),
                album.description(),
                album.coverUrl()
        );
        return albumRepository.save(newAlbum);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    Album update(@PathVariable Integer id, @Valid @RequestBody Album album){
        return albumRepository.findById(id)
                .map(existingAlbum -> {
                    Album updatedAlbum = new Album(
                            existingAlbum.id(),
                            album.name(),
                            album.description(),
                            album.coverUrl()
                    );
                    return albumRepository.save(updatedAlbum);
                })
                .orElseThrow(AlbumNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        if(!albumRepository.existsById(id)){
            throw new AlbumNotFoundException();
        }
        albumRepository.deleteById(id);
    }

}
