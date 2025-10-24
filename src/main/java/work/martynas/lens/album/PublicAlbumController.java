package work.martynas.lens.album;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.martynas.lens.album.errors.AlbumNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/albums")
public class PublicAlbumController {

    public final AlbumRepository albumRepository;

    public PublicAlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping("")
    List<Album> findAll() {
        return albumRepository.findAll();
    }

    @GetMapping("{id}")
    Album findById(@PathVariable Integer id) {
        Optional<Album> album = albumRepository.findById(id);

        if(album.isEmpty()){
            throw new AlbumNotFoundException();
        }
        return album.get();
    }


}
