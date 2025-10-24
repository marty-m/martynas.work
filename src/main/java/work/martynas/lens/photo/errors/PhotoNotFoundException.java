package work.martynas.lens.photo.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PhotoNotFoundException extends RuntimeException {
    public PhotoNotFoundException() {
        super("Photo not found");
    }
}
