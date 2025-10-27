package work.martynas.lens.bucket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/r2")
public class R2Controller {

    private final CloudFlareR2Client r2Client;
    private final String bucketName;

    public R2Controller(CloudFlareR2Client r2Client, @Value("${cloudflare.r2.bucket}") String bucketName) {
        this.bucketName = bucketName;
        this.r2Client = r2Client;
    }

    @GetMapping("")
    public List<PublicObject> listObjects() {
        return r2Client.listPublicObjects(bucketName);
    }

}
