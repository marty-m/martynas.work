package work.martynas.lens.bucket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudFlareR2Config {

    @Bean
    public CloudFlareR2Client cloudFlareR2Client(
            @Value("${cloudflare.r2.account-id}") String accountId,
            @Value("${cloudflare.r2.access-key}") String accessKey,
            @Value("${cloudflare.r2.secret-key}") String secretKey,
            @Value("${cloudflare.r2.bucket-domain}") String publicDomain
    ) {
        CloudFlareR2Client.S3Config config = new CloudFlareR2Client.S3Config(
                accountId, accessKey, secretKey, publicDomain
        );
        return new CloudFlareR2Client(config);
    }
}